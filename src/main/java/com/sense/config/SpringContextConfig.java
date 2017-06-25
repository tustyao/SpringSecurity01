package com.sense.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.*;
import java.util.Properties;

/**
 * Created by yaoqf on 2017/6/25.
 */
@Configuration
@ComponentScan(basePackages = {"com.sense.service"})
public class SpringContextConfig {
    private static final Logger logger = LoggerFactory.getLogger(SpringContextConfig.class);
    private static final Properties properties = new Properties();

    static {

        try {
            Resource is = new ClassPathResource("db.properties");//ResourceUtils.getFile("classpath:db.properties");
            properties.load(is.getInputStream());
        } catch (IOException e) {
            logger.error("spring load datasource config file [db.properties] error", e);
        }
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource(false);

        dataSource.setUsername(properties.getProperty("druid.username"));
        dataSource.setUrl(properties.getProperty("druid.url"));
        dataSource.setPassword(properties.getProperty("druid.password"));
        dataSource.setDriverClassName(properties.getProperty("druid.driverClassName"));
        dataSource.setConnectProperties(properties);
        return dataSource;
    }
}
