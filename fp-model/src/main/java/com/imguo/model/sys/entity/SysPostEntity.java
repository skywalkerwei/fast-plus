package com.imguo.model.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 岗位管理
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_post")
public class SysPostEntity extends SysBaseEntity {
	/**
	* 岗位编码
	*/
	private String postCode;
	/**
	* 岗位名称
	*/
	private String postName;
	/**
	* 排序
	*/
	private Integer sort;
	/**
	* 状态  0：停用   1：正常
	*/
	private Integer status;

}