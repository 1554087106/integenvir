package org.whz.securityjwt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whz.securityjwt.common.CommonResult;
import org.whz.securityjwt.nosql.elasticsearch.document.EsProduct;
import org.whz.securityjwt.service.EsProductService;

import java.util.Objects;

/**
 * 搜索商品管理
 */
@RestController
@Api(tags = "搜索商品管理", value = "EsProductController")
@RequestMapping("/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @PostMapping(value = "/importAll")
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }
    @ApiOperation(value = "根据ID创建商品")
    @PostMapping(value = "/create/{id}")
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if(Objects.nonNull(esProduct)) {
            return CommonResult.success(esProduct);
        } else {
            return CommonResult.failed("ID为: "+ id +"的商品创建失败");
        }
    }

}