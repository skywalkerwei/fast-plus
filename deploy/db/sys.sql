# ************************************************************
# Sequel Ace SQL dump
# 版本号： 20033
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# 主机: git.imguo.com (MySQL 8.0.18)
# 数据库: api
# 生成时间: 2022-08-17 15:33:19 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# 转储表 pay_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pay_config`;

CREATE TABLE `pay_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '支付类型：1.微信；2.支付宝；',
  `app_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '应用Id',
  `mch_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商户号',
  `mch_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商户密钥',
  `cert_serial_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '证书序列号',
  `apiv3_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'apiV3秘钥',
  `key_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'apiclient_cert.p12文件的绝对路径，或者如果放在项目中，请以classpath:开头指定.',
  `private_key_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'apiv3 商户apiclient_key.pem',
  `private_cert_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'apiv3 商户apiclient_cert.pem',
  `sub_app_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '微信移动应用的APPID',
  `version` int(11) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除：0.显示；1.隐藏；',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='支付配置';

LOCK TABLES `pay_config` WRITE;
/*!40000 ALTER TABLE `pay_config` DISABLE KEYS */;

INSERT INTO `pay_config` (`id`, `type`, `app_id`, `mch_id`, `mch_key`, `cert_serial_no`, `apiv3_key`, `key_path`, `private_key_path`, `private_cert_path`, `sub_app_id`, `version`, `create_time`, `update_time`, `deleted`)
VALUES
	(1,1,'','','','','','classpath:cert/apiclient_cert.p12','classpath:cert/apiclient_key.pem','classpath:cert/apiclient_cert.pem','',0,'2022-08-07 00:00:00','2022-08-17 23:33:08',0);

/*!40000 ALTER TABLE `pay_config` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 sys_dict_data
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dict_type_id` bigint(20) NOT NULL COMMENT '字典类型ID',
  `dict_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典标签',
  `dict_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '字典值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典数据';

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;

INSERT INTO `sys_dict_data` (`id`, `dict_type_id`, `dict_label`, `dict_value`, `remark`, `sort`, `version`, `deleted`, `creator`, `create_time`, `updater`, `update_time`)
VALUES
	(1,1,'停用','0','',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(2,1,'正常','1','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(3,2,'男','0','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(4,2,'女','1','',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(5,2,'未知','2','',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(6,3,'正常','1','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(7,3,'停用','0','',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(8,4,'全部数据','0','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(9,4,'本部门及子部门数据','1','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(10,4,'本部门数据','2','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(11,4,'本人数据','3','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(12,4,'自定义数据','4','',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18');

/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 sys_dict_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典类型',
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典类型';

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;

INSERT INTO `sys_dict_type` (`id`, `dict_type`, `dict_name`, `remark`, `sort`, `version`, `deleted`, `creator`, `create_time`, `updater`, `update_time`)
VALUES
	(1,'post_status','岗位管理','状态',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(2,'user_gender','用户管理','性别',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(3,'user_status','用户管理','状态',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(4,'role_data_scope','角色管理','数据范围',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18');

/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 sys_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级ID，一级菜单为0',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单URL',
  `authority` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '授权标识(多个用逗号分隔，如：sys:menu:list,sys:menu:save)',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型   0：菜单   1：按钮   2：接口',
  `open_style` tinyint(4) DEFAULT NULL COMMENT '打开方式   0：内部   1：外部',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='菜单管理';

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;

INSERT INTO `sys_menu` (`id`, `pid`, `name`, `url`, `authority`, `type`, `open_style`, `icon`, `sort`, `version`, `deleted`, `creator`, `create_time`, `updater`, `update_time`)
VALUES
	(1,0,'系统设置',NULL,NULL,0,0,'icon-setting',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(2,1,'菜单管理','sys/menu/index',NULL,0,0,'icon-menu',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(3,2,'查看','','sys:menu:list',1,0,'',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(4,2,'新增','','sys:menu:save',1,0,'',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(5,2,'修改','','sys:menu:update,sys:menu:info',1,0,'',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(6,2,'删除','','sys:menu:delete',1,0,'',3,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(7,1,'数据字典','sys/dict/type','',0,0,'icon-insertrowabove',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(8,7,'查询','','sys:dict:page',1,0,'',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(9,7,'新增','','sys:dict:save',1,0,'',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(10,7,'修改','','sys:dict:update,sys:dict:info',1,0,'',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(11,7,'删除','','sys:dict:delete',1,0,'',3,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(12,0,'权限管理','','',0,0,'icon-safetycertificate',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(13,12,'岗位管理','sys/post/index','',0,0,'icon-addteam',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(14,13,'查询','','sys:post:page',1,0,'',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(15,13,'新增','','sys:post:save',1,0,'',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(16,13,'修改','','sys:post:update,sys:post:info',1,0,'',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(17,13,'删除','','sys:post:delete',1,0,'',3,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(18,12,'机构管理','sys/org/index','',0,0,'icon-team',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(19,18,'查询','','sys:org:list',1,0,'',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(20,18,'新增','','sys:org:save',1,0,'',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(21,18,'修改','','sys:org:update,sys:org:info',1,0,'',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(22,18,'删除','','sys:org:delete',1,0,'',3,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(23,12,'角色管理','sys/role/index','',0,0,'icon-team',3,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(24,23,'查询','','sys:role:page',1,0,'',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(25,23,'新增','','sys:role:save,sys:role:menu,sys:org:list',1,0,'',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(26,23,'修改','','sys:role:update,sys:role:info,sys:role:menu,sys:org:list,sys:user:page',1,0,'',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(27,23,'删除','','sys:role:delete',1,0,'',3,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(28,12,'用户管理','sys/user/index','',0,0,'icon-user',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(29,28,'查询','','sys:user:page',1,0,'',0,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(30,28,'新增','','sys:user:save,sys:role:list',1,0,'',1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(31,28,'修改','','sys:user:update,sys:user:info,sys:role:list',1,0,'',2,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18'),
	(32,28,'删除','','sys:user:delete',1,0,'',3,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18');

/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 sys_oauth_client
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_oauth_client`;

CREATE TABLE `sys_oauth_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户端id',
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '客户端密钥',
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '资源ids',
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '授权范围',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '授权类型',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '回调地址',
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限标识',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '访问令牌有效期',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '刷新令牌有效期',
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '附加信息',
  `autoapprove` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '自动授权',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='客户端管理';

LOCK TABLES `sys_oauth_client` WRITE;
/*!40000 ALTER TABLE `sys_oauth_client` DISABLE KEYS */;

