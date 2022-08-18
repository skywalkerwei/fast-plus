package com.imguo.service.test.controller;

import cn.hutool.json.JSONUtil;
import com.imguo.common.core.entity.Result;
import com.imguo.common.sms.util.AliSmsUtils;
import com.imguo.common.storage.utils.LocalStorageUtils;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@AllArgsConstructor
public class TestController {

    private final AliSmsUtils aliSmsUtils;
    private final  LocalStorageUtils localStorageUtils;
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam MultipartFile file) throws IOException {

        return Result.success(localStorageUtils.uploadFile(file));

    }

    @GetMapping("t1")
    public Result<String> t1() throws Exception {
        Map<String, String> maps = new HashMap<>();
        maps.put("code", "123123");
        aliSmsUtils.sendSms("18086635700", JSONUtil.toJsonStr(maps));
        return Result.success();
    }



//    private MallFeignService mallFeignService;
//    private SysUserFeignService sysUserFeignService;
//

//
//    @GetMapping("t2")
//    public Result<SysUserVO> t2() {
//        return sysUserFeignService.checkUserPwd(new SysLoginQuery("username", "password"));
//    }
}
