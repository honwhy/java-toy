package com.github.honwhy.toy.join;

public class DoubleToStringProvider implements MyProvider<String,NumberParam> {
    @Override
    public String provide(NumberParam param) {
        return Double.toHexString(param.getMoney());
    }
}
