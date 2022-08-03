package com.imguo.service.wxapp.controller;


import cn.binarywang.wx.miniapp.api.WxMaService;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.imguo.common.core.entity.Result;
import com.imguo.model.miniapp.query.WxCodeQuery;
import com.imguo.service.wxapp.service.WxUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("wx")
@Tag(name="wx user")
@AllArgsConstructor
@Slf4j
public class WxUserController {

    private final WxMaService wxService;
    WxUserService wxUserService;

    @PostMapping("code")
    @Operation(summary = "检查用户名")
    public Result<String> wxCode(@RequestBody @Valid WxCodeQuery query)  {
        log.info("code {}",query);
        try {
            WxMaJscode2SessionResult sessionInfo = wxService.getUserService().getSessionInfo(query.getCode());
            log.info("code2SessionInfo {}",sessionInfo);
            wxUserService.checkOpenID(sessionInfo);


            return Result.success(sessionInfo.getOpenid());
        } catch (WxErrorException e) {
            return Result.fail(e.getMessage());
        }
    }
}
