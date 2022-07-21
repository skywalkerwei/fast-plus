package com.imguo.service.sys.service;

import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.service.BaseService;
import com.imguo.model.sys.entity.SysRoleEntity;
import com.imguo.model.sys.query.SysRoleQuery;
import com.imguo.model.sys.vo.SysRoleVO;

import java.util.List;

/**
 * 角色
 *
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	PageResult<SysRoleVO> page(SysRoleQuery query);

	List<SysRoleVO> getList(SysRoleQuery query);

	void save(SysRoleVO vo);

	void update(SysRoleVO vo);

	void delete(List<Long> idList);
}
