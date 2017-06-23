package com.sense.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by 要 on 2017/6/20.
 */

/**
 * spring security的初始化类  初始化springSecurityFilterChain，当使用springmvc时，则使用默认构造器
 * 否则重写默认构造器，调用父类带参构造器，将实例化ContextLoaderListener加载security的配置
 */
public class WebAppSecurityInitializer extends AbstractSecurityWebApplicationInitializer {


}
