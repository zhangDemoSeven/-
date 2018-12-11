package com.inter.pojo.dictionaries;

import java.util.Date;

import javax.persistence.Transient;

public class Chapter {
    private Integer id;

    private String name;

    private String prohibition;

    private String status;

    private Integer booksId;

    private String createUser;

    private String modifyUser;

    private Date createTime;

    private Date modifyTime;

    @Transient
    private String stageName;
    
    @Transient
    private String booksName;
    
    public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getBooksName() {
		return booksName;
	}

	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProhibition() {
        return prohibition;
    }

    public void setProhibition(String prohibition) {
        this.prohibition = prohibition == null ? null : prohibition.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", prohibition=" + prohibition + ", status=" + status
				+ ", booksId=" + booksId + ", createUser=" + createUser + ", modifyUser=" + modifyUser + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", stageName=" + stageName + ", booksName=" + booksName
				+ "]";
	}
    
    
    
}