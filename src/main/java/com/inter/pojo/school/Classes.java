package com.inter.pojo.school;

import java.util.Date;

import javax.persistence.Transient;

public class Classes {
    private Integer id;

    private String className;

    private Date shiftTime;

    private Integer stageId;

    private Integer ison;

    
	@Transient
	private String teacherIds;
	
	@Transient
	private String teacherNames;
	
	@Transient
	private String stageName;
	
	
    
    public String getTeacherIds() {
		return teacherIds;
	}

	public void setTeacherIds(String teacherIds) {
		this.teacherIds = teacherIds;
	}

	public String getTeacherNames() {
		return teacherNames;
	}

	public void setTeacherNames(String teacherNames) {
		this.teacherNames = teacherNames;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Date getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(Date shiftTime) {
        this.shiftTime = shiftTime;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Integer getIson() {
        return ison;
    }

    public void setIson(Integer ison) {
        this.ison = ison;
    }
}