package com.github.honwhy.toy.join;

public interface MyProvider<T,V> {
    T provide(V v);
}
