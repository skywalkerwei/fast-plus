package com.imguo.service.sys.service;

import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.service.BaseService;
import com.imguo.model.sys.entity.SysDictDataEntity;
import com.imguo.model.sys.query.SysDictDataQuery;
import com.imguo.model.sys.vo.SysDictDataVO;


import java.util.List;

/**
 * 数据字典
 *
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageResult<SysDictDataVO> page(SysDictDataQuery query);

    void save(SysDictDataVO vo);

    void update(SysDictDataVO vo);

    void delete(List<Long> idList);

}