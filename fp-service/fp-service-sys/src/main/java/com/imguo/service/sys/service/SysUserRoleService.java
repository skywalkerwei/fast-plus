package com.imguo.service.sys.service;

import com.imguo.model.common.service.BaseService;
import com.imguo.model.sys.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 用户角色关系
 *
 */
public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {

    /**
     * 保存或修改
     * @param userId      用户ID
     * @param roleIdList  角色ID列表
     */
    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 根据角色id列表，删除用户角色关系
     * @param roleIdList 角色id
     */
    void deleteByRoleIdList(List<Long> roleIdList);

    /**
     * 根据用户id列表，删除用户角色关系
     * @param userIdList 用户id列表
     */
    void deleteByUserIdList(List<Long> userIdList);

    /**
     * 角色ID列表
     * @param userId  用户ID
     */
    List<Long> getRoleIdList(Long userId);
}