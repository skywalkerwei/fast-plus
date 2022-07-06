package com.imguo.service.goods.controller;

import com.imguo.common.core.entity.Result;
import com.imguo.service.goods.query.TestQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/test/")
public class TestController {

    @GetMapping("t1")
    public Result<String> t1() {

        return  Result.success("sb");
    }


    @GetMapping("t2/{id}")
    public Result<String> t2(@PathVariable String id){
        return  Result.success("sb");
    }

    @PostMapping("t3")
    public Result<TestQuery> t3(@RequestBody @Valid TestQuery tq){

        return  Result.success(tq);
    }

}
