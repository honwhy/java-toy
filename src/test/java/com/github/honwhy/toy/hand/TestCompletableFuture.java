package com.github.honwhy.toy.hand;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
public class TestCompletableFuture extends BaseTest {

    @Test
    public void test1() {
        CompletableFuture<String> r1 = CompletableFuture.supplyAsync(() -> new IntToStringCallable(numberParam).call());
        CompletableFuture<String> r2 = CompletableFuture.supplyAsync(() -> new DoubleToStringCallable(numberParam).call());
        try {
            List<String> ret = new ArrayList<>();
            ret.add(r1.get());
            ret.add(r2.get());
            log.info("ret=" + ret);
        } catch (Exception ignore) {

        }
    }
}
