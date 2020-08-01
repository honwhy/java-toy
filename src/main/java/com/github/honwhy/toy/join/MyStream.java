package com.github.honwhy.toy.join;

import java.util.List;

public interface MyStream<T,V> {

    List<T> toList(List<MyProvider<T,V>> providers, V v);
}
