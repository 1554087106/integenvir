package org.whz.securityjwt.service;

import org.whz.securityjwt.common.CommonResult;

/**
 * 会员管理
 */
public interface MemberService {
    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    CommonResult gengerateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
