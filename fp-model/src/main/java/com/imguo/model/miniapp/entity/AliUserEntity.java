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
import java.util.Date;

/**
 * 支付宝用户
 *
 * @author lijx
 * @date 2022/6/21
 */
@Data
@Schema(description = "支付宝用户")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "ali_user")
public class AliUserEntity {

  @Schema(description = "PK")
  @TableId(type = IdType.ASSIGN_ID)
  private String id;

  @Schema(description = "商城用户")
  private String mallUserId;

  @Schema(description = "昵称")
  private String nickName;

  @Schema(description = "头像")
  private String avatarUrl;

  @Schema(description = "手机号码")
  private String phone;

  /** 支付宝用户的唯一标识。以2088开头的16位数字 */
  @Schema(description = "支付宝用户的唯一标识。以2088开头的16位数字")
  private String userId;
  /** appId */
  @Schema(description = "appId")
  private String appId;

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

  @Schema(description = "支付宝静默登录授权token")
  private String accessToken;

  @Schema(description = "访问令牌的有效时间，单位是秒。")
  private String expiresIn;

  @Schema(description = "刷新令牌。通过该令牌可以刷新access_token")
  private String refreshToken;

  @Schema(description = "刷新令牌的有效时间，单位是秒。")
  private String reExpiresIn;

  @Schema(description = "授权token开始时间，作为有效期计算的起点")
  private Date authStart;
}
