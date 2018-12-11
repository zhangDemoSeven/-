package com.inter.vo;

/**
 * 
* @ClassName: QuestionAnalysisVo 
* @Description: 
* 			接收试卷解析的数据的VO类
* @author 石家庄北大青鸟Y2教员 韩志彬
* @date 2018年12月5日 上午10:16:21
 */
public class QuestionAnalysisVo {

	/** 单选题或多选题的ID*/
	private String entityId;
	
	/** 这道题的错误人数*/
	private Integer count;

	
	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
