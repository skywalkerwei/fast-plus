package com.imguo.service.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.query.Query;
import com.imguo.model.common.service.impl.BaseServiceImpl;
import com.imguo.model.sys.convert.SysOauthClientConvert;
import com.imguo.service.sys.dao.SysOauthClientDao;
import com.imguo.model.sys.entity.SysOauthClientEntity;
import com.imguo.service.sys.service.SysOauthClientService;
import com.imguo.model.sys.vo.SysOauthClientVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户端管理
 *
 */
@Service
public class SysOauthClientServiceImpl extends BaseServiceImpl<SysOauthClientDao, SysOauthClientEntity>
        implements SysOauthClientService {

    @Override
    public PageResult<SysOauthClientVO> page(Query query) {
        IPage<SysOauthClientEntity> page = baseMapper.selectPage(getPage(query), Wrappers.emptyWrapper());

        return new PageResult<>(SysOauthClientConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public void save(SysOauthClientVO vo) {
        SysOauthClientEntity entity = SysOauthClientConvert.INSTANCE.convert(vo);
        //entity.setAuthorizedGrantTypes(JsonUtils.toJsonString(vo.getAuthorizedGrantTypes()));

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysOauthClientVO vo) {
        SysOauthClientEntity entity = SysOauthClientConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }
}
