package org.whz.securityjwt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TelephoneVerifyDTO", description = "手机号码验证DTO")
public class TelephoneVerifyDTO {
    @ApiModelProperty(name = "手机号", value = "telephone")
    private String telephone;
    @ApiModelProperty(name = "验证码", value = "authCode")
    private String authCode;
}
