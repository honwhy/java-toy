package com.github.honwhy.toy.hand;

import com.github.honwhy.toy.NumberParam;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.Callable;

public class BaseTest {

    protected NumberParam numberParam;

    @BeforeEach
    public void before() {
        numberParam = new NumberParam();
        numberParam.setAge(29);
        numberParam.setMoney(20_000.43);
    }

    protected class IntToStringCallable implements Callable<String> {
        private final NumberParam param;

        IntToStringCallable(NumberParam numberParam) {
            this.param = numberParam;
        }
        @Override
        public String call() {
            return Integer.toHexString(param.getAge());
        }
    }

    protected class DoubleToStringCallable implements Callable<String> {

        private final NumberParam param;

        DoubleToStringCallable(NumberParam numberParam) {
            this.param = numberParam;
        }
        @Override
        public String call() {
            return Double.toHexString(param.getMoney());
        }
    }
}
