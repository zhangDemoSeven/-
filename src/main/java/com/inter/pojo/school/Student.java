package com.inter.pojo.school;

import javax.persistence.Transient;

public class Student {
    private Integer id;

    private Integer age;

    private String qq;

    private String subName;

    private String searchName;

    private String unqueCode;

    private String isOver;

    private Integer classesId;

    private Integer userId;

    private String examId;

    private Integer educationId;

    private Integer majorId;

    private Integer stiuationId;

    private Integer classificationId;

    private Integer sourceId;

    private Integer toolId;

    private Integer channelId;

    private Integer user1;

    private Integer user2;

    private Integer user3;

    
    @Transient
    private String classesNames;
    
    @Transient
    private String educationName;
    
    @Transient
    private String majorName;
    
    @Transient
    private String situationName;
    
    @Transient
    private String classificationName;
    
    
    
    
    public String getClassesNames() {
		return classesNames;
	}

	public void setClassesNames(String classesNames) {
		this.classesNames = classesNames;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getSituationName() {
		return situationName;
	}

	public void setSituationName(String situationName) {
		this.situationName = situationName;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName == null ? null : searchName.trim();
    }

    public String getUnqueCode() {
        return unqueCode;
    }

    public void setUnqueCode(String unqueCode) {
        this.unqueCode = unqueCode == null ? null : unqueCode.trim();
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver == null ? null : isOver.trim();
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getStiuationId() {
        return stiuationId;
    }

    public void setStiuationId(Integer stiuationId) {
        this.stiuationId = stiuationId;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getUser1() {
        return user1;
    }

    public void setUser1(Integer user1) {
        this.user1 = user1;
    }

    public Integer getUser2() {
        return user2;
    }

    public void setUser2(Integer user2) {
        this.user2 = user2;
    }

    public Integer getUser3() {
        return user3;
    }

    public void setUser3(Integer user3) {
        this.user3 = user3;
    }
}