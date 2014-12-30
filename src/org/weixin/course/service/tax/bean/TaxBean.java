package org.weixin.course.service.tax.bean;

import java.util.ArrayList;
import java.util.List;

public class TaxBean {

	private String year="";
	private String month="";
	private String id="";
	private String count;
	private String bound="";
	List<TaxBeanList> list = new ArrayList<TaxBeanList>();
	
	public String getBound() {
		return bound;
	}
	public void setBound(String bound) {
		this.bound = bound;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<TaxBeanList> getList() {
		return list;
	}
	public void setList(List<TaxBeanList> list) {
		this.list = list;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}

