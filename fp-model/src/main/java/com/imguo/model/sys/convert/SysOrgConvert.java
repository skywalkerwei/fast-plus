package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysOrgEntity;
import com.imguo.model.sys.vo.SysOrgVO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SysOrgConvert {
    SysOrgConvert INSTANCE = Mappers.getMapper(SysOrgConvert.class);

    
    SysOrgEntity convert(SysOrgVO vo);

    
    SysOrgVO convert(SysOrgEntity entity);

    
    List<SysOrgVO> convertList(List<SysOrgEntity> list);

}
