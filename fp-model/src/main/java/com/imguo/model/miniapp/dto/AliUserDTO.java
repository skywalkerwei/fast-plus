package com.imguo.miniapp.common.vo;

import lombok.Data;

import java.io.Serializable;
/**
 * 支付宝用户DTO
 */
@Data
public class AliUserDTO implements Serializable {

  private String appId;

  private String aliCode;

  private String clientType;

  /** 刷新令牌。通过该令牌可以刷新access_token */
  private String refreshToken;

  private String encryptedData;
}
