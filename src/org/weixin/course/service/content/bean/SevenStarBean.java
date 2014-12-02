package org.weixin.course.service.content.bean;


public class SevenStarBean extends CaipiaoBaseBean {

	//二等奖中奖数目
	private String winningNum_2 = "";
	//二等奖中奖金额
	private String bonusAmount_2 = "";
	//三等奖中奖数目
	private String winningNum_3 = "";
	//三等奖中奖金额
	private String bonusAmount_3 = "";
	//开奖号码
	private String resultNum = "";
	
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
	public String getWinningNum_3() {
		return winningNum_3;
	}
	public void setWinningNum_3(String winningNum_3) {
		this.winningNum_3 = winningNum_3;
	}
	public String getBonusAmount_3() {
		return bonusAmount_3;
	}
	public void setBonusAmount_3(String bonusAmount_3) {
		this.bonusAmount_3 = bonusAmount_3;
	}
	public String getResultNum() {
		return resultNum;
	}
	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}
}
