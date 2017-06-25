package com.sense.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 要 on 2017/6/20.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /**
         * 匹配器 antMatcher 支持通配符，urlMapping配置了servletPath(/v/*)或者后缀(*.do)时，需要加上
         * 匹配器 mvcMatcher 不支持通配符，但是不用写servletPath或者后缀
         */

        // http.authorizeRequests().antMatchers("/sys/login").permitAll().and()

        http.formLogin().loginPage("/sys/login").loginProcessingUrl("/doLogin").
                failureForwardUrl("/fail.jsp").successForwardUrl("/success.jsp").
                //配置默认的成功页面 登陆页面成功登陆后将重定向到配置的页面
                defaultSuccessUrl("/index.jsp").
                permitAll();
        http.authorizeRequests().antMatchers("/user").hasRole("USER");
        http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/**/*.html").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
