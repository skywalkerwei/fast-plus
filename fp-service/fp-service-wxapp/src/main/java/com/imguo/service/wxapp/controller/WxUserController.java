package com.imguo.service.wxapp.controller;


import cn.binarywang.wx.miniapp.api.WxMaService;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.util.ObjectUtil;
import com.imguo.common.core.entity.Result;
import com.imguo.common.security.annotation.FpInner;
import com.imguo.model.miniapp.entity.WxUserEntity;
import com.imguo.model.miniapp.query.WxBindMobileQuery;
import com.imguo.model.miniapp.query.WxCodeQuery;
import com.imguo.model.miniapp.query.WxUserQuery;
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
@FpInner
public class WxUserController {

    private final WxMaService wxService;
    WxUserService wxUserService;


    @PostMapping("code")
    @Operation(summary = "code")
    public Result<WxUserEntity> wxCode(@RequestBody @Valid WxCodeQuery query)  {

        try {
            WxMaJscode2SessionResult sessionInfo = wxService.getUserService().getSessionInfo(query.getCode());
            log.info("code2SessionInfo {}",sessionInfo);
            WxUserEntity userEntity =   wxUserService.checkOpenID(sessionInfo);
            return Result.success(userEntity);
        } catch (WxErrorException e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("updateUser")
    @Operation(summary = "updateUser")
    public Result<WxMaUserInfo> updateUser(@RequestBody @Valid WxUserQuery query)  {
        WxMaUserInfo wxMaUserInfo =
                wxService
                        .getUserService()
                        .getUserInfo(
                                query.getSessionKey(), query.getEncryptedData(), query.getIv());
        return  Result.success(wxMaUserInfo);
    }

    @PostMapping("/phone")
    @Operation(summary = "获取用户绑定手机号信息")
    public Result<WxMaPhoneNumberInfo> phone(@RequestBody @Valid WxBindMobileQuery query)  {
        WxMaPhoneNumberInfo phoneNoInfo =
                wxService
                        .getUserService()
                        .getPhoneNoInfo(
                                query.getSessionKey(), query.getEncryptedData(), query.getIv());
        return  Result.success(phoneNoInfo);
    }

    @GetMapping("/{id}")
    public Result<WxUserEntity> getById(@PathVariable long id) {
        WxUserEntity userEntity = wxUserService.getById(id);
        if (ObjectUtil.isNull(userEntity)) {
            return Result.fail("用户不存在");
        }else{
            return Result.success(wxUserService.getById(id));
        }

    }



}
