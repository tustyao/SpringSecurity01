package com.sense.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by 要 on 2017/6/18.
 */
@EnableWebMvc
@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = {"com.sense"})
/**
 * 继承{@link WebMvcConfigurerAdapter} +@EnableWebMvc
 * 优先级大于
 * 继承 {@link WebMvcConfigurationSupport}+@Configuration
 * 一般@EnableWebMvc注解开启的mvc功能足够满足我们需求，当不能满足需要定制时使用第二种
 *
 * 注：使用第二种时，子类需要使用@Configuration注解，方法使用@Bean注解
 */
public class WebAppConfig extends WebMvcConfigurerAdapter {
    /**
     * 启用servlet容器的内置默认servlet容器，用来出来静态资源被拦截的问题
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver("/",".jsp"));
    }
}
