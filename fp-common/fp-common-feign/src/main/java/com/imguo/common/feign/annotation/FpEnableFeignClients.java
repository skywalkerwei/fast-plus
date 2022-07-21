package com.imguo.common.feign.annotation;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * feign 注解
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface FpEnableFeignClients {
  String[] value() default {};

  String[] basePackages() default {"com.imguo.service"};

  Class<?>[] basePackageClasses() default {};

  Class<?>[] defaultConfiguration() default {};

  Class<?>[] clients() default {};
}
