package com.zpself.module01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by zengpeng on 2019/3/28
 */
//@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("sdasda");
        System.out.println("sdasda");
        System.out.println("sdasda");
        return new User(username,passwordEncoder.encode("123456"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
