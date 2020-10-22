package org.whz.securityjwt.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.whz.securityjwt.mapper.UmsAdminMapper;
import org.whz.securityjwt.mapper.UmsAdminRoleRelationMapper;
import org.whz.securityjwt.mapper.UmsPermissionMapper;
import org.whz.securityjwt.model.UmsAdmin;
import org.whz.securityjwt.model.UmsPermission;
import org.whz.securityjwt.service.UmsAdminService;
import org.whz.securityjwt.service.UserDetailService;
import org.whz.securityjwt.utils.JwtTokenUtils;
import java.util.Set;

@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
    @Override
    public UmsAdmin getAdminByUsername(String userName) {
        return umsAdminMapper.selectUmsAdminByUsername(userName);
    }

    @Override
    public Set<UmsPermission> getPermissionSet(Long adminId) {
        // 获取该用户的权限
        // ums_role_permission_relation 中的权限
        // 使用Set首先重写对象中的equals和hashCode
        Set<UmsPermission> umsPermissionList = umsPermissionMapper.selectPermissionByRole(adminId);
        // ums_admin_permission_relation type = 1 加项
        Set<UmsPermission> add_umsPermissionList = umsPermissionMapper.selectPermissionByUserAdd(adminId);
        // ums_admin_permission_relation type = 0 减项
        Set<UmsPermission> red_umsPermissionList = umsPermissionMapper.selectPermissionByUserRed(adminId);
        umsPermissionList.addAll(add_umsPermissionList);
        umsPermissionList.removeAll(red_umsPermissionList);
        return umsPermissionList;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        // 查询是否已经存在用户名
        int count = umsAdminMapper.countUsername(umsAdminParam.getUsername());
        if(count > 0) {
            return null;
        }
        // 用户密码加密码
        String encodePassword = passwordEncoder.encode(umsAdminParam.getPassword());
        umsAdminParam.setPassword(encodePassword);
        umsAdminMapper.insertSelective(umsAdminParam);
        return umsAdminParam;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            log.info("前端传入的username: {} password: {}", username, password);
            UserDetails userDetails = userDetailService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtils.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.error("登录异常: {}", e.getMessage());
        }
        return token;
    }
}