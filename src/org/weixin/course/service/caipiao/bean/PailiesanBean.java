package org.weixin.course.service.caipiao.bean;


public class PailiesanBean extends CaipiaoBaseBean {

	//开奖号码 
	private String resultNum = "";
	//组三中奖数目
	private String winningNum_Three = "";
	//组三中奖金额
	private String bonusAmount_Three = "";
	//组六中奖数目
	private String winningNum_Six = "";
	//组六中奖金额
	private String bonusAmount_Six = "";
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
	/**
	 * @return the winningNum_Three
	 */
	public String getWinningNum_Three() {
		return winningNum_Three;
	}
	/**
	 * @param winningNum_Three the winningNum_Three to set
	 */
	public void setWinningNum_Three(String winningNum_Three) {
		this.winningNum_Three = winningNum_Three;
	}
	/**
	 * @return the bonusAmount_Three
	 */
	public String getBonusAmount_Three() {
		return bonusAmount_Three;
	}
	/**
	 * @param bonusAmount_Three the bonusAmount_Three to set
	 */
	public void setBonusAmount_Three(String bonusAmount_Three) {
		this.bonusAmount_Three = bonusAmount_Three;
	}
	/**
	 * @return the winningNum_Six
	 */
	public String getWinningNum_Six() {
		return winningNum_Six;
	}
	/**
	 * @param winningNum_Six the winningNum_Six to set
	 */
	public void setWinningNum_Six(String winningNum_Six) {
		this.winningNum_Six = winningNum_Six;
	}
	/**
	 * @return the bonusAmount_Six
	 */
	public String getBonusAmount_Six() {
		return bonusAmount_Six;
	}
	/**
	 * @param bonusAmount_Six the bonusAmount_Six to set
	 */
	public void setBonusAmount_Six(String bonusAmount_Six) {
		this.bonusAmount_Six = bonusAmount_Six;
	}
	
}
