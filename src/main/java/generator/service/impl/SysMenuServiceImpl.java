package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysMenu;
import generator.service.SysMenuService;
import generator.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service实现
* @createDate 2022-07-20 09:58:48
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

}




