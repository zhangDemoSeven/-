package com.inter.pojo.paper;

public class SingleFlag {
    private Integer id;

    private String optionIds;

    private Integer singleId;

    private Integer examId;

    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionIds() {
        return optionIds;
    }

    public void setOptionIds(String optionIds) {
        this.optionIds = optionIds == null ? null : optionIds.trim();
    }

    public Integer getSingleId() {
        return singleId;
    }

    public void setSingleId(Integer singleId) {
        this.singleId = singleId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

	@Override
	public String toString() {
		return "SingleFlag [id=" + id + ", optionIds=" + optionIds + ", singleId=" + singleId + ", examId=" + examId
				+ ", studentId=" + studentId + "]";
	}
    
    
    
}