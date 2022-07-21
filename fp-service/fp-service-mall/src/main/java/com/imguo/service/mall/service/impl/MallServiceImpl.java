package com.imguo.service.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.common.core.exception.FastException;
import com.imguo.model.mall.entity.Mall;
import com.imguo.service.mall.service.MallService;
import com.imguo.service.mall.mapper.MallMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
