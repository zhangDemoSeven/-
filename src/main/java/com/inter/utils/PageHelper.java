package com.inter.utils;

import java.util.ArrayList;
import java.util.List;

public class PageHelper<T> {

	private Integer total;
	private List<T> rows = new ArrayList<T>();
	
	public PageHelper(Integer total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}
	public PageHelper() {
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
