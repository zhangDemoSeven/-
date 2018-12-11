package com.inter.pojo.paper;

import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class Exam {
    private Integer id;

    private String examName;

    private String userName;

    private String status;

    private Integer types;

    private String showeye;

    private String classesIds;
    
    private String questiontypesIds;

    private Integer stageId;

    private Integer booksId;

    private String chapterIds;

    private Date startTime;

    private Date endTime;

    private String singleJoins;

    private String mulitpleJoins;

    private String qaaJoins;

    private String upperJoins;

    private Integer singleNumber;

    private Integer singleFraction;

    private Integer mulitNumber;

    private Integer mulitFraction;

    private Integer qaaNumber;

    private Integer qaaFraction;

    private Integer upperNumber;

    private Integer upperFraction;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    @Transient
    private String chapterName;
    
    @Transient
    private String booksName;
    
    @Transient
    private String stageName;

    @Transient
    private String classesNames;
    
    
    public String getClassesNames() {
		return classesNames;
	}

	public void setClassesNames(String classesNames) {
		this.classesNames = classesNames;
	}

	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public String getClassesIds() {
		return classesIds;
	}

	public void setClassesIds(String classesIds) {
		this.classesIds = classesIds;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getBooksName() {
		return booksName;
	}

	public void setBooksName(String booksName) {
		this.booksName = booksName;
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

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getShoweye() {
        return showeye;
    }

    public void setShoweye(String showeye) {
        this.showeye = showeye == null ? null : showeye.trim();
    }

    public String getQuestiontypesIds() {
        return questiontypesIds;
    }

    public void setQuestiontypesIds(String questiontypesIds) {
        this.questiontypesIds = questiontypesIds == null ? null : questiontypesIds.trim();
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
    }

    public String getChapterIds() {
        return chapterIds;
    }

    public void setChapterIds(String chapterIds) {
        this.chapterIds = chapterIds == null ? null : chapterIds.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSingleJoins() {
        return singleJoins;
    }

    public void setSingleJoins(String singleJoins) {
        this.singleJoins = singleJoins == null ? null : singleJoins.trim();
    }

    public String getMulitpleJoins() {
        return mulitpleJoins;
    }

    public void setMulitpleJoins(String mulitpleJoins) {
        this.mulitpleJoins = mulitpleJoins == null ? null : mulitpleJoins.trim();
    }


    public String getQaaJoins() {
        return qaaJoins;
    }

    public void setQaaJoins(String qaaJoins) {
        this.qaaJoins = qaaJoins == null ? null : qaaJoins.trim();
    }

    public String getUpperJoins() {
        return upperJoins;
    }

    public void setUpperJoins(String upperJoins) {
        this.upperJoins = upperJoins == null ? null : upperJoins.trim();
    }

    public Integer getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(Integer singleNumber) {
        this.singleNumber = singleNumber;
    }

    public Integer getSingleFraction() {
        return singleFraction;
    }

    public void setSingleFraction(Integer singleFraction) {
        this.singleFraction = singleFraction;
    }

    public Integer getMulitNumber() {
        return mulitNumber;
    }

    public void setMulitNumber(Integer mulitNumber) {
        this.mulitNumber = mulitNumber;
    }

    public Integer getMulitFraction() {
        return mulitFraction;
    }

    public void setMulitFraction(Integer mulitFraction) {
        this.mulitFraction = mulitFraction;
    }


    public Integer getQaaNumber() {
        return qaaNumber;
    }

    public void setQaaNumber(Integer qaaNumber) {
        this.qaaNumber = qaaNumber;
    }

    public Integer getQaaFraction() {
        return qaaFraction;
    }

    public void setQaaFraction(Integer qaaFraction) {
        this.qaaFraction = qaaFraction;
    }

    public Integer getUpperNumber() {
        return upperNumber;
    }

    public void setUpperNumber(Integer upperNumber) {
        this.upperNumber = upperNumber;
    }

    public Integer getUpperFraction() {
        return upperFraction;
    }

    public void setUpperFraction(Integer upperFraction) {
        this.upperFraction = upperFraction;
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

	@Override
	public String toString() {
		return "Exam [id=" + id + ", examName=" + examName + ", userName=" + userName + ", status=" + status
				+ ", types=" + types + ", showeye=" + showeye + ", classesIds=" + classesIds + ", questiontypesIds="
				+ questiontypesIds + ", stageId=" + stageId + ", booksId=" + booksId + ", chapterIds=" + chapterIds
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", singleJoins=" + singleJoins
				+ ", mulitpleJoins=" + mulitpleJoins + ", qaaJoins=" + qaaJoins + ", upperJoins=" + upperJoins
				+ ", singleNumber=" + singleNumber + ", singleFraction=" + singleFraction + ", mulitNumber="
				+ mulitNumber + ", mulitFraction=" + mulitFraction + ", qaaNumber=" + qaaNumber + ", qaaFraction="
				+ qaaFraction + ", upperNumber=" + upperNumber + ", upperFraction=" + upperFraction + ", createUser="
				+ createUser + ", createTime=" + createTime + ", modifyUser=" + modifyUser + ", modifyTime="
				+ modifyTime + ", chapterName=" + chapterName + ", booksName=" + booksName + ", stageName=" + stageName
				+ ", classesNames=" + classesNames + "]";
	}
    
    
}