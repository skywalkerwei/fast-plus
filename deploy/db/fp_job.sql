# ************************************************************
# Sequel Ace SQL dump
# 版本号： 20033
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# 主机: git.imguo.com (MySQL 8.0.18)
# 数据库: fp_job
# 生成时间: 2022-08-17 15:33:42 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# 转储表 xxl_job_group
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_group`;

CREATE TABLE `xxl_job_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '执行器AppName',
  `title` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '执行器名称',
  `address_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '执行器地址类型：0=自动注册、1=手动录入',
  `address_list` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '执行器地址列表，多地址逗号分隔',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

LOCK TABLES `xxl_job_group` WRITE;
/*!40000 ALTER TABLE `xxl_job_group` DISABLE KEYS */;

INSERT INTO `xxl_job_group` (`id`, `app_name`, `title`, `address_type`, `address_list`, `update_time`)
VALUES
	(2,'job-test','测试接口',0,'http://192.168.3.51:9999/','2022-08-15 23:45:18');

/*!40000 ALTER TABLE `xxl_job_group` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 xxl_job_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_info`;

CREATE TABLE `xxl_job_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `author` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '作者',
  `alarm_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '报警邮件',
  `schedule_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NONE' COMMENT '调度类型',
  `schedule_conf` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '调度配置，值含义取决于调度类型',
  `misfire_strategy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'DO_NOTHING' COMMENT '调度过期策略',
  `executor_route_strategy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行器路由策略',
  `executor_handler` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行器任务参数',
  `executor_block_strategy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '阻塞处理策略',
  `executor_timeout` int(11) NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `glue_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'GLUE备注',
  `glue_updatetime` datetime DEFAULT NULL COMMENT 'GLUE更新时间',
  `child_jobid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '子任务ID，多个逗号分隔',
  `trigger_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '调度状态：0-停止，1-运行',
  `trigger_last_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '上次调度时间',
  `trigger_next_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '下次调度时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

LOCK TABLES `xxl_job_info` WRITE;
/*!40000 ALTER TABLE `xxl_job_info` DISABLE KEYS */;

INSERT INTO `xxl_job_info` (`id`, `job_group`, `job_desc`, `add_time`, `update_time`, `author`, `alarm_email`, `schedule_type`, `schedule_conf`, `misfire_strategy`, `executor_route_strategy`, `executor_handler`, `executor_param`, `executor_block_strategy`, `executor_timeout`, `executor_fail_retry_count`, `glue_type`, `glue_source`, `glue_remark`, `glue_updatetime`, `child_jobid`, `trigger_status`, `trigger_last_time`, `trigger_next_time`)
VALUES
	(2,2,'测试定时任务','2022-06-02 11:16:05','2022-08-13 10:05:46','test','','CRON','0 */1 * * * ? ','DO_NOTHING','FIRST','testJobHandler','123','SERIAL_EXECUTION',0,0,'BEAN','','GLUE代码初始化','2022-06-02 11:16:05','',1,1660578300000,1660578360000);

/*!40000 ALTER TABLE `xxl_job_info` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 xxl_job_lock
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_lock`;

