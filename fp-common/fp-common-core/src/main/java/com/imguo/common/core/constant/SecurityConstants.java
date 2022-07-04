package com.imguo.common.core.constant;

/**
 * 权限相关常量
 *
 */
public interface SecurityConstants {

  /** 用户ID字段 */
  String DETAILS_USER_ID = "userId";

  /** 部门ID */
  String DEPT_ID = "deptId";

  /** 用户名字段 */
  String DETAILS_USERNAME = "username";

  /** 登录URL */
  String OAUTH_TOKEN = "/oauth/token";

  /** 店铺字段 */
  String DETAILS_SHOP_ID = "shopId";
  /** 租户字段 */
  String DETAILS_TENANT_ID = "tenantId";

  /** 无权访问 */
  String UNAUTHARIZED = "无权访问";

  /** 来源 */
  String SOURCE = "source";

  /** 系统内部 */
  String SOURCE_IN = "source_in";

  /** sys_oauth_client_details 表的字段，不包括client_id、client_secret */
  String CLIENT_FIELDS =
      "client_id, client_secret, resource_ids, scope, "
          + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
          + "refresh_token_validity, additional_information, autoapprove";

  /** JdbcClientDetailsService 查询语句 */
  String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from sys_oauth_client_details";

  /** 按条件client_id 查询 */
  String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

  /** 默认的查询语句 */
  String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

  /** 角色前缀 */
  String ROLE = "ROLE_";

  /** 资源服务器默认bean名称 */
  String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";

  /** 调度任务默认bean名称 */
  String XXLJOB_SERVER_CONFIGURER = "xxlJobConfigurerAdapter";
}
