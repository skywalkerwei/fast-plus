package com.imguo.service.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.page.PageResult;
import com.imguo.model.sys.convert.SysRoleConvert;
import com.imguo.model.sys.entity.SysRoleEntity;
import com.imguo.model.sys.query.SysRoleQuery;
import com.imguo.model.sys.vo.SysRoleVO;
import com.imguo.service.sys.service.SysMenuService;
import com.imguo.service.sys.service.SysRoleDataScopeService;
import com.imguo.service.sys.service.SysRoleMenuService;
import com.imguo.service.sys.service.SysRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 角色管理
 *
 */
@RestController
@RequestMapping("role")
@Tag(name="角色管理")
@AllArgsConstructor
public class SysRoleController {
	private final SysRoleService sysRoleService;
	private final SysRoleMenuService sysRoleMenuService;
	private final SysRoleDataScopeService sysRoleDataScopeService;
	private final SysMenuService sysMenuService;

	@GetMapping("page")
	@Operation(summary = "分页")
	@SaCheckPermission("sys:role:page")
	public Result<PageResult<SysRoleVO>> page(@Valid SysRoleQuery query){
		PageResult<SysRoleVO> page = sysRoleService.page(query);

		return Result.success(page);
	}

	@GetMapping("list")
	@Operation(summary = "列表")
	@SaCheckPermission("sys:role:list")
	public Result<List<SysRoleVO>> list(){
		List<SysRoleVO> list = sysRoleService.getList(new SysRoleQuery());

		return Result.success(list);
	}

	@GetMapping("{id}")
	@Operation(summary = "信息")
	@SaCheckPermission("sys:role:info")
	public Result<SysRoleVO> get(@PathVariable("id") Long id){
		SysRoleEntity entity = sysRoleService.getById(id);

		// 转换对象
		SysRoleVO role = SysRoleConvert.INSTANCE.convert(entity);

		// 查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.getMenuIdList(id);
		role.setMenuIdList(menuIdList);

		// 查询角色对应的数据权限
		List<Long> orgIdList = sysRoleDataScopeService.getOrgIdList(id);
		role.setOrgIdList(orgIdList);

		return Result.success(role);
	}

	@PostMapping
	@Operation(summary = "保存", hidden = true)
	@SaCheckPermission("sys:role:info")
	public Result<String> save(@RequestBody @Valid SysRoleVO vo){
		sysRoleService.save(vo);

		return Result.success();
	}

	@PutMapping
	@Operation(summary = "修改")
	@SaCheckPermission("sys:role:info")
	public Result<String> update(@RequestBody @Valid SysRoleVO vo){
		sysRoleService.update(vo);

		return Result.success();
	}

	@DeleteMapping
	@Operation(summary = "删除")
	@SaCheckPermission("sys:role:info")
	public Result<String> delete(@RequestBody List<Long> idList){
		sysRoleService.delete(idList);

		return Result.success();
	}

//	@GetMapping("menu")
//	@Operation(summary = "角色菜单")
//	@SaCheckPermission("sys:role:menu")
//	public Result<List<SysMenuVO>> menu(){
//		UserDetail user = SecurityUser.getUser();
//		List<SysMenuVO> list = sysMenuService.getUserMenuList(user, null);
//
//		return Result.ok(list);
//	}
}