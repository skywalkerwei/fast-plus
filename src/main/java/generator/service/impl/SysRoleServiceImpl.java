package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysRole;
import generator.service.SysRoleService;
import generator.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【sys_role(角色管理)】的数据库操作Service实现
* @createDate 2022-07-20 09:58:48
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService{

}




