package com.imguo.service.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.model.mall.domain.MallGoods;
import com.imguo.service.mall.service.MallGoodsService;
import com.imguo.service.mall.mapper.MallGoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【mall_goods(商品表)】的数据库操作Service实现
* @createDate 2022-07-06 14:16:47
*/
@Service
public class MallGoodsServiceImpl extends ServiceImpl<MallGoodsMapper, MallGoods>
implements MallGoodsService{

}
