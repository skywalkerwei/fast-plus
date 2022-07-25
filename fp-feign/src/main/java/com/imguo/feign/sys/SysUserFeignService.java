package com.imguo.feign.sys;

import com.imguo.common.core.entity.Result;
import com.imguo.model.sys.query.SysLoginQuery;
import com.imguo.model.sys.vo.SysUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "fp-service-sys",path = "/user/")
public interface SysUserFeignService {
    @PostMapping("checkUserPwd")
    public Result<SysUserVO> checkUserPwd(@RequestBody  SysLoginQuery query);

}
