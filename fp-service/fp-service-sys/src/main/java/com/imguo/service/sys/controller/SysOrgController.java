package com.imguo.service.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.model.common.constant.Constant;
import com.imguo.model.sys.convert.SysOrgConvert;
import com.imguo.model.sys.entity.SysOrgEntity;
import com.imguo.model.sys.vo.SysOrgVO;
import com.imguo.service.sys.service.SysOrgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 机构管理
 *
 */
@RestController
@RequestMapping("org")
@Tag(name="机构管理")
@AllArgsConstructor
public class SysOrgController {
	private final SysOrgService sysOrgService;

	@GetMapping("list")
	@Operation(summary = "列表")
	@SaCheckPermission("sys:org:list")
	public Result<List<SysOrgVO>> list(){
		List<SysOrgVO> list = sysOrgService.getList();

		return Result.success(list);
	}

	@GetMapping("{id}")
	@Operation(summary = "信息")
	@SaCheckPermission("sys:org:info")
	public Result<SysOrgVO> get(@PathVariable("id") Long id){
		SysOrgEntity entity = sysOrgService.getById(id);
		SysOrgVO vo = SysOrgConvert.INSTANCE.convert(entity);

		// 获取上级机构名称
		if(!Constant.ROOT.equals(entity.getPid())){
			SysOrgEntity parentEntity = sysOrgService.getById(entity.getPid());
			vo.setParentName(parentEntity.getName());
		}

		return Result.success(vo);
	}

	@PostMapping
	@Operation(summary = "保存")
	@SaCheckPermission("sys:org:save")
	public Result<String> save(@RequestBody @Valid SysOrgVO vo){
		sysOrgService.save(vo);

		return Result.success();
	}

	@PutMapping
	@Operation(summary = "修改")
	@SaCheckPermission("sys:org:update")
	public Result<String> update(@RequestBody @Valid SysOrgVO vo){
		sysOrgService.update(vo);

		return Result.success();
	}

	@DeleteMapping("{id}")
	@Operation(summary = "删除")
	@SaCheckPermission("sys:org:delete")
	public Result<String> delete(@PathVariable("id") Long id){
		sysOrgService.delete(id);

		return Result.success();
	}
	
}