package org.whz.securityjwt.utils;

import com.google.common.collect.Maps;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * JwtToken生成的工具类
 * 1. 生成Token
 * 2. 解析Token
 * 3. 刷新并返回新Token
 * 4. 判断当前Token能否被刷新
 */
@Component
@Slf4j
public class JwtTokenUtils {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 从Token中获取登录用户名
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        log.info("getUserNameFromToken -> token : {}", token);
        return claims.getSubject();
    }

    /**
     * 从token中获取JWT中的负载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        log.info("getClaimsFromToken -> secret: {}", secret);
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 根据用户信息生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = Maps.newHashMapWithExpectedSize(2);
        // 用户名
        log.info("generateToken -> username :{}", userDetails.getUsername());
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        // 当前时间
        claims.put(CLAIM_KEY_CREATED, LocalDate.now());
        return generateToken(claims);
    }
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成token过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 验证token是否有效
     * 1. 判断Token中包含的username信息与SpringSecurity中的username是否相等
     * 2. 判断Token信息中的过期时间是否在当前时间
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return StringUtils.equals(username, userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否已经失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpireDateFromToken(token);
        return new Date().after(expireDate);
    }

    /**
     * 从token中获取设定的过期时间
     * @param token
     * @return
     */
    private Date getExpireDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        // 获取设定好的Token过期时间
        return claims.getExpiration();
    }

    /**
     * 若token未过期则可以刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token) {
        log.info("当前Token是否已经过期: {}", !isTokenExpired(token));
        return !isTokenExpired(token);
    }

    /**
     * 刷新token 返回一个新的Token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put("CLAIM_KEY_CREATED", LocalDate.now());
        log.info("新生成的Token: {}", generateToken(claims));
        return generateToken(claims);
    }
}
