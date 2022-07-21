package com.imguo.service.sys.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.util.StrUtil;
import com.imguo.common.core.entity.Result;
import com.imguo.common.core.page.PageResult;
import com.imguo.common.security.util.SecurityUtils;
import com.imguo.model.sys.convert.SysUserConvert;
import com.imguo.model.sys.entity.SysUserEntity;
import com.imguo.model.sys.query.SysUserQuery;
import com.imguo.model.sys.vo.SysUserPasswordVO;
import com.imguo.model.sys.vo.SysUserVO;
import com.imguo.service.sys.service.SysUserPostService;
import com.imguo.service.sys.service.SysUserRoleService;
import com.imguo.service.sys.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@Tag(name="用户管理")
public class SysUserController {

    private final SysUserService sysUserService;
    private final SysUserRoleService sysUserRoleService;
    private final SysUserPostService sysUserPostService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @SaCheckPermission("sys:user:pag")
    public Result<PageResult<SysUserVO>> page(@Valid SysUserQuery query){
        PageResult<SysUserVO> page = sysUserService.page(query);
        return Result.success(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @SaCheckPermission("sys:user:info")
    public Result<SysUserVO> get(@PathVariable("id") Long id){
        SysUserEntity entity = sysUserService.getById(id);

        SysUserVO vo = SysUserConvert.INSTANCE.convert(entity);

        // 用户角色列表
        List<Long> roleIdList = sysUserRoleService.getRoleIdList(id);
        vo.setRoleIdList(roleIdList);

        // 用户岗位列表
        List<Long> postIdList = sysUserPostService.getPostIdList(id);
        vo.setPostIdList(postIdList);

        return Result.success(vo);
    }


    @GetMapping("info")
    @Operation(summary = "登录用户")
    public Result<SysUserVO> info(){
        long uid =     SecurityUtils.getSysUserId();
        SysUserEntity entity = sysUserService.getById(uid);
        SysUserVO vo = SysUserConvert.INSTANCE.convert(entity);
        // 用户角色列表
        List<Long> roleIdList = sysUserRoleService.getRoleIdList(uid);
        vo.setRoleIdList(roleIdList);
        // 用户岗位列表
        List<Long> postIdList = sysUserPostService.getPostIdList(uid);
        vo.setPostIdList(postIdList);
        return Result.success(vo);
    }

    @PutMapping("password")
    @Operation(summary = "修改密码")
    public Result<String> password(@RequestBody @Valid SysUserPasswordVO vo){
        long uid =     SecurityUtils.getSysUserId();
        SysUserEntity user = sysUserService.getById(uid);

        if(!passwordEncoder.matches(vo.getPassword(), user.getPassword())){
            return Result.fail("原密码不正确");
        }
        // 修改密码
        sysUserService.updatePassword(user.getId(), passwordEncoder.encode(vo.getNewPassword()));

        return Result.success();
    }

    @PostMapping
    @Operation(summary = "保存")
//    @SaCheckPermission("sys:user:save")
    public Result<String> save(@RequestBody @Valid SysUserVO vo){
        // 密码加密
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));

        // 保存
        sysUserService.save(vo);

        return Result.success();
    }

    @PutMapping
    @Operation(summary = "修改")
    @SaCheckPermission("sys:user:update")
    public Result<String> update(@RequestBody @Valid SysUserVO vo){
        // 如果密码不为空，则进行加密处理
        if(StrUtil.isBlank(vo.getPassword())){
            vo.setPassword(null);
        }else{
            vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        }
        sysUserService.update(vo);
        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @SaCheckPermission("sys:user:delete")
    public Result<String> delete(@RequestBody List<Long> idList){
        Long userId =  SecurityUtils.getSysUserId();
        if(idList.contains(userId)){
            return Result.fail("不能删除当前登录用户");
        }
        sysUserService.delete(idList);

        return Result.success();
    }


}
