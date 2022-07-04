package com.imguo.common.core.desensitization;

import com.imguo.common.core.config.AbstractDesensitization;

/**
 * 身份证脱敏
 *
 */
public class IdCardDesensitization extends AbstractDesensitization {

  @Override
  public String serialize(String value) {
    return value.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
  }
}
