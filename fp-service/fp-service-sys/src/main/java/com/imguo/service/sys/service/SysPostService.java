package com.imguo.service.sys.service;

import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.service.BaseService;
import com.imguo.model.sys.entity.SysPostEntity;
import com.imguo.model.sys.query.SysPostQuery;
import com.imguo.model.sys.vo.SysPostVO;

import java.util.List;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysPostService extends BaseService<SysPostEntity> {

    PageResult<SysPostVO> page(SysPostQuery query);

    List<SysPostVO> getList();

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);
}