CREATE TABLE `xxl_job_lock` (
  `lock_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '锁名称',
  PRIMARY KEY (`lock_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

LOCK TABLES `xxl_job_lock` WRITE;
/*!40000 ALTER TABLE `xxl_job_lock` DISABLE KEYS */;

INSERT INTO `xxl_job_lock` (`lock_name`)
VALUES
	('schedule_lock');

/*!40000 ALTER TABLE `xxl_job_lock` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 xxl_job_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_log`;

CREATE TABLE `xxl_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `executor_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行器地址，本次执行的地址',
  `executor_handler` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行器任务参数',
  `executor_sharding_param` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执行器任务分片参数，格式如 1/2',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `trigger_time` datetime DEFAULT NULL COMMENT '调度-时间',
  `trigger_code` int(11) NOT NULL COMMENT '调度-结果',
  `trigger_msg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '调度-日志',
  `handle_time` datetime DEFAULT NULL COMMENT '执行-时间',
  `handle_code` int(11) NOT NULL COMMENT '执行-状态',
  `handle_msg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '执行-日志',
  `alarm_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `I_trigger_time` (`trigger_time`) USING BTREE,
  KEY `I_handle_code` (`handle_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

LOCK TABLES `xxl_job_log` WRITE;
/*!40000 ALTER TABLE `xxl_job_log` DISABLE KEYS */;

INSERT INTO `xxl_job_log` (`id`, `job_group`, `job_id`, `executor_address`, `executor_handler`, `executor_param`, `executor_sharding_param`, `executor_fail_retry_count`, `trigger_time`, `trigger_code`, `trigger_msg`, `handle_time`, `handle_code`, `handle_msg`, `alarm_status`)
VALUES
	(1,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 20:39:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(2,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 20:40:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(3,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 20:41:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(4,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 20:42:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 20:42:10',200,'',0),
	(5,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 20:43:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 20:43:10',200,'',0),
	(6,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 20:44:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 20:44:10',200,'',0),
	(7,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 20:45:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 20:45:10',200,'',0),
	(8,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:14:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(9,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:15:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(10,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:16:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(11,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:17:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(12,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:18:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(13,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:19:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(14,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:20:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(15,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:21:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(16,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:22:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:22:10',200,'',0),
	(17,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:23:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：500<br>msg：xxl-rpc remoting fail, StatusCode(502) invalid. for url : http://192.168.3.51:9999/run',NULL,0,NULL,1),
	(18,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:24:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：500<br>msg：xxl-rpc remoting fail, StatusCode(502) invalid. for url : http://192.168.3.51:9999/run',NULL,0,NULL,1),
	(19,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:25:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(20,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:26:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(21,2,2,NULL,'testJobHandler','123',NULL,0,'2022-08-15 23:27:00',500,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：null<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>调度失败：执行器地址为空<br><br>',NULL,0,NULL,1),
	(22,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:28:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:28:10',200,'',0),
	(23,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:29:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:29:10',200,'',0),
	(24,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:30:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:30:10',200,'',0),
	(25,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:31:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:31:10',200,'',0),
	(26,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:32:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:32:10',200,'',0),
	(27,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:33:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:33:10',200,'',0),
	(28,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:34:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:34:10',200,'',0),
	(29,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:35:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:35:10',200,'',0),
	(30,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:36:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:36:10',200,'',0),
	(31,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:37:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:37:10',200,'',0),
	(32,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:38:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:38:10',200,'',0),
	(33,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:39:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:39:10',200,'',0),
	(34,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:40:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:40:10',200,'',0),
	(35,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:41:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:41:10',200,'',0),
	(36,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:42:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:42:10',200,'',0),
	(37,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:43:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:43:10',200,'',0),
	(38,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:44:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:44:10',200,'',0),
	(39,2,2,'http://192.168.3.51:9999/','testJobHandler','123',NULL,0,'2022-08-15 23:45:00',200,'任务触发类型：Cron触发<br>调度机器：192.168.3.51<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://192.168.3.51:9999/]<br>路由策略：第一个<br>阻塞处理策略：单机串行<br>任务超时时间：0<br>失败重试次数：0<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://192.168.3.51:9999/<br>code：200<br>msg：null','2022-08-15 23:45:10',200,'',0);

/*!40000 ALTER TABLE `xxl_job_log` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 xxl_job_log_report
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_log_report`;

CREATE TABLE `xxl_job_log_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trigger_day` datetime DEFAULT NULL COMMENT '调度-时间',
  `running_count` int(11) NOT NULL DEFAULT '0' COMMENT '运行中-日志数量',
  `suc_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行成功-日志数量',
  `fail_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行失败-日志数量',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `i_trigger_day` (`trigger_day`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

LOCK TABLES `xxl_job_log_report` WRITE;
/*!40000 ALTER TABLE `xxl_job_log_report` DISABLE KEYS */;

INSERT INTO `xxl_job_log_report` (`id`, `trigger_day`, `running_count`, `suc_count`, `fail_count`, `update_time`)
VALUES
	(1,'2022-08-13 00:00:00',0,0,0,NULL),
	(2,'2022-08-12 00:00:00',0,0,0,NULL),
	(3,'2022-08-11 00:00:00',0,0,0,NULL),
	(4,'2022-08-14 00:00:00',0,0,0,NULL),
	(5,'2022-08-15 00:00:00',0,22,16,NULL);

/*!40000 ALTER TABLE `xxl_job_log_report` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 xxl_job_logglue
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_logglue`;

CREATE TABLE `xxl_job_logglue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `glue_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'GLUE备注',
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;



# 转储表 xxl_job_registry
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_registry`;

CREATE TABLE `xxl_job_registry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registry_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `registry_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `registry_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `i_g_k_v` (`registry_group`,`registry_key`,`registry_value`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

LOCK TABLES `xxl_job_registry` WRITE;
/*!40000 ALTER TABLE `xxl_job_registry` DISABLE KEYS */;

INSERT INTO `xxl_job_registry` (`id`, `registry_group`, `registry_key`, `registry_value`, `update_time`)
VALUES
	(68,'EXECUTOR','job-test','http://192.168.3.51:9999/','2022-08-15 23:45:17');

/*!40000 ALTER TABLE `xxl_job_registry` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 xxl_job_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xxl_job_user`;

CREATE TABLE `xxl_job_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `role` tinyint(4) NOT NULL COMMENT '角色：0-普通用户、1-管理员',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限：执行器ID列表，多个逗号分割',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `i_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

LOCK TABLES `xxl_job_user` WRITE;
/*!40000 ALTER TABLE `xxl_job_user` DISABLE KEYS */;

INSERT INTO `xxl_job_user` (`id`, `username`, `password`, `role`, `permission`)
VALUES
	(1,'admin','e10adc3949ba59abbe56e057f20f883e',1,NULL);

/*!40000 ALTER TABLE `xxl_job_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
