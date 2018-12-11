package com.inter.vo;

import java.util.ArrayList;
import java.util.List;

import com.inter.pojo.dictionaries.Source;


public class SourceVo {

	private String parentName;
	
	private List<Source> childSourceList = new ArrayList<>();

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<Source> getChildSourceList() {
		return childSourceList;
	}

	public void setChildSourceList(List<Source> childSourceList) {
		this.childSourceList = childSourceList;
	}
}
