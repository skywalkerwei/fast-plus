package com.imguo.service.sys.service;

import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.service.BaseService;
import com.imguo.model.sys.entity.SysUserEntity;
import com.imguo.model.sys.query.SysUserQuery;
import com.imguo.model.sys.vo.SysUserVO;

import java.util.List;

/**
 * 用户管理
 *
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    PageResult<SysUserVO> page(SysUserQuery query);

    void save(SysUserVO vo);

    void update(SysUserVO vo);

    void delete(List<Long> idList);

    /**
     * 修改密码
     * @param id           用户ID
     * @param newPassword  新密码
     */
    void updatePassword(Long id, String newPassword);

}
