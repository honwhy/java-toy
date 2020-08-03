package com.github.honwhy.toy.join;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListCollector<T> implements MyCollector<T> {
    List<T> list = new CopyOnWriteArrayList<>();

    @Override
    public void collectList(T t) {
        if (Objects.nonNull(t)) {
            list.add(t);
        }
    }

    @Override
    public List<T> retList() {
        return list;
    }
}
