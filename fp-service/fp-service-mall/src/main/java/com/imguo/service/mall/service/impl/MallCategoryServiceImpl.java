package com.imguo.service.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.model.mall.domain.MallCategory;
import com.imguo.service.mall.service.MallCategoryService;
import com.imguo.service.mall.mapper.MallCategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【mall_category(商城-分类)】的数据库操作Service实现
* @createDate 2022-07-06 14:16:47
*/
@Service
public class MallCategoryServiceImpl extends ServiceImpl<MallCategoryMapper, MallCategory>
implements MallCategoryService{

}
