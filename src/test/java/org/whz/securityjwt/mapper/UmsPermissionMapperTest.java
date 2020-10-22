package org.whz.securityjwt.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.whz.securityjwt.model.UmsAdmin;
import org.whz.securityjwt.model.UmsPermission;

import java.util.List;

@SpringBootTest
@Slf4j
public class UmsPermissionMapperTest {
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    @Test
    public void setUp() {
        log.info("umsPermissionMapper: {}", umsPermissionMapper);
    }

    @Test
    public void selectPermissionByRoleTest() {

    }



}