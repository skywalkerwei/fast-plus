package com.imguo.model.miniapp.vo;

import lombok.Data;

import java.io.Serializable;
/**
 * 小程序用户VO
 */
@Data
public class MaUserVO implements Serializable {
  private String appId;

  private String encryptedData;

  private String iv;

  private String shareUserNumber;
}
