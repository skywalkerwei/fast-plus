package com.imguo.auth.controller.sys;


import com.imguo.common.core.entity.Result;
import com.imguo.common.security.at.sys.SaSysCheckLogin;
import com.imguo.common.security.at.sys.SaSysCheckPermission;
import com.imguo.common.security.at.sys.SaSysCheckRole;
import com.imguo.common.security.util.SecuritySysUtils;
import com.imguo.common.security.util.SecurityUserUtils;
import com.imguo.common.security.util.UserDetail;
import com.imguo.feign.sys.SysUserFeignService;
import com.imguo.model.sys.query.SysLoginQuery;
import com.imguo.model.sys.vo.SysUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("sys")
@Tag(name="管理后台登录")
public class SysTokenController {
    private SysUserFeignService sysUserFeignService;

    @PostMapping("login")
    @Operation(summary = "登录")
//    @SecurityRequirement(name = "")
    public Result<UserDetail> doLogin(String username, String password) {

        Result<SysUserVO> result = sysUserFeignService.checkUserPwd(new SysLoginQuery(username, password));
        log.info("result SysUserVO ={}", result);
        if (result.isSuccess()){
            SysUserVO sysUserVO = result.getData();
            UserDetail userDetail = SecuritySysUtils.Login(sysUserVO.getId());
            //查询权限
            List<String> list = new ArrayList<String>();
            list.add("sys:role:page");
            list.add("sys:role:list");
            list.add("sys:menu:list");
            SecuritySysUtils.SetPermission(list);
            return Result.success(userDetail);
        }
        return  Result.fail("用户名或密码错误");
    }


}
