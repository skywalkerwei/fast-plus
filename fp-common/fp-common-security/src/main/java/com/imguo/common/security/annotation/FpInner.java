package com.imguo.common.security.annotation;

import java.lang.annotation.*;
/**
 * 内部调用注解
 *
 * @author lijx
 * @date 2022/5/3 21:10
 * @version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FpInner {
  boolean value() default true;
}
