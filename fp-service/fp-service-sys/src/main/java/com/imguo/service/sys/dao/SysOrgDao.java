package com.imguo.service.sys.dao;

import com.imguo.model.common.dao.BaseDao;
import com.imguo.model.sys.entity.SysOrgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机构管理
 *
 */
public interface SysOrgDao extends BaseDao<SysOrgEntity> {

    List<SysOrgEntity> getList(Map<String, Object> params);

    /**
     * 获取所有机构的id、pid列表
     */
    List<SysOrgEntity> getIdAndPidList();

}