package com.imguo.common.security.annotation;

import java.lang.annotation.*;
/**
 * 内部调用注解
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FpInner {
  boolean value() default true;
}
