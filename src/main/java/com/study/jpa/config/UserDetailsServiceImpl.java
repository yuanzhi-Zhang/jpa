package com.study.jpa.config;

import com.study.jpa.entity.Customer;
import com.study.jpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * @Author: 张远志
 * @Date: 2020/5/11 16:12
 */

@Component("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名为：" + username);
        Customer customer = customerRepository.findByFirstName(username);
        log.info(String.valueOf(customer));
        //找不到的异常抛出
        if (Objects.isNull(customer)) {
            throw new UsernameNotFoundException("Customer " + username + " was not found in db");
        }
        String encode = passwordEncoder.encode(customer.getPassword());
        //角色设置
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(customer.getRole());
        grantedAuthorities.add(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(username,
                encode, grantedAuthorities);
    }
}
