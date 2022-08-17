package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysPostEntity;
import com.imguo.model.sys.vo.SysPostVO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SysPostConvert {
    SysPostConvert INSTANCE = Mappers.getMapper(SysPostConvert.class);


    SysPostVO convert(SysPostEntity entity);

    
    SysPostEntity convert(SysPostVO vo);

    List<SysPostVO> convertList(List<SysPostEntity> list);

}
