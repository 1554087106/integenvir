package org.whz.securityjwt.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {
    /**
     * 通过用户名查找用户
     * @param userName 用户名
     * @return
     */
    UserDetails loadUserByUsername(String userName);
}