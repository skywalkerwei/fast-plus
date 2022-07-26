package com.imguo.auth.controller;


import com.imguo.common.core.entity.Result;
import com.imguo.common.security.at.sys.SaSysCheckLogin;
import com.imguo.common.security.at.sys.SaSysCheckPermission;
import com.imguo.common.security.at.sys.SaSysCheckRole;
import com.imguo.common.security.util.SecuritySysUtils;
import com.imguo.common.security.util.UserDetail;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@Tag(name="测试")
public class TokenController {


    // 测试登录，浏览器访问： http://localhost:8081/doLogin?username=zhang&password=123456
    @PostMapping("doLogin")
    public Result<UserDetail> doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {

            UserDetail detail =  SecuritySysUtils.Login(10001);
            List<String> list = new ArrayList<String>();
            list.add("admin");
            SecuritySysUtils.SetRole(list);
            return  Result.success(detail);
        }

        return  Result.fail("用户名或密码错误");

    }

    // 查询登录状态，浏览器访问： http://localhost:8081/isLogin
    @GetMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + SecuritySysUtils.isLogin();
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/logout
    // 当前会话注销登录
    @GetMapping("logout")
    public String logout() {
        SecuritySysUtils.Logout();
        return "当前会话注销：成功！";
    }

    // 当前会话注销登录
    @GetMapping("kickout")
    public String kickout() {
        SecuritySysUtils.kickout();
        return "当前会话注销：成功！";
    }

    @GetMapping("me")
    @SaSysCheckLogin
    public Result<UserDetail> me() {
        return   Result.success(SecuritySysUtils.getInfo());
    }

    @GetMapping("me2")
    @SaSysCheckRole("admin")
    public Result<UserDetail> me2() {
        return   Result.success(SecuritySysUtils.getInfo());
    }

    @GetMapping("me3")
    @SaSysCheckPermission("super-admin")
    public Result<UserDetail> m3() {
        return   Result.success(SecuritySysUtils.getInfo());
    }



}
