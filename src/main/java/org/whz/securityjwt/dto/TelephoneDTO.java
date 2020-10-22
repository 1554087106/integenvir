package org.whz.securityjwt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TelephoneDTO", description = "手机获取验证码")
public class TelephoneDTO {
    @ApiModelProperty(value = "telephone", name = "手机号")
    private String telephone;
}
