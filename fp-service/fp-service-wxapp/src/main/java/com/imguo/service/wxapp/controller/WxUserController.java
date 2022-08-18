package com.imguo.service.wxapp.controller;


import cn.binarywang.wx.miniapp.api.WxMaService;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.util.ObjectUtil;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.util.FpLoggers;
import com.imguo.common.security.annotation.FpInner;
import com.imguo.common.security.at.user.SaUserCheckLogin;
import com.imguo.common.security.util.SecurityUserUtils;
import com.imguo.common.security.util.UserDetail;
import com.imguo.model.miniapp.convert.WxUserConvert;
import com.imguo.model.miniapp.entity.WxUserEntity;
import com.imguo.model.miniapp.query.WxBindMobileQuery;
import com.imguo.model.miniapp.query.WxCodeQuery;
import com.imguo.model.miniapp.query.WxUserQuery;
import com.imguo.model.miniapp.vo.WxUserVO;
import com.imguo.service.wxapp.service.WxUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Tag(name="小程序登录")
@AllArgsConstructor
@FpInner
public class WxUserController {

    private final WxMaService wxService;
    WxUserService wxUserService;


    @PostMapping("code")
    @Operation(summary = "code")
    public Result<WxUserVO> wxCode(@RequestBody @Valid WxCodeQuery query)  {

        try {
            WxMaJscode2SessionResult sessionInfo = wxService.getUserService().getSessionInfo(query.getCode());
            FpLoggers.info("code2SessionInfo {}",sessionInfo);
            WxUserEntity userEntity =   wxUserService.checkOpenID(sessionInfo);
            FpLoggers.info("userEntity {}",userEntity);
            WxUserVO userVO = WxUserConvert.INSTANCE.convert(userEntity);
            FpLoggers.info("userVO {}",userVO);
            UserDetail tokenInfo = SecurityUserUtils.Login(userEntity.getId());
            userVO.setToken(tokenInfo.getToken());

            return Result.success(userVO);
        } catch (WxErrorException e) {
            return Result.fail(e.getMessage());
        }
    }


    @GetMapping("t")
    @Operation(summary = "t")
    public Result<UserDetail> t() {
        UserDetail tokenInfo = SecurityUserUtils.Login(999);
        return  Result.success(tokenInfo);
    }


    @PostMapping("updateUser")
    @Operation(summary = "updateUser")
    public Result<WxMaUserInfo> updateUser(@RequestBody @Valid WxUserQuery query)  {
        WxUserEntity userEntity =   wxUserService.queryByOpenId(query.getOpenId());
        WxMaUserInfo wxMaUserInfo =
                wxService
                        .getUserService()
                        .getUserInfo(
                                userEntity.getSessionKey(), query.getEncryptedData(), query.getIv());
        wxUserService.updateWxMaUserInfo(query.getOpenId(),wxMaUserInfo);
        return  Result.success(wxMaUserInfo);
    }

    @PostMapping("phone")
    @Operation(summary = "获取用户绑定手机号信息")
    public Result<WxMaPhoneNumberInfo> phone(@RequestBody @Valid WxBindMobileQuery query)  {
        WxUserEntity userEntity =   wxUserService.queryByOpenId(query.getOpenId());
        WxMaPhoneNumberInfo phoneNoInfo =
                wxService
                        .getUserService()
                        .getPhoneNoInfo(
                                userEntity.getSessionKey(), query.getEncryptedData(), query.getIv());
        wxUserService.updateWxMaPhoneNumberInfo(query.getOpenId(),phoneNoInfo);

        return  Result.success(phoneNoInfo);
    }

    @GetMapping("{id}")
    @SaUserCheckLogin
    public Result<WxUserEntity> getById(@PathVariable long id) {
        WxUserEntity userEntity = wxUserService.getById(id);
        if (ObjectUtil.isNull(userEntity)) {
            return Result.fail("用户不存在");
        }else{
            return Result.success(wxUserService.getById(id));
        }

    }

    @GetMapping("me")
    @SaUserCheckLogin
    public Result<UserDetail> me() {

        return  Result.success(SecurityUserUtils.getInfo());

    }



}
