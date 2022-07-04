package com.imguo.common.job.annotation;

import com.imguo.common.job.config.FpBeanDefinitionRegistrar;
import com.imguo.common.job.config.XxlJobConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * xxlJob注解
 *
 * @author lijx
 * @since 2022/5/19 15:18
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({XxlJobConfig.class, FpBeanDefinitionRegistrar.class})
public @interface FpEnableXxlJob {}
