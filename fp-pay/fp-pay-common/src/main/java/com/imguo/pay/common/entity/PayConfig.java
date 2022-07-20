package com.imguo.pay.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.imguo.common.core.annotation.Desensitization;
import com.imguo.common.core.desensitization.KeyDesensitization;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 支付配置
 *
 * @author lijx
 * @since 2022/3/18 10:07
 */
@Data
@Schema(description = "支付配置")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "pay_config")
public class PayConfig extends Model<PayConfig> {

  @Schema(description = "PK")
  @TableId(type = IdType.ASSIGN_ID)
  private String id;

  @Schema(description = "支付类型：1.微信；2.支付宝；")
  private String type;

  @Schema(description =  "应用ID")
  private String appId;

  @Schema(description =  "商户号")
  private String mchId;

  @Schema(description =  "微信支付商户密钥")
  @Desensitization(KeyDesensitization.class)
  private String mchKey;

  @Schema(description =  "apiclient_cert.p12文件的绝对路径，或者如果放在项目中，请以classpath:开头指定.")
  private String keyPath;

  @Schema(description =  "证书序列号")
  @Desensitization(KeyDesensitization.class)
  private String certSerialNo;

  @Schema(description =  "apiV3秘钥")
  @Desensitization(KeyDesensitization.class)
  private String apiv3Key;

  @Schema(description =  "apiv3 商户apiclient_key.pem")
  private String privateKeyPath;

  @Schema(description =  "apiv3 商户apiclient_cert.pem")
  private String privateCertPath;

  @Schema(description =  "创建时间")
  private LocalDateTime createTime;

  @Schema(description =  "更新时间")
  private LocalDateTime updateTime;

  @Schema(description =  "创建者ID")
  private String createId;

  @Schema(description =  "修改者ID")
  private String updateId;

  @Schema(description =  "微信移动应用的APPID")
  private String subAppId;

  @Schema(description =  "逻辑删除：0、显示；1、隐藏")
  private String delFlag;
}
