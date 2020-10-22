package org.whz.securityjwt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="PmsBrandReq",description="客户商标")
public class PmsBrandReq {
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;
}
