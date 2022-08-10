package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysRoleEntity;
import com.imguo.model.sys.vo.SysRoleVO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    @BeanMapping(ignoreByDefault = true)
    SysRoleVO convert(SysRoleEntity entity);

    @BeanMapping(ignoreByDefault = true)
    SysRoleEntity convert(SysRoleVO vo);

    @BeanMapping(ignoreByDefault = true)
    List<SysRoleVO> convertList(List<SysRoleEntity> list);

}
