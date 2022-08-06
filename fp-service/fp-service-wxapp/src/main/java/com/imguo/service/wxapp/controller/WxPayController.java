package com.imguo.service.wxapp.controller;

import cn.hutool.core.util.RandomUtil;
import com.github.binarywang.wxpay.bean.result.enums.TradeTypeEnum;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderV3Request;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.imguo.common.core.entity.Result;


import com.imguo.service.wxapp.config.WxPayConfiguration;
import com.imguo.service.wxapp.config.WxPayProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Tag(name="微信支付")
@RestController
@RequestMapping("/pay")
@AllArgsConstructor
public class WxPayController {
    private WxPayProperties payProperties;
    private WxPayConfiguration payconfig;

    @Operation(summary = "统一下单，并组装所需支付参数")
    @PostMapping("/createOrder")
    public Result<String> createOrder() throws WxPayException {

        WxPayService  wxPayService = payconfig.wxService();

        WxPayUnifiedOrderV3Request v3Request = new WxPayUnifiedOrderV3Request();
        ArrayList<WxPayUnifiedOrderV3Request.GoodsDetail> goodsDetails = new ArrayList<>();
        goodsDetails.add(new WxPayUnifiedOrderV3Request.GoodsDetail() {
        }
                .setMerchantGoodsId("")
                .setUnitPrice(0).setQuantity(0));

//        v3Request.setAppid(payProperties.getAppId())
//                .setMchid(payProperties.getMchId())
//                .setNotifyUrl(payProperties.getNotifyUrl())
//                .setDescription("test")
//                .setOutTradeNo(RandomUtil.randomNumbers(11))
//                .setAmount(new WxPayUnifiedOrderV3Request.Amount() {
//                }.setTotal(1))
//                .setPayer(new WxPayUnifiedOrderV3Request.Payer() {
//                }.setOpenid("odbtT5eCbsuLGOdUDW7EcY5ZT-Bg"))
//                .setDetail(new WxPayUnifiedOrderV3Request.Discount() {
//                }.setInvoiceId("").setGoodsDetails(goodsDetails))
//                .setSceneInfo(new WxPayUnifiedOrderV3Request.SceneInfo() {
//                }.setStoreInfo(new WxPayUnifiedOrderV3Request.StoreInfo() {
//                        }.setId("")).setPayerClientIp(""));

        v3Request.setDescription("test")
                .setOutTradeNo(RandomUtil.randomNumbers(10))
                .setAmount(new WxPayUnifiedOrderV3Request.Amount().setTotal(10))
                .setAttach("附加信息")
                .setGoodsTag("ABCD")
                .setPayer(new WxPayUnifiedOrderV3Request.Payer().setOpenid("odbtT5eCbsuLGOdUDW7EcY5ZT-Bg"));

        return Result.success(wxPayService.createOrderV3(TradeTypeEnum.JSAPI, v3Request));
    }

    @Operation(summary = "解密支付回调数据")
    @PostMapping("/notify/order")
    public Result<String>  notifyOrderData(@RequestBody String notifyData) {
//        WxPayConfig wxPayConfig = new WxPayConfig();
//        try {
////            return Result.success(
////                    WxPayAutoConfiguration.wxPayService(wxPayConfig)
////                            .parseOrderNotifyV3Result(notifyData, null));
//            return  null;
//        } catch (WxPayException e) {
//            e.printStackTrace();
//            return Result.fail(e.getReturnMsg());
//        }

        return  null;
    }


}
