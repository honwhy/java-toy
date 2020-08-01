package com.github.honwhy.toy.hand;

import com.github.honwhy.toy.NumberParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class TestMyCallable extends BaseTest {

    @Test
    public void test1() {

        FutureTask<String> r1 = new FutureTask<>(new IntToStringCallable(numberParam));
        new Thread(r1).start();
        FutureTask<String> r2 = new FutureTask<>(new DoubleToStringCallable(numberParam));
        new Thread(r2).start();
        try {
            List<String> ret = new ArrayList<>();
            ret.add(r1.get());
            ret.add(r2.get());
            log.info("ret=" + ret);
        } catch (Exception ignore) {

        }
    }
    @Test
    public void test2() {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<String> r1 = threadPool.submit(new IntToStringCallable(numberParam));
        Future<String> r2 = threadPool.submit(new DoubleToStringCallable(numberParam));
        try {
            List<String> ret = new ArrayList<>();
            ret.add(r1.get());
            ret.add(r2.get());
            log.info("ret=" + ret);
        } catch (Exception ignore) {

        }
    }


}
