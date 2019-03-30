package com.zpself.module01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by zengpeng on 2019/3/28
 */
//@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hello.html")
                .permitAll()//注意这里hello.html需要配置成不需要身份认证，否则会报重定向次数过多
                .antMatchers("/success.html")
                .permitAll()//注意这里hello.html需要配置成不需要身份认证，否则会报重定向次数过多

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

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