INSERT INTO `sys_oauth_client` (`id`, `client_id`, `client_secret`, `resource_ids`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`, `version`, `deleted`, `creator`, `create_time`, `updater`, `update_time`)
VALUES
	(1,'web','123456','','all','[\"authorization_code\",\"password\",\"implicit\",\"client_credentials\",\"refresh_token\"]','https://gitee.com/makunet',NULL,43200,604800,NULL,'true',0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18');

/*!40000 ALTER TABLE `sys_oauth_client` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 sys_org
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '机构名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='机构管理';



# 转储表 sys_post
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_post`;

CREATE TABLE `sys_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `post_code` varchar(100) DEFAULT NULL COMMENT '岗位编码',
  `post_name` varchar(100) DEFAULT NULL COMMENT '岗位名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：停用   1：正常',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位管理';



# 转储表 sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `data_scope` tinyint(4) DEFAULT NULL COMMENT '数据范围  0：全部数据  1：本部门及子部门数据  2：本部门数据  3：本人数据  4：自定义数据',
  `org_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_org_id` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色管理';



# 转储表 sys_role_data_scope
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role_data_scope`;

CREATE TABLE `sys_role_data_scope` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `org_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色数据权限';



# 转储表 sys_role_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_menu_id` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单关系';



# 转储表 sys_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别   0：男   1：女   2：未知',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `org_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `super_admin` tinyint(4) DEFAULT NULL COMMENT '超级管理员   0：否   1：是',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：停用   1：正常',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户管理';

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;

INSERT INTO `sys_user` (`id`, `username`, `password`, `real_name`, `avatar`, `gender`, `email`, `mobile`, `org_id`, `super_admin`, `status`, `version`, `deleted`, `creator`, `create_time`, `updater`, `update_time`)
VALUES
	(10000,'admin','{bcrypt}$2a$10$mW/yJPHjyueQ1g26WNBz0uxVPa0GQdJO1fFZmqdkqgMTGnyszlXxu','admin','https://cdn.maku.net/images/avatar.png',0,'babamu@126.com','13612345678',NULL,1,1,0,0,10000,'2022-08-01 22:08:18',10000,'2022-08-01 22:08:18');

/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 sys_user_post
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user_post`;

CREATE TABLE `sys_user_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `post_id` bigint(20) DEFAULT NULL COMMENT '岗位ID',
  `version` int(11) NOT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_post_id` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户岗位关系';



# 转储表 sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色关系';



# 转储表 user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'PK',
  `user_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `nick_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `user_grade` tinyint(4) DEFAULT '0' COMMENT '用户等级：0、普通用户；1.会员',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别：1、男；2、女；0、未知；',
  `avatar_url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `city` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所在城市',
  `country` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所在国家',
  `province` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所在省份',
  `deleted` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除：0.显示；1.隐藏；',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_source` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户来源：微信小程序.WX-MA；普通H5.H5；APP.APP；',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '上级用户主键',
  `account_balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '账户余额（元）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE COMMENT '用户手机号',
  KEY `ids_number` (`user_number`) USING BTREE COMMENT '用户编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='商城用户';



# 转储表 wx_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wx_user`;

CREATE TABLE `wx_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '用户主键',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `openid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'openid',
  `session_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '会话密钥',
  `unionid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `version` int(11) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除：0.显示；1.隐藏；',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='微信用户';

LOCK TABLES `wx_user` WRITE;
/*!40000 ALTER TABLE `wx_user` DISABLE KEYS */;

INSERT INTO `wx_user` (`id`, `uid`, `phone`, `openid`, `session_key`, `unionid`, `avatar_url`, `nick_name`, `version`, `create_time`, `update_time`, `deleted`)
VALUES
	(1,0,'18627111095','odbtT5eCbsuLGOdUDW7EcY5ZT-Bg','S7OSXqH7oFrL6Ol7li2PZw==',NULL,'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoLYUxdeMXhX77275eXH3CZ6MdEsguzp3Xaa3BtCaEcpsW461mv1xmUibn0fckrk66B8icn55sWMC6w/132','kyle',4,'2022-08-17 09:41:44','2022-08-17 09:45:20',0);

/*!40000 ALTER TABLE `wx_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
