package com.imguo.common.core.desensitization;

import com.imguo.common.core.config.AbstractDesensitization;
import org.springframework.stereotype.Service;

/**
 * 秘钥脱敏
 *
 */
public class KeyDesensitization extends AbstractDesensitization {
  @Override
  public String serialize(String value) {
    return value.replaceAll("(?<=\\w{1})\\w(?=\\w{3})", "*");
  }
}
