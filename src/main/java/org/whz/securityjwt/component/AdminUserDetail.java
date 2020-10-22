package org.whz.securityjwt.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.whz.securityjwt.model.UmsAdmin;
import org.whz.securityjwt.model.UmsPermission;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * security组件 用于配置用户名,密码获取,权限以及账号状态的获取策略
 */
public class AdminUserDetail implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;

    public AdminUserDetail(UmsAdmin umsAdmin, List<UmsPermission> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 返回用户当前权限
        return permissionList.stream()
                             .filter(permission -> permission.getValue() != null)
                             .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                             .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals("1", umsAdmin.getStatus().toString());
    }
}
