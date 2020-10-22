package org.whz.securityjwt.controller;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.whz.securityjwt.common.CommonResult;
import org.whz.securityjwt.dto.UmsAdminLoginParam;
import org.whz.securityjwt.model.UmsAdmin;
import org.whz.securityjwt.model.UmsPermission;
import org.whz.securityjwt.service.UmsAdminService;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 后台用户管理
 */
@Slf4j
@RestController
@Api(tags = "后台用户管理", value = "UmsAdminController")
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;

    @Value("${jwt.token-header}")
    private String tokenHeader;
    @Value("${jwt.token-head}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if(Objects.isNull(umsAdmin)) {
            return CommonResult.failed();
        }

        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "/登录以后返回token")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if(StringUtils.isBlank(token)) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        HashMap<String, String> tokenMap = Maps.newHashMapWithExpectedSize(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
    @ApiOperation(value = "获取用户所有权限(包括+-权限)")
    @PostMapping(value = "/permission/{adminId}")
    public CommonResult<Set<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        Set<UmsPermission> permissionSet = adminService.getPermissionSet(adminId);
        log.info("permissionSet: {}", permissionSet);
        return CommonResult.success(permissionSet);
    }

}