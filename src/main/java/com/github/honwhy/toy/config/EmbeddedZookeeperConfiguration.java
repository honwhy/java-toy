package com.github.honwhy.toy.config;

import lombok.SneakyThrows;
import org.apache.curator.test.TestingServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedZookeeperConfiguration {

    @SneakyThrows
    @Bean
    //@ConditionalOnProperty(prefix="spring.profiles", name="active", havingValue = "dev")
    @ConditionalOnExpression("#{systemProperties['spring.profiles.active'] == 'local' || systemProperties['spring.profiles.active'] == 'dev'}")
    public TestingServer testingServer(@Value("${spring.zookeeper.port}")Integer port) {
        TestingServer testingServer = new TestingServer(port, false);
        testingServer.start();
        return testingServer;
    }
}
