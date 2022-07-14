package com.imguo.service.test.controller;

import com.imguo.common.core.entity.Result;
import com.imguo.feign.mall.MallFeignService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/test/")
public class TestController {

    private MallFeignService mallFeignService;

    @GetMapping("t1")
    public Result<String> t1() {

        return Result.success(mallFeignService.t1());
    }
}
