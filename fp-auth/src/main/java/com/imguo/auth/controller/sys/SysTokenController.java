package com.imguo.auth.controller.sys;


import com.imguo.common.core.entity.Result;
import com.imguo.common.core.util.FpLoggers;
import com.imguo.common.security.util.SecuritySysUtils;
import com.imguo.common.security.util.UserDetail;
import com.imguo.feign.sys.SysUserFeignService;
import com.imguo.model.sys.query.SysLoginQuery;
import com.imguo.model.sys.vo.SysUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        FpLoggers.info("result SysUserVO ={}", result);

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
