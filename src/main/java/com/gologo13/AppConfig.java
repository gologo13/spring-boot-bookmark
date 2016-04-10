package com.gologo13;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by yohei on 4/10/16.
 */
@Configuration
public class AppConfig {

    @Autowired
    private DataSourceProperties properties;

//    private DataSource _dataSource;

//    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
//    @Bean(destroyMethod = "close")
    @Bean
    DataSource realDataSource() {
        DataSourceBuilder builder = DataSourceBuilder
                .create(properties.getClassLoader())
                .password(properties.getPassword())
                .username(properties.getUsername())
                .url(properties.getUrl());
        return new Log4jdbcProxyDataSource(builder.build());
    }

}
