package com.sense.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

/**
 * Created by 要 on 2017/6/20.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //基于jdbc
        auth.jdbcAuthentication().dataSource(dataSource);
                //authoritiesByUsernameQuery("select * from t_user where username='tustyao'");
        //基于内存
        //  auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        //   auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //如果启用csrf验证，则form表单必须传递如下参数
        // <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
//        http.csrf().disable();
        /**
         * 匹配器 antMatcher 支持通配符，urlMapping配置了servletPath(/v/*)或者后缀(*.do)时，需要加上
         * 匹配器 mvcMatcher 不支持通配符，但是不用写servletPath或者后缀
         */

        // http.authorizeRequests().antMatchers("/sys/login").permitAll().and()

        http.authorizeRequests().

                antMatchers("/user").hasRole("USER").

                antMatchers("/admin").hasRole("ADMIN").
                antMatchers("/**/*.html").permitAll().
                anyRequest().authenticated().
                and().
                formLogin().loginPage("/sys/login").loginProcessingUrl("/doLogin").
                failureForwardUrl("/fail.jsp").successForwardUrl("/success.jsp").
                //配置默认的成功页面 登陆页面成功登陆后将重定向到配置的页面
                        defaultSuccessUrl("/index.jsp").permitAll().
                and().
//              logout().
//                //退出时执行
//                addLogoutHandler((req, resp, auth) -> {System.out.println("log out ing");}).
//                clearAuthentication(true).
//                invalidateHttpSession(true);
                //自定义logoutUrl和logoutSuccessUrl一定记得设置权限，否则默认跳转至登陆页面
                        logout().logoutUrl("/custom/logout").logoutSuccessUrl("/logout.jsp").permitAll();
    }
}
