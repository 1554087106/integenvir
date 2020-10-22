package org.whz.securityjwt.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.whz.securityjwt.model.UmsPermission;

import java.util.Set;

@Slf4j
@SpringBootTest
public class UmsAdminServiceTest {
    @Autowired
    private UmsAdminService umsAdminService;
    @Test
    public void setUp() {
        log.info("umsAdminService: {}", umsAdminService);
    }

    @Test
    public void getPermissionListTest() {
        Set<UmsPermission> permissionSet = umsAdminService.getPermissionSet(1L);
        permissionSet.forEach((umsPermission) -> {
            log.info("umsPermission: {}", umsPermission);
        });
    }

}