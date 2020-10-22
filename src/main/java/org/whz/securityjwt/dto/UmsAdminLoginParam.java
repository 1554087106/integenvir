package org.whz.securityjwt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UmsAdminLoginParam", description = "用户登录参数对象")
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "username", notes = "用户名")
    private String username;
    @ApiModelProperty(value = "password", notes = "密码")
    private String password;
}