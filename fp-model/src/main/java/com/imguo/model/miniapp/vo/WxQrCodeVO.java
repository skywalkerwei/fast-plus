package com.imguo.model.miniapp.vo;

import lombok.Data;

/**
 * 微信小程序码
 */
@Data
public class WxQrCodeVO {
  private String appId;

  private String scene;

  private String page;

  private String envVersion;
}
