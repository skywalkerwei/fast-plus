package com.imguo.service.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.model.mall.domain.MallGoodsSpecification;
import com.imguo.service.mall.service.MallGoodsSpecificationService;
import com.imguo.service.mall.mapper.MallGoodsSpecificationMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【mall_goods_specification(商品规格表)】的数据库操作Service实现
* @createDate 2022-07-06 14:16:47
*/
@Service
public class MallGoodsSpecificationServiceImpl extends ServiceImpl<MallGoodsSpecificationMapper, MallGoodsSpecification>
implements MallGoodsSpecificationService{

}
