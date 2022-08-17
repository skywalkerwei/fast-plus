package com.imguo.model.sys.convert;


import com.imguo.model.sys.entity.SysDictDataEntity;
import com.imguo.model.sys.vo.SysDictDataVO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysDictDataConvert {
    SysDictDataConvert INSTANCE = Mappers.getMapper(SysDictDataConvert.class);

    
    SysDictDataVO convert(SysDictDataEntity entity);

    
    SysDictDataEntity convert(SysDictDataVO vo);

    
    List<SysDictDataVO> convertList(List<SysDictDataEntity> list);

}
