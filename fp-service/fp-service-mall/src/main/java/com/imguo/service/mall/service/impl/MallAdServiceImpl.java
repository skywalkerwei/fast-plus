package com.imguo.service.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.model.mall.domain.MallAd;
import com.imguo.service.mall.service.MallAdService;
import com.imguo.service.mall.mapper.MallAdMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【mall_ad(学校广告位)】的数据库操作Service实现
* @createDate 2022-07-06 14:16:47
*/
@Service
public class MallAdServiceImpl extends ServiceImpl<MallAdMapper, MallAd>
implements MallAdService{

}
