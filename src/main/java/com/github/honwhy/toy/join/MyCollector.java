package com.github.honwhy.toy.join;

import java.util.List;

public interface MyCollector<T> {

    void collectList(T t);

    List<T> retList();
}
