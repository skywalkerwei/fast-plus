package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 客户端管理
 * @TableName sys_oauth_client
 */
@TableName(value ="sys_oauth_client")
@Data
public class SysOauthClient implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 客户端id
     */
    @TableField(value = "client_id")
    private String client_id;

    /**
     * 客户端密钥
     */
    @TableField(value = "client_secret")
    private String client_secret;

    /**
     * 资源ids
     */
    @TableField(value = "resource_ids")
    private String resource_ids;

    /**
     * 授权范围
     */
    @TableField(value = "scope")
    private String scope;

    /**
     * 授权类型
     */
    @TableField(value = "authorized_grant_types")
    private String authorized_grant_types;

    /**
     * 回调地址
     */
    @TableField(value = "web_server_redirect_uri")
    private String web_server_redirect_uri;

    /**
     * 权限标识
     */
    @TableField(value = "authorities")
    private String authorities;

    /**
     * 访问令牌有效期
     */
    @TableField(value = "access_token_validity")
    private Integer access_token_validity;

    /**
     * 刷新令牌有效期
     */
    @TableField(value = "refresh_token_validity")
    private Integer refresh_token_validity;

    /**
     * 附加信息
     */
    @TableField(value = "additional_information")
    private String additional_information;

    /**
     * 自动授权
     */
    @TableField(value = "autoapprove")
    private String autoapprove;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 删除标识  0：正常   1：已删除
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 创建者
     */
    @TableField(value = "creator")
    private Long creator;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime create_time;

    /**
     * 更新者
     */
    @TableField(value = "updater")
    private Long updater;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime update_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysOauthClient other = (SysOauthClient) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClient_id() == null ? other.getClient_id() == null : this.getClient_id().equals(other.getClient_id()))
            && (this.getClient_secret() == null ? other.getClient_secret() == null : this.getClient_secret().equals(other.getClient_secret()))
            && (this.getResource_ids() == null ? other.getResource_ids() == null : this.getResource_ids().equals(other.getResource_ids()))
            && (this.getScope() == null ? other.getScope() == null : this.getScope().equals(other.getScope()))
            && (this.getAuthorized_grant_types() == null ? other.getAuthorized_grant_types() == null : this.getAuthorized_grant_types().equals(other.getAuthorized_grant_types()))
            && (this.getWeb_server_redirect_uri() == null ? other.getWeb_server_redirect_uri() == null : this.getWeb_server_redirect_uri().equals(other.getWeb_server_redirect_uri()))
            && (this.getAuthorities() == null ? other.getAuthorities() == null : this.getAuthorities().equals(other.getAuthorities()))
            && (this.getAccess_token_validity() == null ? other.getAccess_token_validity() == null : this.getAccess_token_validity().equals(other.getAccess_token_validity()))
            && (this.getRefresh_token_validity() == null ? other.getRefresh_token_validity() == null : this.getRefresh_token_validity().equals(other.getRefresh_token_validity()))
            && (this.getAdditional_information() == null ? other.getAdditional_information() == null : this.getAdditional_information().equals(other.getAdditional_information()))
            && (this.getAutoapprove() == null ? other.getAutoapprove() == null : this.getAutoapprove().equals(other.getAutoapprove()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClient_id() == null) ? 0 : getClient_id().hashCode());
        result = prime * result + ((getClient_secret() == null) ? 0 : getClient_secret().hashCode());
        result = prime * result + ((getResource_ids() == null) ? 0 : getResource_ids().hashCode());
        result = prime * result + ((getScope() == null) ? 0 : getScope().hashCode());
        result = prime * result + ((getAuthorized_grant_types() == null) ? 0 : getAuthorized_grant_types().hashCode());
        result = prime * result + ((getWeb_server_redirect_uri() == null) ? 0 : getWeb_server_redirect_uri().hashCode());
        result = prime * result + ((getAuthorities() == null) ? 0 : getAuthorities().hashCode());
        result = prime * result + ((getAccess_token_validity() == null) ? 0 : getAccess_token_validity().hashCode());
        result = prime * result + ((getRefresh_token_validity() == null) ? 0 : getRefresh_token_validity().hashCode());
        result = prime * result + ((getAdditional_information() == null) ? 0 : getAdditional_information().hashCode());
        result = prime * result + ((getAutoapprove() == null) ? 0 : getAutoapprove().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", client_id=").append(client_id);
        sb.append(", client_secret=").append(client_secret);
        sb.append(", resource_ids=").append(resource_ids);
        sb.append(", scope=").append(scope);
        sb.append(", authorized_grant_types=").append(authorized_grant_types);
        sb.append(", web_server_redirect_uri=").append(web_server_redirect_uri);
        sb.append(", authorities=").append(authorities);
        sb.append(", access_token_validity=").append(access_token_validity);
        sb.append(", refresh_token_validity=").append(refresh_token_validity);
        sb.append(", additional_information=").append(additional_information);
        sb.append(", autoapprove=").append(autoapprove);
        sb.append(", version=").append(version);
        sb.append(", deleted=").append(deleted);
        sb.append(", creator=").append(creator);
        sb.append(", create_time=").append(create_time);
        sb.append(", updater=").append(updater);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}