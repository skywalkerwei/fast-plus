package com.imguo.common.core.config;
/**
 * 脱敏父类 子类通过继承AbstractDesensitization实现扩展
 *
 */
public abstract class AbstractDesensitization {

  /**
   * 脱敏
   *
   * @author lijx
   * @date 2022/5/31
   * @param value
   * @return: java.lang.String
   */
  public abstract String serialize(String value);
}
