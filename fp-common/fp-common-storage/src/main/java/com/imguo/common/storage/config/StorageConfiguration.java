package com.imguo.common.storage.config;

import com.imguo.common.storage.enums.StorageTypeEnum;
import com.imguo.common.storage.properties.StorageProperties;
import com.imguo.common.storage.service.AliyunStorageService;
import com.imguo.common.storage.service.LocalStorageService;
import com.imguo.common.storage.service.StorageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 存储配置文件
 *
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class StorageConfiguration {

    @Bean
    public StorageService storageService(StorageProperties properties){
        if(properties.getConfig().getType() == StorageTypeEnum.LOCAL){
            return new LocalStorageService(properties);
        }else if(properties.getConfig().getType() == StorageTypeEnum.ALIYUN){
            return new AliyunStorageService(properties);
        }

        return null;
    }

}
