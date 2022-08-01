package com.imguo.model.miniapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 支付宝应用
 *
 */
@Data
@Schema(description = "支付宝应用")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "ali_app")
public class AliAppEntity  {

  @Schema(description = "appId")
  @TableId(type = IdType.ASSIGN_ID)
  private String appId;

  @Schema(description = "应用私钥")
  private String privateKey;

  @Schema(description = "应用公钥证书路径")
  private String certPath;

  @Schema(description = "支付宝公钥证书路径")
  private String alipayPublicCertPath;

  @Schema(description = "支付宝根证书路径")
  private String rootCertPath;

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
