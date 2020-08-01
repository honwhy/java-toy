package com.github.honwhy.toy.join;

import com.github.honwhy.toy.NumberParam;

public class IntToStringProvider implements MyProvider<String,NumberParam> {

    @Override
    public String provide(NumberParam param) {
        return Integer.toHexString(param.getAge());
    }
}
