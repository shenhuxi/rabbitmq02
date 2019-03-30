package com.zpself.module02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by zengpeng on 2019/3/25
 */
/*@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)*/
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and().formLogin()
                    .loginPage("/hello.html")
                   // .loginProcessingUrl("/admin/login")
                    .permitAll()
                    .defaultSuccessUrl("/success.html", true)
                .and().logout().logoutUrl("/logout")
                .and().sessionManagement().maximumSessions(1).expiredUrl("/expired")
                .and()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        //for (String url : dxApiGateWateProperties.getUrls().getNoAuth()) {
        registry.antMatchers("/success.html").permitAll();//url过滤掉权限的路径
        //registry.antMatchers("/login").permitAll();//url过滤掉权限的路径
        // }
        registry.anyRequest()
                .access("@PermissionService.hasPermission(request,authentication)");



      /*  http.authorizeRequests()
                .antMatchers("/hello.html")
                .permitAll()//注意这里hello.html需要配置成不需要身份认证，否则会报重定向次数过多
                .antMatchers("/success.html")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/hello.html")//指定我们自己的登录页面
                .loginProcessingUrl("/admin/login")//指定让UsernamePasswordAuthenticationFilter拦截器拦截的路径
                .defaultSuccessUrl("/success.html")//默认登录成功后跳转的页面
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
               *//* .and()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");*/
    }

}
