package org.whz.securityjwt.service;

import org.whz.securityjwt.model.UmsAdmin;
import org.whz.securityjwt.model.UmsPermission;
import java.util.Set;

public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String userName);
    Set<UmsPermission> getPermissionSet(Long adminId);
    UmsAdmin register(UmsAdmin umsAdminParam);
    // 生成JWT的token
    String login(String username, String password);
}