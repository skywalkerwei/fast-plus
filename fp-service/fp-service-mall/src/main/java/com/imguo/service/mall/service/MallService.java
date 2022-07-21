package com.imguo.service.mall.service;

import  com.imguo.model.mall.entity.Mall;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;


public interface MallService extends IService<Mall> {

//    UserInfo logout(HttpServletRequest request);
    String test(int num);

}
