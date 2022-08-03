package com.imguo.model.miniapp.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 小程序用户DTO
 *
 */
@Data
public class MaUserDTO implements Serializable {

  private String appId;

  private String encryptedData;

  private String iv;
}
