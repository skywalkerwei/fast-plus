package com.imguo.service.pay.config;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.imguo.model.pay.constants.PayConstants;
import com.imguo.model.pay.entity.PayConfigEntity;
import com.imguo.service.pay.service.PayConfigService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnClass(WxPayService.class)
@AllArgsConstructor
@Data
@Slf4j
public class WxPayConfigurationOnline {
  private  PayConfigService payConfigService;

  public WxPayService wxService(WxPayConfig wxPayConfig) {

    PayConfigEntity payConfig =
            payConfigService.getOne(
                    Wrappers.<PayConfigEntity>lambdaQuery().eq(PayConfigEntity::getType, PayConstants.PAY_TYPE_1));
    log.info("payConfig = {}",payConfig);
    if (ObjectUtil.isNull(payConfig)) {
      throw new RuntimeException("未配置微信支付");
    }

    final WxPayServiceImpl wxPayService = new WxPayServiceImpl();
    wxPayConfig.setAppId(StringUtils.trimToNull(payConfig.getAppId()));
    wxPayConfig.setMchId(StringUtils.trimToNull(payConfig.getMchId()));
    wxPayConfig.setMchKey(StringUtils.trimToNull(payConfig.getMchKey()));
    wxPayConfig.setKeyPath(StringUtils.trimToNull(payConfig.getKeyPath()));
    // 以下是apiv3
    wxPayConfig.setPrivateKeyPath(StringUtils.trimToNull(payConfig.getPrivateKeyPath()));
    wxPayConfig.setPrivateCertPath(StringUtils.trimToNull(payConfig.getPrivateCertPath()));
    wxPayConfig.setCertSerialNo(StringUtils.trimToNull(payConfig.getCertSerialNo()));
    wxPayConfig.setApiV3Key(StringUtils.trimToNull(payConfig.getApiv3Key()));

    // 可以指定是否使用沙箱环境
    wxPayConfig.setUseSandboxEnv(false);
    wxPayService.setConfig(wxPayConfig);
    return wxPayService;
  }

}
