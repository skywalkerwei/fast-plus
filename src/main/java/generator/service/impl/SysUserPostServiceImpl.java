package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysUserPost;
import generator.service.SysUserPostService;
import generator.mapper.SysUserPostMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【sys_user_post(用户岗位关系)】的数据库操作Service实现
* @createDate 2022-07-20 09:58:48
*/
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost>
    implements SysUserPostService{

}




