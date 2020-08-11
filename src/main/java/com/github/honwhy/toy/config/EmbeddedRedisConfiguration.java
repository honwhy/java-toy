package com.github.honwhy.toy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

@Configuration
public class EmbeddedRedisConfiguration {

    @Bean
    @ConditionalOnExpression("#{systemProperties['spring.profiles.active'] == 'local' || systemProperties['spring.profiles.active'] == 'dev'}")
    public RedisServer redisServer(@Value("${spring.redis.port}")Integer port) {
        RedisServer redisServer = new RedisServer(port);
        redisServer.start();
        return redisServer;
    }
}
