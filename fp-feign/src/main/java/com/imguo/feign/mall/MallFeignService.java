package com.imguo.feign.mall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fp-service-mall",path = "/test/")
public interface MallFeignService {

    @GetMapping("t1")
    public String t1();

    @GetMapping("t2/{id}")
    public String t2(@PathVariable(value = "id") String id);

    @GetMapping("t5")
    public Integer t5();

    @GetMapping("t6")
    public Integer t6();

}
