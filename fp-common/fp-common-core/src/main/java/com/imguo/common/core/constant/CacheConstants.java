package com.imguo.common.core.constant;

/**
 * 缓存常量
 *
 */
public class CacheConstants {

  /** oauth 缓存前缀 */
  public static final String OAUTH_ACCESS = "oauth:access:";

  /** oauth 客户端信息 */
  public static final String CLIENT_DETAILS_KEY = "oauth:client:details";

  /** 验证码key */
  public static final String DEFAULT_CODE_KEY = "random_code_";

  /** 商城用户token */
  public static final String MALL_USER_TOKEN = "mall:user:token:";

  /** 商城用户token过期时间 */
  public static final long TOKEN_TIME = 24 * 5;

  /** 待支付订单 */
  public static final String MALL_ORDER_STATUS = "mall:order:status:";

  /** 用户信息缓存 */
  public static final String USER_CACHE = "user_cache";

  public static final String MENU_CACHE = "menu_cache";

  public static final String ROLE_CACHE = "role_cache";




}
