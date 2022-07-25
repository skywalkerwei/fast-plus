package com.imguo.auth.controller.wxapp;


import com.imguo.common.core.entity.Result;
import com.imguo.common.security.util.SecuritySysUtils;
import com.imguo.common.security.util.UserDetail;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("wxapp")
@Tag(name="微信小程序登录")
public class WxappTokenController {


    // 测试登录，浏览器访问： http://localhost:8081/doLogin?username=zhang&password=123456
    @GetMapping("doLogin")
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

    @GetMapping("logout")
    public String logout() {
        SecuritySysUtils.Logout();
        return "当前会话注销：成功！";
    }

}
