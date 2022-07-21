package com.imguo.service.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.page.PageResult;
import com.imguo.model.common.query.Query;
import com.imguo.model.sys.convert.SysOauthClientConvert;
import com.imguo.model.sys.entity.SysOauthClientEntity;
import com.imguo.model.sys.vo.SysOauthClientVO;
import com.imguo.service.sys.service.SysOauthClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户端管理
 *
 */
@RestController
@RequestMapping("client")
@Tag(name="客户端管理")
@AllArgsConstructor
public class SysOauthClientController {
    private final SysOauthClientService sysOauthClientService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @SaCheckPermission("sys:client:page")
    public Result<PageResult<SysOauthClientVO>> page(@Valid Query query){
        PageResult<SysOauthClientVO> page = sysOauthClientService.page(query);

        return Result.success(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @SaCheckPermission("sys:client:info")
    public Result<SysOauthClientVO> get(@PathVariable("id") Long id){
        SysOauthClientEntity entity = sysOauthClientService.getById(id);

        return Result.success(SysOauthClientConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @SaCheckPermission("sys:client:save")
    public Result<String> save(@RequestBody SysOauthClientVO vo){
        sysOauthClientService.save(vo);

        return Result.success();
    }

    @PutMapping
    @Operation(summary = "修改")
    @SaCheckPermission("sys:client:update")
    public Result<String> update(@RequestBody @Valid SysOauthClientVO vo){
        sysOauthClientService.update(vo);

        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @SaCheckPermission("sys:client:delete")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysOauthClientService.delete(idList);

        return Result.success();
    }
}
