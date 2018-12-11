package com.inter.pojo.paper;

import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class Score {
    private Integer id;

    private Integer singleSucc;

    private String singleSuccIds;

    private Integer singleErr;

    private String singleErrIds;

    private Integer multipleSucc;

    private String multipleSuccIds;

    private Integer multipleErr;

    private String multipleErrIds;

    private Integer singleScore;

    private Integer multipleScore;

    private Integer qaaScore;

    private Integer upperScore;

    private Integer score;

    private Integer status;

    private Integer studentId;

    private Integer examId;

    private Date executeTime;
    
    
    @Transient
    private Integer rank;

    @Transient
    private String nickName;
    
    
    
    public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSingleSucc() {
        return singleSucc;
    }

    public void setSingleSucc(Integer singleSucc) {
        this.singleSucc = singleSucc;
    }

    public String getSingleSuccIds() {
        return singleSuccIds;
    }

    public void setSingleSuccIds(String singleSuccIds) {
        this.singleSuccIds = singleSuccIds == null ? null : singleSuccIds.trim();
    }

    public Integer getSingleErr() {
        return singleErr;
    }

    public void setSingleErr(Integer singleErr) {
        this.singleErr = singleErr;
    }

    public String getSingleErrIds() {
        return singleErrIds;
    }

    public void setSingleErrIds(String singleErrIds) {
        this.singleErrIds = singleErrIds == null ? null : singleErrIds.trim();
    }

    public Integer getMultipleSucc() {
        return multipleSucc;
    }

    public void setMultipleSucc(Integer multipleSucc) {
        this.multipleSucc = multipleSucc;
    }

    public String getMultipleSuccIds() {
        return multipleSuccIds;
    }

    public void setMultipleSuccIds(String multipleSuccIds) {
        this.multipleSuccIds = multipleSuccIds == null ? null : multipleSuccIds.trim();
    }

    public Integer getMultipleErr() {
        return multipleErr;
    }

    public void setMultipleErr(Integer multipleErr) {
        this.multipleErr = multipleErr;
    }

    public String getMultipleErrIds() {
        return multipleErrIds;
    }

    public void setMultipleErrIds(String multipleErrIds) {
        this.multipleErrIds = multipleErrIds == null ? null : multipleErrIds.trim();
    }

    public Integer getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(Integer singleScore) {
        this.singleScore = singleScore;
    }

    public Integer getMultipleScore() {
        return multipleScore;
    }

    public void setMultipleScore(Integer multipleScore) {
        this.multipleScore = multipleScore;
    }


    public Integer getQaaScore() {
        return qaaScore;
    }

    public void setQaaScore(Integer qaaScore) {
        this.qaaScore = qaaScore;
    }

    public Integer getUpperScore() {
        return upperScore;
    }

    public void setUpperScore(Integer upperScore) {
        this.upperScore = upperScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

	@Override
	public String toString() {
		return "Score [id=" + id + ", singleSucc=" + singleSucc + ", singleSuccIds=" + singleSuccIds + ", singleErr="
				+ singleErr + ", singleErrIds=" + singleErrIds + ", multipleSucc=" + multipleSucc + ", multipleSuccIds="
				+ multipleSuccIds + ", multipleErr=" + multipleErr + ", multipleErrIds=" + multipleErrIds
				+ ", singleScore=" + singleScore + ", multipleScore=" + multipleScore + ", qaaScore=" + qaaScore
				+ ", upperScore=" + upperScore + ", score=" + score + ", status=" + status + ", studentId=" + studentId
				+ ", examId=" + examId + ", executeTime=" + executeTime + "]";
	}
    
    
}