package com.imguo.common.storage.properties;

import lombok.Data;
import com.imguo.common.storage.enums.StorageTypeEnum;

/**
 * 存储配置项
 *
 */
@Data
public class StorageProperties {
    /**
     * 是否开启存储
     */
    private boolean enabled;
    /**
     * 通用配置项
     */
    private StorageConfig config;
    /**
     * 本地配置项
     */
    private LocalStorageProperties local;
    /**
     * 阿里云配置项
     */
    private AliyunStorageProperties aliyun;

    @Data
    public static class StorageConfig{
        /**
         * 访问域名
         */
        private String domain;
        /**
         * 配置路径前缀
         */
        private String prefix;
        /**
         * 存储类型
         */
        private StorageTypeEnum type;
    }
}
