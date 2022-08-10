package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysMenuEntity;
import com.imguo.model.sys.vo.SysMenuVO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    @BeanMapping(ignoreByDefault = true)
    SysMenuEntity convert(SysMenuVO vo);

    @BeanMapping(ignoreByDefault = true)
    SysMenuVO convert(SysMenuEntity entity);

    @BeanMapping(ignoreByDefault = true)
    List<SysMenuVO> convertList(List<SysMenuEntity> list);

}
