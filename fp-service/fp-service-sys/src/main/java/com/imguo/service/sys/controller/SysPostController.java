package com.imguo.service.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.page.PageResult;
import com.imguo.model.sys.convert.SysPostConvert;
import com.imguo.model.sys.entity.SysPostEntity;
import com.imguo.model.sys.query.SysPostQuery;
import com.imguo.model.sys.vo.SysPostVO;
import com.imguo.service.sys.service.SysPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
* 岗位管理
*
* @author 阿沐 babamu@126.com
*/
@RestController
@RequestMapping("post")
@Tag(name="岗位管理")
@AllArgsConstructor
public class SysPostController {
    private final SysPostService sysPostService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @SaCheckPermission("sys:post:page")
    public Result<PageResult<SysPostVO>> page(@Valid SysPostQuery query){
        PageResult<SysPostVO> page = sysPostService.page(query);

        return Result.success(page);
    }

    @GetMapping("list")
    @Operation(summary = "列表")
    public Result<List<SysPostVO>> list(){
        List<SysPostVO> list = sysPostService.getList();

        return Result.success(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @SaCheckPermission("sys:post:info")
    public Result<SysPostVO> get(@PathVariable("id") Long id){
        SysPostEntity entity = sysPostService.getById(id);

        return Result.success(SysPostConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @SaCheckPermission("sys:post:save")
    public Result<String> save(@RequestBody SysPostVO vo){
        sysPostService.save(vo);

        return Result.success();
    }

    @PutMapping
    @Operation(summary = "修改")
    @SaCheckPermission("sys:post:update")
    public Result<String> update(@RequestBody @Valid SysPostVO vo){
        sysPostService.update(vo);

        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @SaCheckPermission("sys:post:delete")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysPostService.delete(idList);

        return Result.success();
    }
}