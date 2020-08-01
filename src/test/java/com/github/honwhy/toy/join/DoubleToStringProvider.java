package com.github.honwhy.toy.join;

import com.github.honwhy.toy.NumberParam;

public class DoubleToStringProvider implements MyProvider<String,NumberParam> {
    @Override
    public String provide(NumberParam param) {
        return Double.toHexString(param.getMoney());
    }
}
