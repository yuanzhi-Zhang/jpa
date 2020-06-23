package com.study.jpa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author: 张远志
 * @Date: 2020/5/11 14:29
 */

@RestController
@RequestMapping("/main")
public class MainController {

	/**
	 * 获取当前登录用户信息（通过SecurityContextHolder获取用户信息）
	 */
	@GetMapping("/info")
	public String productInfo() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		// credentials密码已经被清除了（为了防止泄露），所以输出是null
		Object credentials = authentication.getCredentials();
		String username = authentication.getName();
		Collection<? extends GrantedAuthority> authorities = authentication
				.getAuthorities();
		return " 正在访问的用户是： " + username + "，身份是：" + authorities + "，密码是："
				+ credentials;
	}

}
