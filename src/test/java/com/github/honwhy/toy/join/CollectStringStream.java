package com.github.honwhy.toy.join;

import com.github.honwhy.toy.NumberParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CollectStringStream implements MyStream<String, NumberParam> {

    Executor executor = Executors.newFixedThreadPool(4);

    @Override
    public List<String> toList(List<MyProvider<String, NumberParam>> myProviders, NumberParam param) {
        MyCollector<String> myCollector = new NoMeaningCollector();
        List<CompletableFuture<Void>> pfs = new ArrayList<>(myProviders.size());
        for (MyProvider<String, NumberParam> provider : myProviders) {
            CompletableFuture<Void> pf = CompletableFuture.runAsync(() -> myCollector.collectList(provider.provide(param)), executor);
            pfs.add(pf);
        }
        try {
            CompletableFuture.allOf(pfs.toArray(new CompletableFuture[0])).get(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (e instanceof TimeoutException) {
                pfs.forEach(p -> {
                    if (!p.isDone()){
                        p.cancel(true);
                    }});
            }
        }
        return myCollector.retList();
    }
}
