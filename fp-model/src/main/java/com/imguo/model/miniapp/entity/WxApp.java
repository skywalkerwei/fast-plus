package com.imguo.model.miniapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
/**
 * 微信应用
 *
 */
@Data
@Schema(description = "微信应用")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "wx_app")
public class WxApp extends Model<WxApp> {

  @Schema(description = "appId")
  @TableId(type = IdType.ASSIGN_ID)
  private String appId;

  @Schema(description = "秘钥")
  private String appSecret;

  /** 设置微信小程序消息服务器配置的token */
  @Schema(description = "token")
  private String token;

  /** 设置微信小程序消息服务器配置的EncodingAESKey */
  @Schema(description = "aesKey")
  private String aesKey;

  @Schema(description = "应用名称")
  private String appName;

  @Schema(description = "应用图片")
  private String miniCodeUrl;

  @Schema(description = "创建时间")
  private LocalDateTime createTime;

  @Schema(description = "更新时间")
  private LocalDateTime updateTime;

  @Schema(description = "创建者ID")
  private String createId;

  @Schema(description = "修改者ID")
  private String updateId;

  @Schema(description = "逻辑删除：0、显示；1、隐藏")
  private String delFlag;
}
