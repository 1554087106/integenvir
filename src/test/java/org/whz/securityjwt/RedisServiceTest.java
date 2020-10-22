package org.whz.securityjwt;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.whz.securityjwt.service.RedisService;

@SpringBootTest
@Slf4j
public class RedisServiceTest {
    @Autowired
    private RedisService redisService;
    @Test
    public void setUpTest() {
        log.info("redisService: {}", redisService);
    }

    @Test
    public void userRedisTest() {
        redisService.set("name", "whz");
        String name = redisService.get("name");
        log.info("name: {}", name);
    }
}