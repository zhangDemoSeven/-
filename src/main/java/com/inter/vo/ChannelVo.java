package com.inter.vo;

import java.util.ArrayList;
import java.util.List;

import com.inter.pojo.dictionaries.Channel;


public class ChannelVo {

	private String parentName;
	
	private List<Channel> childChannelList = new ArrayList<>();

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<Channel> getChildChannelList() {
		return childChannelList;
	}

	public void setChildChannelList(List<Channel> childChannelList) {
		this.childChannelList = childChannelList;
	}
}
