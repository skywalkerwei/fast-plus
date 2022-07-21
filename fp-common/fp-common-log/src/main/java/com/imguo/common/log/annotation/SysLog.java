package com.imguo.common.log.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

  /** 标题 */
  String value() default "";
}
