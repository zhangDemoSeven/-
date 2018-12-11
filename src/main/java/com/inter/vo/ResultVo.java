package com.inter.vo;

public class ResultVo {

	//single-multiple
	private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String analysis;
    
    //quesandans
    private String quesandansTitle;
    private String quesandansAnswer;
    private String quesandansAnalysis;
    private String quesandansStudentAnswer;
    
    
    //upper 
    private String upperTitle;
    private String upperUrl;
    private String upperAnalysis;
    
    
    //是否选中
    private Boolean isA;
  	private Boolean isB;
  	private Boolean isC;
  	private Boolean isD;
  	
  	//是否答对
  	private Boolean OK;

    //score
  	private Integer score; //总成绩
    private Integer singleSucc;//单选题对题数量
    private Integer singleErr;//单选题错题数量
  	private Integer singleTotalScore; //单选题总得分
    
  	private Integer multipleSucc;	//多选题对题数量
  	private Integer multipleErr;	//多选题错题数量
  	private Integer multipleTotalScore; //多选题总分
  	
  	private Integer quesandansTotalScore; //问答题总分
  	
  	private Integer upperTotalScore; //上机题总分
  	
  	
  	
	public String getUpperTitle() {
		return upperTitle;
	}

	public void setUpperTitle(String upperTitle) {
		this.upperTitle = upperTitle;
	}

	public String getUpperUrl() {
		return upperUrl;
	}

	public void setUpperUrl(String upperUrl) {
		this.upperUrl = upperUrl;
	}

	public String getUpperAnalysis() {
		return upperAnalysis;
	}

	public void setUpperAnalysis(String upperAnalysis) {
		this.upperAnalysis = upperAnalysis;
	}

	public String getQuesandansStudentAnswer() {
		return quesandansStudentAnswer;
	}

	public void setQuesandansStudentAnswer(String quesandansStudentAnswer) {
		this.quesandansStudentAnswer = quesandansStudentAnswer;
	}

	public String getQuesandansTitle() {
		return quesandansTitle;
	}

	public void setQuesandansTitle(String quesandansTitle) {
		this.quesandansTitle = quesandansTitle;
	}

	public String getQuesandansAnswer() {
		return quesandansAnswer;
	}

	public void setQuesandansAnswer(String quesandansAnswer) {
		this.quesandansAnswer = quesandansAnswer;
	}

	public String getQuesandansAnalysis() {
		return quesandansAnalysis;
	}

	public void setQuesandansAnalysis(String quesandansAnalysis) {
		this.quesandansAnalysis = quesandansAnalysis;
	}

	public Integer getSingleSucc() {
		return singleSucc;
	}

	public void setSingleSucc(Integer singleSucc) {
		this.singleSucc = singleSucc;
	}

	public Integer getSingleErr() {
		return singleErr;
	}

	public void setSingleErr(Integer singleErr) {
		this.singleErr = singleErr;
	}

	public Integer getSingleTotalScore() {
		return singleTotalScore;
	}

	public void setSingleTotalScore(Integer singleTotalScore) {
		this.singleTotalScore = singleTotalScore;
	}

	public Integer getMultipleSucc() {
		return multipleSucc;
	}

	public void setMultipleSucc(Integer multipleSucc) {
		this.multipleSucc = multipleSucc;
	}

	public Integer getMultipleErr() {
		return multipleErr;
	}

	public void setMultipleErr(Integer multipleErr) {
		this.multipleErr = multipleErr;
	}

	public Integer getMultipleTotalScore() {
		return multipleTotalScore;
	}

	public void setMultipleTotalScore(Integer multipleTotalScore) {
		this.multipleTotalScore = multipleTotalScore;
	}

	public Integer getQuesandansTotalScore() {
		return quesandansTotalScore;
	}

	public void setQuesandansTotalScore(Integer quesandansTotalScore) {
		this.quesandansTotalScore = quesandansTotalScore;
	}

	public Integer getUpperTotalScore() {
		return upperTotalScore;
	}

	public void setUpperTotalScore(Integer upperTotalScore) {
		this.upperTotalScore = upperTotalScore;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	

	public Boolean getIsA() {
		return isA;
	}

	public void setIsA(Boolean isA) {
		this.isA = isA;
	}

	public Boolean getIsB() {
		return isB;
	}

	public void setIsB(Boolean isB) {
		this.isB = isB;
	}

	public Boolean getIsC() {
		return isC;
	}

	public void setIsC(Boolean isC) {
		this.isC = isC;
	}

	public Boolean getIsD() {
		return isD;
	}

	public void setIsD(Boolean isD) {
		this.isD = isD;
	}

	public Boolean getOK() {
		return OK;
	}

	public void setOK(Boolean oK) {
		OK = oK;
	}

	@Override
	public String toString() {
		return "ResultVo [title=" + title + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", answer=" + answer + ", analysis=" + analysis + ", quesandansTitle="
				+ quesandansTitle + ", quesandansAnswer=" + quesandansAnswer + ", quesandansAnalysis="
				+ quesandansAnalysis + ", quesandansStudentAnswer=" + quesandansStudentAnswer + ", isA=" + isA
				+ ", isB=" + isB + ", isC=" + isC + ", isD=" + isD + ", OK=" + OK + ", score=" + score + ", singleSucc="
				+ singleSucc + ", singleErr=" + singleErr + ", singleTotalScore=" + singleTotalScore + ", multipleSucc="
				+ multipleSucc + ", multipleErr=" + multipleErr + ", multipleTotalScore=" + multipleTotalScore
				+ ", quesandansTotalScore=" + quesandansTotalScore + ", upperTotalScore=" + upperTotalScore + "]";
	}
	
}
