package org.whz.securityjwt.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.whz.securityjwt.model.UmsAdmin;

@SpringBootTest
@Slf4j
public class UmsAdminMapperTest {
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Test
    public void setUp() {
        log.info("umsAdminMapper: {}", umsAdminMapper);
    }
    @Test
    public void selectByUsernameTest() {
        UmsAdmin umsAdmin = umsAdminMapper.selectUmsAdminByUsername("test");
        log.info("umsAdmin: {}", umsAdmin);
    }

    @Test
    public void insertSelectiveTest() {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("whz");
        umsAdmin.setPassword("root");
        umsAdmin.setNote("测试注册用户");
        umsAdmin.setNickName("w");
        umsAdmin.setEmail("1554087106@qq.com");
        int insert = umsAdminMapper.insertSelective(umsAdmin);
        log.info("insert: {}", insert);
    }

    @Test
    public void hasUsernameTest() {
//        int count = umsAdminMapper.hasUsername("whz");
//        log.info("count: {}", count);
    }
}