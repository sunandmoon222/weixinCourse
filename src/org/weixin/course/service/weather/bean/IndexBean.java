package org.weixin.course.service.weather.bean;

public class IndexBean {

	//指数简称
	private String name_en = "";
	//指数中文名称
	private String name_cn = "";
	//指数中文别名
	private String name_alias = "";
	//内容
	private String content = "";
	//指数级别
	private String level = "";
	
	/**
	 * @return the name_alias
	 */
	public String getName_alias() {
		return name_alias;
	}
	/**
	 * @param name_alias the name_alias to set
	 */
	public void setName_alias(String name_alias) {
		this.name_alias = name_alias;
	}
	/**
	 * @return the name_en
	 */
	public String getName_en() {
		return name_en;
	}
	/**
	 * @param name_en the name_en to set
	 */
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	/**
	 * @return the name_cn
	 */
	public String getName_cn() {
		return name_cn;
	}
	/**
	 * @param name_cn the name_cn to set
	 */
	public void setName_cn(String name_cn) {
		this.name_cn = name_cn;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
}
