package com.inter.vo;

public class ScoreVo {

	private Integer id;	//学生ID
	
	private String questiontypesIds; //试卷中试题的类型
	
	private String studentName;
	private String className;
	private String examName;
	private Integer singleNumber; //学生答对的单选题数量
	private Integer multipleNumber;//学生答对的多选题数量
	private Integer qaaScore;	//当前问答题成绩
	private Integer upperScore;	//当前上机题成绩
	private Integer score; //当前学生成绩
	private String qaaIds;	//该试卷的问答题id组
	private String upperIds; //该试卷的上机题id组
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getQuestiontypesIds() {
		return questiontypesIds;
	}
	public void setQuestiontypesIds(String questiontypesIds) {
		this.questiontypesIds = questiontypesIds;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Integer getSingleNumber() {
		return singleNumber;
	}
	public void setSingleNumber(Integer singleNumber) {
		this.singleNumber = singleNumber;
	}
	public Integer getMultipleNumber() {
		return multipleNumber;
	}
	public void setMultipleNumber(Integer multipleNumber) {
		this.multipleNumber = multipleNumber;
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
	public String getQaaIds() {
		return qaaIds;
	}
	public void setQaaIds(String qaaIds) {
		this.qaaIds = qaaIds;
	}
	public String getUpperIds() {
		return upperIds;
	}
	public void setUpperIds(String upperIds) {
		this.upperIds = upperIds;
	}
	
	
	
}
