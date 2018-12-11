package com.inter.pojo.paper;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class QaaFlag {
    private Integer id;

    private Integer examId;

    private Integer studentId;

    private String qaaAnswer;

    private Integer qaaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getQaaAnswer() {
        return qaaAnswer;
    }

    public void setQaaAnswer(String qaaAnswer) {
        this.qaaAnswer = qaaAnswer == null ? null : qaaAnswer.trim();
    }

    public Integer getQaaId() {
        return qaaId;
    }

    public void setQaaId(Integer qaaId) {
        this.qaaId = qaaId;
    }
}