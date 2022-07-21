package com.imguo.service.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.model.common.constant.Constant;
import com.imguo.model.sys.convert.SysMenuConvert;
import com.imguo.model.sys.entity.SysMenuEntity;
import com.imguo.model.sys.vo.SysMenuVO;
import com.imguo.service.sys.service.SysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * 菜单管理
 *
 */
@RestController
@RequestMapping("menu")
@Tag(name="菜单管理")
@AllArgsConstructor
public class SysMenuController {
	private final SysMenuService sysMenuService;

//	@GetMapping("nav")
//	@Operation(summary = "菜单导航")
//	public Result<List<SysMenuVO>> nav(){
//		UserDetail user = SecurityUser.getUser();
//		List<SysMenuVO> list = sysMenuService.getUserMenuList(user, MenuTypeEnum.MENU.getValue());
//
//		return Result.success(list);
//	}

//	@GetMapping("authority")
//	@Operation(summary = "用户权限标识")
//	public Result<Set<String>> authority(){
//		UserDetail user = SecurityUser.getUser();
//		Set<String> set = sysMenuService.getUserAuthority(user);
//
//		return Result.success(set);
//	}

	@GetMapping("list")
	@Operation(summary = "菜单列表")
	@Parameter(name = "type", description = "菜单类型 0：菜单 1：按钮  2：接口  null：全部")
	@SaCheckPermission("sys:menu:list")
	public Result<List<SysMenuVO>> list(Integer type){
		List<SysMenuVO> list = sysMenuService.getMenuList(type);

		return Result.success(list);
	}

	@GetMapping("{id}")
	@Operation(summary = "信息")
	@SaCheckPermission("sys:menu:info")
	public Result<SysMenuVO> get(@PathVariable("id") Long id){
		SysMenuEntity entity = sysMenuService.getById(id);
		SysMenuVO vo = SysMenuConvert.INSTANCE.convert(entity);

		// 获取上级菜单名称
		if(!Constant.ROOT.equals(entity.getPid())){
			SysMenuEntity parentEntity = sysMenuService.getById(entity.getPid());
			vo.setParentName(parentEntity.getName());
		}

		return Result.success(vo);
	}

	@PostMapping
	@Operation(summary = "保存")
	@SaCheckPermission("sys:menu:save")
	public Result<String> save(@RequestBody @Valid SysMenuVO vo){
		sysMenuService.save(vo);

		return Result.success();
	}

	@PutMapping
	@Operation(summary = "修改")
	@SaCheckPermission("sys:menu:update")
	public Result<String> update(@RequestBody @Valid SysMenuVO vo){
		sysMenuService.update(vo);

		return Result.success();
	}

	@DeleteMapping("{id}")
	@Operation(summary = "删除")
	@SaCheckPermission("sys:menu:delete")
	public Result<String> delete(@PathVariable("id") Long id){
		// 判断是否有子菜单或按钮
		Long count = sysMenuService.getSubMenuCount(id);
		if(count > 0){
			return Result.fail("请先删除子菜单");
		}

		sysMenuService.delete(id);

		return Result.success();
	}
}