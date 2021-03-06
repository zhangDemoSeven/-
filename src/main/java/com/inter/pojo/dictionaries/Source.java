package com.inter.pojo.dictionaries;

import java.util.Date;

import javax.persistence.Transient;

public class Source {
    private Integer id;

    private Integer pid;

    private String sourceName;

    private String status;

    private String prohibition;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;
    
    @Transient
    private String parentName;
    
    

    @Override
	public String toString() {
		return "Source [id=" + id + ", pid=" + pid + ", sourceName=" + sourceName + ", status=" + status
				+ ", prohibition=" + prohibition + ", createUser=" + createUser + ", createTime=" + createTime
				+ ", modifyUser=" + modifyUser + ", modifyTime=" + modifyTime + ", parentName=" + parentName + "]";
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProhibition() {
        return prohibition;
    }

    public void setProhibition(String prohibition) {
        this.prohibition = prohibition == null ? null : prohibition.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}