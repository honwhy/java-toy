package com.github.honwhy.toy.comb;

import com.github.honwhy.toy.TypeNumberParam;
import com.github.honwhy.toy.join.DoubleToStringProvider;
import com.github.honwhy.toy.join.IntToStringProvider;
import com.github.honwhy.toy.join.MyProvider;

public class CompositedProvider implements MyProvider<String, TypeNumberParam> {

    @Override
    public String provide(TypeNumberParam typeNumberParam) {
        String type = typeNumberParam.getType();
        switch (type) {
            case "Integer":
                return new IntToStringProvider().provide(typeNumberParam);
            case "Double":
                return new DoubleToStringProvider().provide(typeNumberParam);
            default:
        }
        return null;
    }
}
