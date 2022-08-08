package com.imguo.model.pay.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.imguo.common.core.annotation.Desensitization;
import com.imguo.common.core.desensitization.KeyDesensitization;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 支付配置
 *
 */
@Data
@Schema(description = "支付配置")
@Accessors(chain = true)
@TableName(value = "pay_config")
public class PayConfigEntity  {

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
  private Date createTime;

  @Schema(description =  "更新时间")
  private Date updateTime;

  @Schema(description =  "微信移动应用的APPID")
  private String subAppId;

  @Version
  @TableField(fill = FieldFill.INSERT)
  private Integer version;


  @TableLogic
  @TableField(fill = FieldFill.INSERT)
  private Integer deleted;
}
