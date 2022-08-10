package com.imguo.service.test.controller;

import com.imguo.common.core.entity.Result;
import com.imguo.feign.mall.MallFeignService;
import com.imguo.feign.sys.SysUserFeignService;
import com.imguo.model.sys.query.SysLoginQuery;
import com.imguo.model.sys.vo.SysUserVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class TestController {

//    private MallFeignService mallFeignService;
//    private SysUserFeignService sysUserFeignService;
//
//    @GetMapping("t1")
//    public Result<String> t1() {
//
//        return Result.success(mallFeignService.t1());
//    }
//
//    @GetMapping("t2")
//    public Result<SysUserVO> t2() {
//        return sysUserFeignService.checkUserPwd(new SysLoginQuery("username", "password"));
//    }
}
