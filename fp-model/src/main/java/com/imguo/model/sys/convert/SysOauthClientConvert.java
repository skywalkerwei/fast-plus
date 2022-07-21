package com.imguo.model.sys.convert;

import com.imguo.model.sys.entity.SysOauthClientEntity;
import com.imguo.model.sys.vo.SysOauthClientVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SysOauthClientConvert {
    SysOauthClientConvert INSTANCE = Mappers.getMapper(SysOauthClientConvert.class);

    SysOauthClientVO convert(SysOauthClientEntity entity);

    SysOauthClientEntity convert(SysOauthClientVO vo);

    List<SysOauthClientVO> convertList(List<SysOauthClientEntity> list);

}
