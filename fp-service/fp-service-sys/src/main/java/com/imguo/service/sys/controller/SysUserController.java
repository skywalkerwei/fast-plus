package com.imguo.service.sys.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.page.PageResult;
import com.imguo.model.sys.query.SysUserQuery;
import com.imguo.model.sys.vo.SysUserVO;
import com.imguo.service.sys.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@Tag(name="用户管理")
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @SaCheckPermission("sys:user:pag")
    public Result<PageResult<SysUserVO>> page(@Valid SysUserQuery query){
        PageResult<SysUserVO> page = sysUserService.page(query);
        return Result.success(page);
    }

//    @GetMapping("{id}")
//    @Operation(summary = "信息")
////    @SaCheckPermission("sys:user:info")
//    public Result<SysUserVO> get(@PathVariable("id") Long id){
//        SysUser entity = sysUserService.getById(id);
//
//        SysUserVO vo = SysUserConvert.INSTANCE.convert(entity);
//
////        // 用户角色列表
////        List<Long> roleIdList = sysUserRoleService.getRoleIdList(id);
////        vo.setRoleIdList(roleIdList);
////
////        // 用户岗位列表
////        List<Long> postIdList = sysUserPostService.getPostIdList(id);
////        vo.setPostIdList(postIdList);
//
//        return Result.success(vo);
//    }


}
