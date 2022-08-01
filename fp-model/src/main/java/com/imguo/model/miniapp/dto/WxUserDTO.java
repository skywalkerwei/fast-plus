package com.imguo.miniapp.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信用户DTO
 *
 */
@Data
public class WxUserDTO implements Serializable {

  private String appId;

  private String wxCode;

  private String encryptedData;

  private String iv;

  private String sessionKey;

  private String mallUserId;

  private String rawData;

  private String signature;

  private String clientType;

  private String wxUserId;
}
