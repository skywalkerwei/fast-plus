package com.imguo.common.core.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

import java.time.LocalDate;

/**
 * 全局唯一ID工具类
 *
 */
public class SnowflakeIdUtils {
  /**
   * @name: orderNo
   * @description 订单编号
   * 
   * @date 2022/3/14 16:24
   * @return: java.lang.String
   */
  public static String orderNo() {
    return IdUtil.getSnowflake(1, 1).nextIdStr();
  }
  /**
   * @description: 活动期号
   * @param: str filledChar len
   * @return: java.lang.String
   * 
   * @date: 2022/6/1 20:53
   */
  public static String periodNo(String str, char filledChar, int len) {
    LocalDate now = LocalDate.now();
    String code = StrUtil.fillBefore(str, filledChar, len);
    StringBuilder sb = new StringBuilder();
    return sb.append(now.getYear()).append(code).toString();
  }
}
