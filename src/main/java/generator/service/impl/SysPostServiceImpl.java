package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysPost;
import generator.service.SysPostService;
import generator.mapper.SysPostMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【sys_post(岗位管理)】的数据库操作Service实现
* @createDate 2022-07-20 09:58:48
*/
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost>
    implements SysPostService{

}




