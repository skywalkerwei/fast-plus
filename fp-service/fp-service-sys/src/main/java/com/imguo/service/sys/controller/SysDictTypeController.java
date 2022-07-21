package com.imguo.service.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.page.PageResult;
import com.imguo.model.sys.convert.SysDictTypeConvert;
import com.imguo.model.sys.entity.SysDictTypeEntity;
import com.imguo.model.sys.query.SysDictTypeQuery;
import com.imguo.model.sys.vo.SysDictTypeVO;
import com.imguo.model.sys.vo.SysDictVO;
import com.imguo.service.sys.service.SysDictTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典类型
 */
@RestController
@RequestMapping("dict/type")
@Tag(name="字典类型")
@AllArgsConstructor
public class SysDictTypeController {
    private final SysDictTypeService sysDictTypeService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @SaCheckPermission("sys:dict:page")
    public Result<PageResult<SysDictTypeVO>> page(@Valid SysDictTypeQuery query){
        PageResult<SysDictTypeVO> page = sysDictTypeService.page(query);

        return Result.success(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @SaCheckPermission("sys:dict:info")
    public Result<SysDictTypeVO> get(@PathVariable("id") Long id){
        SysDictTypeEntity entity = sysDictTypeService.getById(id);

        return Result.success(SysDictTypeConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @SaCheckPermission("sys:dict:save")
    public Result<String> save(@RequestBody @Valid SysDictTypeVO vo){
        sysDictTypeService.save(vo);

        return Result.success();
    }

    @PutMapping
    @Operation(summary = "修改")
    @SaCheckPermission("sys:dict:update")
    public Result<String> update(@RequestBody @Valid SysDictTypeVO vo){
        sysDictTypeService.update(vo);

        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @SaCheckPermission("sys:dict:delete")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysDictTypeService.delete(idList);

        return Result.success();
    }

    @GetMapping("all")
    @Operation(summary = "全部字典数据")
    public Result<List<SysDictVO>> all(){
        List<SysDictVO> dictList = sysDictTypeService.getDictList();

        return Result.success(dictList);
    }

}