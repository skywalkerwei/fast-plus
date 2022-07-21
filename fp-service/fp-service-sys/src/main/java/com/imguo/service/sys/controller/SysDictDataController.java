package com.imguo.service.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.page.PageResult;
import com.imguo.model.sys.convert.SysDictDataConvert;
import com.imguo.model.sys.entity.SysDictDataEntity;
import com.imguo.model.sys.query.SysDictDataQuery;
import com.imguo.model.sys.vo.SysDictDataVO;
import com.imguo.service.sys.service.SysDictDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典数据
 */
@RestController
@RequestMapping("dict/data")
@Tag(name="字典数据")
@AllArgsConstructor
public class SysDictDataController {
    private final SysDictDataService sysDictDataService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @SaCheckPermission("sys:dict:page")
    public Result<PageResult<SysDictDataVO>> page(@Valid SysDictDataQuery query){
        PageResult<SysDictDataVO> page = sysDictDataService.page(query);

        return Result.success(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @SaCheckPermission("sys:dict:info")
    public Result<SysDictDataVO> get(@PathVariable("id") Long id){
        SysDictDataEntity entity = sysDictDataService.getById(id);

        return Result.success(SysDictDataConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @SaCheckPermission("sys:dict:save")
    public Result<String> save(@RequestBody @Valid SysDictDataVO vo){
        sysDictDataService.save(vo);

        return Result.success();
    }

    @PutMapping
    @Operation(summary = "修改")
    @SaCheckPermission("sys:dict:update")
    public Result<String> update(@RequestBody @Valid SysDictDataVO vo){
        sysDictDataService.update(vo);

        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @SaCheckPermission("sys:dict:delete")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysDictDataService.delete(idList);

        return Result.success();
    }

}