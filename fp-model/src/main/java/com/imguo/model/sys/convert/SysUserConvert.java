package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysUserEntity;
import com.imguo.model.sys.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(SysUserEntity entity);

    SysUserEntity convert(SysUserVO vo);

    List<SysUserVO> convertList(List<SysUserEntity> list);

}
