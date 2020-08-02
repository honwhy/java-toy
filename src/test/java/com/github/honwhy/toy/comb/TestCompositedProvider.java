package com.github.honwhy.toy.comb;

import com.github.honwhy.toy.TypeNumberParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class TestCompositedProvider {

    TypeNumberParam typeNumberParam;
    CompositedProvider compositedProvider = new CompositedProvider();

    @BeforeEach
    public void before() {
        typeNumberParam = new TypeNumberParam();
        typeNumberParam.setAge(29);
        typeNumberParam.setMoney(20_000.43);
    }

    @Test
    public void test1() {
        typeNumberParam.setType("Integer");
        String ret = compositedProvider.provide(typeNumberParam);
        log.info("ret=" + ret);
    }

    @Test
    public void test2() {
        typeNumberParam.setType("Double");
        String ret = compositedProvider.provide(typeNumberParam);
        log.info("ret=" + ret);
    }
}
