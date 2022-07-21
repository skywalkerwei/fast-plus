package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysDictTypeEntity;
import com.imguo.model.sys.vo.SysDictTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysDictTypeConvert {
    SysDictTypeConvert INSTANCE = Mappers.getMapper(SysDictTypeConvert.class);

    SysDictTypeVO convert(SysDictTypeEntity entity);

    SysDictTypeEntity convert(SysDictTypeVO vo);
    
    List<SysDictTypeVO> convertList(List<SysDictTypeEntity> list);

}
