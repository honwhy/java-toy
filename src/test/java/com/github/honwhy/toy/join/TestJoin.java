package com.github.honwhy.toy.join;

import com.github.honwhy.toy.NumberParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestJoin {

    @Test
    public void testStream() {
        NumberParam numberParam = new NumberParam();
        numberParam.setAge(29);
        numberParam.setMoney(20_000.43);

        MyProvider<String,NumberParam> p1 = new IntToStringProvider();
        MyProvider<String,NumberParam> p2 = new DoubleToStringProvider();
        List<MyProvider<String, NumberParam>> providers = Arrays.asList(p1, p2);
        MyStream<String, NumberParam> myStream = new CollectStringStream();

        List<String> strings = myStream.toList(providers, numberParam);
        log.info("ret=" + strings);
    }
}
