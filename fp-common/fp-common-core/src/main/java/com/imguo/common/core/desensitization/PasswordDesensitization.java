package com.imguo.common.core.desensitization;

import com.imguo.common.core.config.AbstractDesensitization;
/**
 * 密码脱敏
 *
 */
public class PasswordDesensitization extends AbstractDesensitization {
  @Override
  public String serialize(String value) {
    return "******";
  }
}
