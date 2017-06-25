package com.sense.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by 要 on 2017/6/18.
 * 注册DispatcherServlet
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置 ApplicationContext.xml 即web.xml 中ContextLoaderListener加载的配置文件
     * 通常用 <context-param><context-param/>配置
     *
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringContextConfig.class,WebSecurityConfig.class};
    }

    /**
     * 配置 {@code DispatcherServlet} 加载的配置文件 dispatcherServlet.xml
     *
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    /**
     * Specify the servlet mapping(s) for the {@code DispatcherServlet}
     * 相当于<url-pattern></url-pattern>
     * 01,扩展名匹配 *.do *.action *.jsp
     * 02,路径匹配 /* /a/b/*
     * 03,精确匹配 /a/b/c.html
     * 04，缺省匹配 /
     * 精确匹配 > 路径匹配 > 扩展名匹配 > 缺省匹配
     * <p>
     * 注：扩展名和路径匹配不能同时设置 如/usr/*.jsp
     * <p>
     * / 与 /*的异同：
     * <p>
     * /*是路径匹配，优先级较高，几乎所有请求都匹配，所以不是好的选择，很多404错误都是它引起的
     * / 是特殊的匹配，不会覆盖其他的servlet，有且仅有一个实例，但是会覆盖servlet容器中默认的servlet，同样可以匹配所有请求
     * / 拦截所有请求，但是不拦截jsp页面，因为servlet容器内置*.jsp匹配器优先级高于缺省的的servlet
     * <p>
     * 注：/和/*均拦截静态资源，所以若配置它俩，需要对静态资源作特殊处理，如配置servlet容器的默认servlet
     *
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
