package com.fx.core.dao.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 账号
     */
    private String account;

    /**
     * 用户名(用来显示)
     */
    private String name;

    /**
     * 手机号
     */
    private Integer mobilePhone;

    /**
     * 邮箱地址
     */
    private String eMail;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 密码随机盐
     */
    private String salt;

    /**
     * 是否被锁定
     */
    private String isLocked;

    /**
     * 密码是否失效
     */
    private String passwdExpired;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 修改日期
     */
    private Date updatedDate;

    /**
     * t_user
     */
    private static final long serialVersionUID = 1L;

    public User(String userId, String account, String name, Integer mobilePhone, String eMail, String passwd, String salt, String isLocked, String passwdExpired, String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
        this.userId = userId;
        this.account = account;
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.eMail = eMail;
        this.passwd = passwd;
        this.salt = salt;
        this.isLocked = isLocked;
        this.passwdExpired = passwdExpired;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public User() {
        super();
    }

    /**
     * 用户ID
     * @return USER_ID 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 账号
     * @return ACCOUNT 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 用户名(用来显示)
     * @return NAME 用户名(用来显示)
     */
    public String getName() {
        return name;
    }

    /**
     * 用户名(用来显示)
     * @param name 用户名(用来显示)
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 手机号
     * @return MOBILE_PHONE 手机号
     */
    public Integer getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 手机号
     * @param mobilePhone 手机号
     */
    public void setMobilePhone(Integer mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 邮箱地址
     * @return E_MAIL 邮箱地址
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * 邮箱地址
     * @param eMail 邮箱地址
     */
    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    /**
     * 密码
     * @return PASSWD 密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 密码
     * @param passwd 密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * 密码随机盐
     * @return SALT 密码随机盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 密码随机盐
     * @param salt 密码随机盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 是否被锁定
     * @return IS_LOCKED 是否被锁定
     */
    public String getIsLocked() {
        return isLocked;
    }

    /**
     * 是否被锁定
     * @param isLocked 是否被锁定
     */
    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked == null ? null : isLocked.trim();
    }

    /**
     * 密码是否失效
     * @return PASSWD_EXPIRED 密码是否失效
     */
    public String getPasswdExpired() {
        return passwdExpired;
    }

    /**
     * 密码是否失效
     * @param passwdExpired 密码是否失效
     */
    public void setPasswdExpired(String passwdExpired) {
        this.passwdExpired = passwdExpired == null ? null : passwdExpired.trim();
    }

    /**
     * 创建人
     * @return CREATED_BY 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 创建时间
     * @return CREATED_DATE 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 创建时间
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 修改人
     * @return UPDATED_BY 修改人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 修改人
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 修改日期
     * @return UPDATED_DATE 修改日期
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 修改日期
     * @param updatedDate 修改日期
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

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
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.geteMail() == null ? other.geteMail() == null : this.geteMail().equals(other.geteMail()))
            && (this.getPasswd() == null ? other.getPasswd() == null : this.getPasswd().equals(other.getPasswd()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getPasswdExpired() == null ? other.getPasswdExpired() == null : this.getPasswdExpired().equals(other.getPasswdExpired()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedDate() == null ? other.getCreatedDate() == null : this.getCreatedDate().equals(other.getCreatedDate()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getUpdatedDate() == null ? other.getUpdatedDate() == null : this.getUpdatedDate().equals(other.getUpdatedDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((geteMail() == null) ? 0 : geteMail().hashCode());
        result = prime * result + ((getPasswd() == null) ? 0 : getPasswd().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getPasswdExpired() == null) ? 0 : getPasswdExpired().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedDate() == null) ? 0 : getCreatedDate().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getUpdatedDate() == null) ? 0 : getUpdatedDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", eMail=").append(eMail);
        sb.append(", passwd=").append(passwd);
        sb.append(", salt=").append(salt);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", passwdExpired=").append(passwdExpired);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}