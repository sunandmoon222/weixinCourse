package org.weixin.course.service.content.bean;


public class SevenHappyBean extends CaipiaoBaseBean {

	//奖池金额
	private String remaindBounus = "";
	//本期销量
	private String salesTotals = "";
	//开奖号码
	private String resultNum = "";
	//开奖号码 蓝号
	private String resultNum_add = "";		
	//信息
	private String messeage = "";	
	//二等奖中奖数目
	private String winningNum_2 = "";
	//二等奖中奖金额
	private String bonusAmount_2 = "";
	
	public String getWinningNum_2() {
		return winningNum_2;
	}

	public void setWinningNum_2(String winningNum_2) {
		this.winningNum_2 = winningNum_2;
	}

	public String getBonusAmount_2() {
		return bonusAmount_2;
	}

	public void setBonusAmount_2(String bonusAmount_2) {
		this.bonusAmount_2 = bonusAmount_2;
	}

	public String getResultNum() {
		return resultNum;
	}

	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}

	public String getResultNum_add() {
		return resultNum_add;
	}

	public void setResultNum_add(String resultNum_add) {
		this.resultNum_add = resultNum_add;
	}

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
}
