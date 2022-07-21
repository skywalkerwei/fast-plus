package com.imguo.service.mall.service;

import  com.imguo.model.mall.entity.Mall;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author wei
* @description 针对表【mall(店铺)】的数据库操作Service
* @createDate 2022-07-06 14:16:47
*/

public interface MallService extends IService<Mall> {

//    UserInfo logout(HttpServletRequest request);
    String test(int num);

}
