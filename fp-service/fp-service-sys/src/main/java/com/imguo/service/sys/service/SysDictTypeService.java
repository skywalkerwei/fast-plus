package com.imguo.service.sys.service;

import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.service.BaseService;

import com.imguo.model.sys.entity.SysDictTypeEntity;
import com.imguo.model.sys.vo.SysDictVO;
import com.imguo.model.sys.query.SysDictTypeQuery;
import com.imguo.model.sys.vo.SysDictTypeVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysDictTypeService extends BaseService<SysDictTypeEntity> {

    PageResult<SysDictTypeVO> page(SysDictTypeQuery query);

    void save(SysDictTypeVO vo);

    void update(SysDictTypeVO vo);

    void delete(List<Long> idList);

    /**
     * 获取全部字典列表
     */
    List<SysDictVO> getDictList();

}