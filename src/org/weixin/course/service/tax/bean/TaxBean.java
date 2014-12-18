package org.weixin.course.service.tax.bean;

import java.util.ArrayList;
import java.util.List;

public class TaxBean {

	private String id="";
	private String count;
	List<TaxBeanList> list = new ArrayList<TaxBeanList>();
	
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
}

