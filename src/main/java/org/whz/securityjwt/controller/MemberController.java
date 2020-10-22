package org.whz.securityjwt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whz.securityjwt.common.CommonResult;
import org.whz.securityjwt.dto.TelephoneDTO;
import org.whz.securityjwt.dto.TelephoneVerifyDTO;
import org.whz.securityjwt.service.MemberService;

@RestController
@Slf4j
@Api(tags = "会员登录验证", value = "MemberController")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/auth/code")
    @ApiOperation("通过手机号获取验证码")
    public CommonResult getAuthCode(@RequestBody TelephoneDTO req) {
        log.info("接收验证码的手机号码: {}", req.getTelephone());
        return memberService.gengerateAuthCode(req.getTelephone());
    }

    @PostMapping(value = "/verify/auth/code")
    @ApiOperation("验证码校验")
    public CommonResult verifyAuthCode(@RequestBody TelephoneVerifyDTO telephoneVerifyDTO) {
        return memberService.verifyAuthCode(telephoneVerifyDTO.getTelephone(), telephoneVerifyDTO.getAuthCode());

    }



}
