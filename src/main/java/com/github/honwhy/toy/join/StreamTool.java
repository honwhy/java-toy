package com.github.honwhy.toy.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public final class StreamTool {

    static Executor executor = Executors.newFixedThreadPool(4);

    @SuppressWarnings("CatchMayIgnoreException")
    public static <T,V> List<T> toList(List<MyProvider<T, V>> myProviders, V v) {
        ListCollector<T> collectorTool = new ListCollector<>();
        List<CompletableFuture<Void>> pfs = new ArrayList<>(myProviders.size());
        for (MyProvider<T, V> provider : myProviders) {
            CompletableFuture<Void> pf = CompletableFuture.runAsync(() -> collectorTool.collectList(provider.provide(v)), executor);
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
        return collectorTool.retList();
    }
}
