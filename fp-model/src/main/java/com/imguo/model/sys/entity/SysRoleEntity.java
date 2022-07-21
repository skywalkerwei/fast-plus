package com.imguo.model.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 角色
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRoleEntity extends SysBaseEntity {
	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据范围
	 */
	private Integer dataScope;
	/**
	 * 机构ID
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long orgId;
}
