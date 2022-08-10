package com.imguo.model.miniapp.convert;

import com.imguo.model.miniapp.entity.WxUserEntity;
import com.imguo.model.miniapp.vo.WxUserVO;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WxUserConvert {

    WxUserConvert INSTANCE = Mappers.getMapper(WxUserConvert.class);

    @BeanMapping(ignoreByDefault = true)
    WxUserVO convert(WxUserEntity entity);


}
