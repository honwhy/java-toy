package com.github.honwhy.toy.join;

import com.github.honwhy.toy.join.MyCollector;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NoMeaningCollector implements MyCollector<String> {
    private List<String> list = new CopyOnWriteArrayList<>();

    @Override
    public void collectList(String s) {
        list.add(s);
    }

    @Override
    public List<String> retList() {
        return list;
    }
}
