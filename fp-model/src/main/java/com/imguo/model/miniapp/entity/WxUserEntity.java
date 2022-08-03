package com.imguo.model.miniapp.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.imguo.model.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
/**
 * 微信用户
 *
 */
@Data
@Schema(description = "微信用户")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "wx_user")
public class WxUserEntity extends BaseEntity {

  @Schema(description = "openid")
  private String openid;

  @Schema(description = "会话密钥")
  private String sessionKey;

  @Schema(description = "用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回")
  private String unionid;

  @Schema(description = "昵称")
  private String nickName;

  @Schema(description = "头像")
  private String avatarUrl;

  @Schema(description = "手机号码")
  private String phone;

  @Schema(description = "商城用户")
  private Long uid;

}
