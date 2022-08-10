package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysUserEntity;
import com.imguo.model.sys.vo.SysUserVO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    @BeanMapping(ignoreByDefault = true)
    SysUserVO convert(SysUserEntity entity);

    @BeanMapping(ignoreByDefault = true)
    SysUserEntity convert(SysUserVO vo);

    @BeanMapping(ignoreByDefault = true)
    List<SysUserVO> convertList(List<SysUserEntity> list);

}
