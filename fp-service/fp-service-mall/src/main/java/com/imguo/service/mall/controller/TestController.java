package com.imguo.service.mall.controller;

import com.imguo.model.mall.entity.Mall;
import com.imguo.model.mall.query.TestQuery;
import com.imguo.service.mall.service.MallService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/test/")
public class TestController {

    private final MallService mallService;

    @GetMapping("t1")
    public String  t1() {

        return mallService.test(1);
    }


    @GetMapping("t2/{id}")
    public String t2(@PathVariable String id){

        return "t2:" + id;
    }

    @PostMapping("t3")
    public  TestQuery t3(@RequestBody @Valid TestQuery tq){

        return  tq;
    }

    @GetMapping("t4")
    public List<Mall> t4(){
        return mallService.list();
    }

    @GetMapping("t5")
    public Integer t5(){
        Mall mall = new Mall();
        mall.setUniversityId(1);
        mall.setName("123123");
        mall.setTel("123");
        mall.setNotice("test");
        mall.setDistributionFee(new BigDecimal(1));
        mallService.save(mall);
        return  mall.getId();
    }

    @GetMapping("t6")
    public Integer t6() {
        Mall mall = new Mall();
        mall.setId(3);
        mall.setName("sb");
        mallService.getBaseMapper().updateById(mall);
        return  mall.getId();
    }
}
