package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysOrg;
import generator.service.SysOrgService;
import generator.mapper.SysOrgMapper;
import org.springframework.stereotype.Service;

/**
* @author wei
* @description 针对表【sys_org(机构管理)】的数据库操作Service实现
* @createDate 2022-07-20 09:58:48
*/
@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg>
    implements SysOrgService{

}



