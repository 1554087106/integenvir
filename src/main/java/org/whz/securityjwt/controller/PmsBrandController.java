package org.whz.securityjwt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.whz.securityjwt.common.CommonResult;
import org.whz.securityjwt.dto.PmsBrandReq;
import org.whz.securityjwt.model.PmsBrand;
import org.whz.securityjwt.service.BrandService;
import java.util.List;

/**
 * 品牌管理
 */
@Slf4j
@RestController
@Api(tags = "品牌管理", value = "PmsBrandController")
public class PmsBrandController {

    @ApiOperation("查看Swagger文档")
    @RequestMapping(value = "/swaggerDemo", method = RequestMethod.GET)
    public CommonResult<String> swaggerDemo(@RequestBody PmsBrandReq req) {
        return CommonResult.success("this is swagger");
    }

    @ApiOperation("hello接口")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public CommonResult<String> hello() {
        log.info("hello V6.0");
        return CommonResult.success("hello V6.0");
    }
    @PreAuthorize("hasAnyAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(null);
    }
}
