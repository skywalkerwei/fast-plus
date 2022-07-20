package com.imguo.service.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.common.core.exception.FastException;
import com.imguo.model.mall.domain.Mall;
import com.imguo.service.mall.service.MallService;
import com.imguo.service.mall.mapper.MallMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author wei
* @description 针对表【mall(店铺)】的数据库操作Service实现
* @createDate 2022-07-06 14:16:47
*/
@Service
public class MallServiceImpl extends ServiceImpl<MallMapper, Mall>
implements MallService{

    @Override
    public String test(int num) {
        if(num < 100){
            throw new FastException("num必须大于100");
        }
        return "sb = " + num;

    }
}
