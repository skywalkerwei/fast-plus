package com.imguo.common.core.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imguo.common.core.config.AbstractDesensitization;
import com.imguo.common.core.config.DesensitizationJsonSerializer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 数据脱敏注解
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizationJsonSerializer.class)
public @interface Desensitization {

  Class<? extends AbstractDesensitization> value();
}
