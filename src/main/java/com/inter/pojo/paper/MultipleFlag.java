package com.inter.pojo.paper;

public class MultipleFlag {
    private Integer id;

    private String optionIds;

    private Integer multipleId;

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

    public Integer getMultipleId() {
        return multipleId;
    }

    public void setMultipleId(Integer multipleId) {
        this.multipleId = multipleId;
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
}