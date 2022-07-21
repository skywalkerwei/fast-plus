package com.imguo.service.sys.dao;

import com.imguo.model.common.dao.BaseDao;
import com.imguo.model.sys.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 岗位管理
*
*/
@Mapper
public interface SysPostDao extends BaseDao<SysPostEntity> {
	
}