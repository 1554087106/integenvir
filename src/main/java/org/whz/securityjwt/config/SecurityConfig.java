package org.whz.securityjwt.config;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.whz.securityjwt.component.AdminUserDetail;
import org.whz.securityjwt.filter.JwtAuthenticationTokenFilter;
import org.whz.securityjwt.component.RestAuthenticationEntryPoint;
import org.whz.securityjwt.component.RestfulAccessDeniedHandler;
import org.whz.securityjwt.model.UmsAdmin;
import org.whz.securityjwt.model.UmsPermission;
import org.whz.securityjwt.service.UmsAdminService;
import org.whz.securityjwt.service.UserDetailService;

import java.util.Objects;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
            .disable() // 禁用csrf
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET,
                    "/",  // 允许对于网站静态资源的无授权访问
                    "/*.html",
                    "favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js",
                    "/webjars/**")
            .permitAll()
            .antMatchers("/admin/login", // 对登录注册要允许匿名访问
                    "/admin/register",
                    "/hello")
            .permitAll()
            .antMatchers("/swagger-ui/").permitAll().antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/v3/api-docs").permitAll().antMatchers("/configuration/ui").permitAll()
            .anyRequest() // 除上面之外的所有请求全部需要鉴权认证
            .authenticated();
        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                    .accessDeniedHandler(restfulAccessDeniedHandler) // 没有访问权限
                    .authenticationEntryPoint(restAuthenticationEntryPoint); // 未登录


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }
    @Bean
    public UserDetailService userDetailService() {
        return userName -> {
            UmsAdmin admin = umsAdminService.getAdminByUsername(userName);
            if(Objects.nonNull(admin)) {
                Set<UmsPermission> permissionSet = umsAdminService.getPermissionSet(admin.getId());
                return new AdminUserDetail(admin, Lists.newArrayList(permissionSet));
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }


}
