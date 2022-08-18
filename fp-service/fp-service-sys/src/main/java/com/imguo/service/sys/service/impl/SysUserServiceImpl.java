package com.imguo.service.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imguo.common.core.exception.FastException;
import com.imguo.common.core.util.FpLoggers;
import com.imguo.model.common.constant.Constant;
import com.imguo.model.common.service.impl.BaseServiceImpl;
import com.imguo.model.sys.query.SysLoginQuery;
import com.imguo.service.sys.enums.SuperAdminEnum;
import lombok.AllArgsConstructor;

import com.imguo.common.core.page.PageResult;

import com.imguo.model.sys.convert.SysUserConvert;
import com.imguo.service.sys.dao.SysUserDao;
import com.imguo.model.sys.entity.SysUserEntity;

import com.imguo.model.sys.query.SysUserQuery;
import com.imguo.service.sys.service.SysUserPostService;
import com.imguo.service.sys.service.SysUserRoleService;
import com.imguo.service.sys.service.SysUserService;
import com.imguo.model.sys.vo.SysUserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 *
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    private final SysUserRoleService sysUserRoleService;
    private final SysUserPostService sysUserPostService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);

        // 分页查询
        IPage<SysUserEntity> page = getPage(query);
        params.put(Constant.PAGE, page);

        // 数据列表
        List<SysUserEntity> list = baseMapper.getList(params);

        return new PageResult<>(SysUserConvert.INSTANCE.convertList(list), page.getTotal());
    }

    private Map<String, Object> getParams(SysUserQuery query){
        Map<String, Object> params = new HashMap<>();
        params.put("username", query.getUsername());
        params.put("mobile", query.getMobile());
        params.put("gender", query.getGender());

        // 数据权限
        params.put(Constant.DATA_SCOPE, getDataScope("t1", null));

        return params;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());

        // 判断用户名是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if(user != null) {
            throw new FastException("用户名已经存在");
        }

        // 判断手机号是否存在
        user = baseMapper.getByMobile(entity.getMobile());
        if(user != null) {
            throw new FastException("手机号已经存在");
        }

        // 保存用户
        baseMapper.insert(entity);

        // 保存用户角色关系
        sysUserRoleService.saveOrUpdate(entity.getId(), vo.getRoleIdList());

        // 更新用户岗位关系
        sysUserPostService.saveOrUpdate(entity.getId(), vo.getPostIdList());
    }

    @Override
    public void update(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);

        // 判断用户名是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if(user != null && !user.getId().equals(entity.getId())) {
            throw new FastException("用户名已经存在");
        }

        // 判断手机号是否存在
        user = baseMapper.getByMobile(entity.getMobile());
        if(user != null && !user.getId().equals(entity.getId())) {
            throw new FastException("手机号已经存在");
        }

        // 更新用户
        updateById(entity);

        // 更新用户角色关系
        sysUserRoleService.saveOrUpdate(entity.getId(), vo.getRoleIdList());

        // 更新用户岗位关系
        sysUserPostService.saveOrUpdate(entity.getId(), vo.getPostIdList());
    }

    @Override
    public void delete(List<Long> idList) {
        // 删除用户
        removeByIds(idList);

        // 删除用户角色关系
        sysUserRoleService.deleteByUserIdList(idList);

        // 删除用户岗位关系
        sysUserPostService.deleteByUserIdList(idList);
    }

    @Override
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);

        updateById(user);
    }

    @Override
    public  SysUserVO queryByName(String username) {
        SysUserEntity entity = baseMapper.getByUsername(username);
        if(entity == null){
            throw new FastException("用户不存在");
        }
        return  SysUserConvert.INSTANCE.convert(entity);
    }

    @Override
    public SysUserVO checkUserPwd(SysLoginQuery query) {
        SysUserEntity entity = baseMapper.getByUsername(query.getUsername());
        if(entity == null){
            throw new FastException("用户不存在");
        }
        FpLoggers.info("用户密码1：{}",entity.getPassword());
        FpLoggers.info("用户密码2：{}",query.getPassword());
        FpLoggers.info("用户密码3：{}",passwordEncoder.encode(query.getPassword()));
        if(!passwordEncoder.matches(query.getPassword(), entity.getPassword())){
            throw new FastException("密码不正确");
        }

        return SysUserConvert.INSTANCE.convert(entity);
    }

}
