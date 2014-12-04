package org.weixin.course.service.caipiao.bean;


public class ThreeDBean extends CaipiaoBaseBean {

	//开奖号码 
	private String resultNum = "";
//	//组三中奖数目
//	private String winningNum_Three = "";
//	//组三中奖金额
//	private String bonusAmount_Three = "";
//	//组六中奖数目
//	private String winningNum_Six = "";
//	//组六中奖金额
//	private String bonusAmount_Six = "";
	/**
	 * @return the resultNum
	 */
	public String getResultNum() {
		return resultNum;
	}
	/**
	 * @param resultNum the resultNum to set
	 */
	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}
}
