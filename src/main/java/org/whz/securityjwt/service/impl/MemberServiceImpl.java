package org.whz.securityjwt.service.impl;


import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.whz.securityjwt.common.CommonResult;
import org.whz.securityjwt.common.ResultCode;
import org.whz.securityjwt.service.MemberService;
import org.whz.securityjwt.service.RedisService;

import java.util.Optional;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Autowired
    private RedisService redisService;
    @Value("${spring.redis.key.prefix.auth-code}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${spring.redis.key.expire.auth-code}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Override
    public CommonResult<String> gengerateAuthCode(String telephone) {
        String code = IdUtil.randomUUID();
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, code);
        log.info("存入Redis的验证码前缀: {}, 验证码: {}", REDIS_KEY_PREFIX_AUTH_CODE + telephone, code);
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(code,"验证码获取成功");
    }

    @Override
    public CommonResult<String> verifyAuthCode(String telephone, String authCode) {
        if(StringUtils.isEmpty(authCode)) {
            return CommonResult.failed(ResultCode.VALIDATE_FAILED, "验证码不能为空");
        }
        Optional<String> codeOpt = Optional.ofNullable(redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone));
        if(codeOpt.orElse("").equals(authCode)) {
            return CommonResult.success("验证码正确");
        }
        return CommonResult.failed("验证码错误或超时");
    }
}
