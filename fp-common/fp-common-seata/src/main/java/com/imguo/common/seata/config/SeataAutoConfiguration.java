package com.imguo.common.seata.config;


import com.imguo.common.core.factory.YamlPropertySourceFactory;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = "classpath:seata-config.yml", factory = YamlPropertySourceFactory.class)
@EnableAutoDataSourceProxy
@Configuration(proxyBeanMethods = false)
public class SeataAutoConfiguration {

}
