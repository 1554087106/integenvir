package org.whz.securityjwt;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.whz.securityjwt.utils.JwtTokenUtils;

@Slf4j
@SpringBootTest
public class JwtTokenUtilsTest {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Test
    public void setUp() {
        log.info("jwtTokenUtils: {}", jwtTokenUtils);
    }

    @Test
    public void userRedis() {

    }
}