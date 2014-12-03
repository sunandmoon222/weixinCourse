package org.weixin.course.service.content.bean;


public class ShuangSeQiuBean extends CaipiaoBaseBean {

	//二等奖中奖数目
	private String winningNum_2 = "";
	//二等奖中奖金额
	private String bonusAmount_2 = "";
	//奖池金额
	private String remaindBounus = "";
	//本期销量
	private String salesTotals = "";
	//开奖号码 红号
	private String resultNum_red = "";
	//开奖号码 蓝号
	private String resultNum_blue = "";	
	//快乐星期天
	private String resultNum_happy = "";	
	//信息
	private String messeage = "";	
	/**
	 * @return the messeage
	 */
	public String getMesseage() {
		return messeage;
	}

	/**
	 * @param messeage the messeage to set
	 */
	public void setMesseage(String messeage) {
		this.messeage = messeage;
	}

	/**
	 * @return the remaindBounus
	 */
	public String getRemaindBounus() {
		return remaindBounus;
	}

	/**
	 * @param remaindBounus the remaindBounus to set
	 */
	public void setRemaindBounus(String remaindBounus) {
		this.remaindBounus = remaindBounus;
	}

	/**
	 * @return the salesTotals
	 */
	public String getSalesTotals() {
		return salesTotals;
	}

	/**
	 * @param salesTotals the salesTotals to set
	 */
	public void setSalesTotals(String salesTotals) {
		this.salesTotals = salesTotals;
	}
	/**
	 * @return the resultNum_happy
	 */
	public String getResultNum_happy() {
		return resultNum_happy;
	}

	/**
	 * @param resultNum_happy the resultNum_happy to set
	 */
	public void setResultNum_happy(String resultNum_happy) {
		this.resultNum_happy = resultNum_happy;
	}

	/**
	 * @return the resultNum_red
	 */
	public String getResultNum_red() {
		return resultNum_red;
	}

	/**
	 * @param resultNum_red the resultNum_red to set
	 */
	public void setResultNum_red(String resultNum_red) {
		this.resultNum_red = resultNum_red;
	}

	/**
	 * @return the resultNum_blue
	 */
	public String getResultNum_blue() {
		return resultNum_blue;
	}

	/**
	 * @param resultNum_blue the resultNum_blue to set
	 */
	public void setResultNum_blue(String resultNum_blue) {
		this.resultNum_blue = resultNum_blue;
	}

	/**
	 * @return the winningNum_2
	 */
	public String getWinningNum_2() {
		return winningNum_2;
	}

	/**
	 * @param winningNum_2 the winningNum_2 to set
	 */
	public void setWinningNum_2(String winningNum_2) {
		this.winningNum_2 = winningNum_2;
	}

	/**
	 * @return the bonusAmount_2
	 */
	public String getBonusAmount_2() {
		return bonusAmount_2;
	}

	/**
	 * @param bonusAmount_2 the bonusAmount_2 to set
	 */
	public void setBonusAmount_2(String bonusAmount_2) {
		this.bonusAmount_2 = bonusAmount_2;
	}
}
