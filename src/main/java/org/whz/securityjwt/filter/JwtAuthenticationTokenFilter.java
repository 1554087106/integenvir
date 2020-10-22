package org.whz.securityjwt.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.whz.securityjwt.service.UserDetailService;
import org.whz.securityjwt.utils.JwtTokenUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * JWT登录授权过滤器
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Value("${jwt.token-header}")
    private String tokenHeader;
    @Value("${jwt.token-head}")
    private String tokenHead;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info("headerName: {}", headerName);
        }
        if(authHeader != null && authHeader.startsWith(this.tokenHead)) {
            // "Bearer "后面的token内容
            String authToken = authHeader.substring(this.tokenHead.length());
            String userName = jwtTokenUtils.getUserNameFromToken(authToken);
            log.info("从token中解析的UserName :{}", userName);
            if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailService.loadUserByUsername(userName);
                if(jwtTokenUtils.validateToken(authToken, userDetails)) {
                    // Token验证通过
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    log.info("security中保存的用户名: {}", userName);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}