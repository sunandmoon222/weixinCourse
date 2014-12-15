package org.weixin.course.service.caipiao.bean;

public class CaipiaoBaseBean {

	private String id = "";
	private String resultNum = "";
	private String openTime = "";
	private String updateDate = "";
	private String remaindBounus = "";
	private String resultNumBlue = "";
	private String resultNumSpecial = "";
	
	private String winningNum = "";
	private String bonusAmount = "";

	public String getResultNumBlue() {
		return resultNumBlue;
	}

	public void setResultNumBlue(String resultNumBlue) {
		this.resultNumBlue = resultNumBlue;
	}

	public String getResultNumSpecial() {
		return resultNumSpecial;
	}

	public void setResultNumSpecial(String resultNumSpecial) {
		this.resultNumSpecial = resultNumSpecial;
	}

	public String getResultNum() {
		return this.resultNum;
	}

	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}

	public String getRemaindBounus() {
		return this.remaindBounus;
	}

	public void setRemaindBounus(String remaindBounus) {
		this.remaindBounus = remaindBounus;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWinningNum() {
		return this.winningNum;
	}

	public void setWinningNum(String winningNum) {
		this.winningNum = winningNum;
	}

	public String getBonusAmount() {
		return this.bonusAmount;
	}

	public void setBonusAmount(String bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public String getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
}