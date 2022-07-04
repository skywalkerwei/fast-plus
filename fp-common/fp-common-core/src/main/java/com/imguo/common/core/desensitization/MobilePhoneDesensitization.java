package com.imguo.common.core.desensitization;

import com.imguo.common.core.config.AbstractDesensitization;

/**
 * 手机号脱敏
 *
 */
public class MobilePhoneDesensitization extends AbstractDesensitization {

  @Override
  public String serialize(String value) {
    return value.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
  }
}
