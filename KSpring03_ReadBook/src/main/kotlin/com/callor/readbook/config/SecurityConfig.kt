package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
@EnableWebSecurity // 사용자가 SpringSecurity custom 하겠다
class SecurityConfig:WebSecurityConfigurerAdapter(){

    override fun configure(http: HttpSecurity) {
        // http 모든 요청 가로채기
        http.authorizeRequests()
            .mvcMatchers("/**")// 모든 request 에 대하여
            .anonymous()// 누구나
            .mvcMatchers("/admin/**")
            .fullyAuthenticated()
    }
}