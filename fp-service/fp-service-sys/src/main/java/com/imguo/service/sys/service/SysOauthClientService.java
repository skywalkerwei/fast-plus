package com.imguo.service.sys.service;

import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.query.Query;
import com.imguo.model.common.service.BaseService;
import com.imguo.model.sys.entity.SysOauthClientEntity;
import com.imguo.model.sys.vo.SysOauthClientVO;

import java.util.List;

/**
 * 客户端管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysOauthClientService extends BaseService<SysOauthClientEntity> {

    PageResult<SysOauthClientVO> page(Query query);

    void save(SysOauthClientVO vo);

    void update(SysOauthClientVO vo);

    void delete(List<Long> idList);
}
