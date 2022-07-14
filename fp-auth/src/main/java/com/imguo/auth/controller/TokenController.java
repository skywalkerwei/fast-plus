package com.imguo.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;

import cn.hutool.json.JSONUtil;
import com.imguo.common.core.constant.CacheConstants;
import com.imguo.common.core.entity.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class TokenController {

    // 测试登录，浏览器访问： http://localhost:8081/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public Result<SaTokenInfo> doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            List<String> list = new ArrayList<String>();
            list.add("admin");
            list.add("super-admin");
            StpUtil.getSession().set(CacheConstants.ROLE_CACHE, JSONUtil.toJsonStr(list));
            return  Result.success(tokenInfo);
        }
        return  Result.fail("用户名或密码错误");

    }

    // 查询登录状态，浏览器访问： http://localhost:8081/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        log.info(StpUtil.getTokenInfo().toString());
        log.info(StpUtil.getRoleList().toString());
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/logout
    // 当前会话注销登录
    @RequestMapping("logout")
    public String logout() {
        StpUtil.logout();
        return "当前会话注销：成功！";
    }

    // 当前会话注销登录
    @RequestMapping("kickout")
    public String kickout() {
        StpUtil.kickout(10001);
        return "当前会话注销：成功！";
    }

    @RequestMapping("me")
    @SaCheckLogin
    public Result<SaTokenInfo> me() {
        return   Result.success(StpUtil.getTokenInfo());
    }

    @RequestMapping("me2")
    @SaCheckRole("admin")
    public Result<SaTokenInfo> me2() {
        return   Result.success(StpUtil.getTokenInfo());
    }



}
