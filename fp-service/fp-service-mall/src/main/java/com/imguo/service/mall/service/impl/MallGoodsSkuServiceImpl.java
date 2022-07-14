package com.imguo.service.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.model.mall.domain.MallGoodsSku;
import com.imguo.service.mall.service.MallGoodsSkuService;
import com.imguo.service.mall.mapper.MallGoodsSkuMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【mall_goods_sku(商品sku表)】的数据库操作Service实现
* @createDate 2022-07-06 14:16:47
*/
@Service
public class MallGoodsSkuServiceImpl extends ServiceImpl<MallGoodsSkuMapper, MallGoodsSku>
implements MallGoodsSkuService{

}
