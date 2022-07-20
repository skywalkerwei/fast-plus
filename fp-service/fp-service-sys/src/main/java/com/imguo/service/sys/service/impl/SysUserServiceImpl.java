package com.imguo.service.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imguo.model.sys.domain.SysUser;
import com.imguo.service.sys.service.SysUserService;
import com.imguo.service.sys.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【sys_user(用户管理)】的数据库操作Service实现
* @createDate 2022-07-20 09:58:48
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}



