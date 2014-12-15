package org.weixin.course.service.caipiao.bean;

public class CaipiaoBaseBean {

	private String id = "";
	private String resultNum = "";
	private String openTime = "";
	private String updateDate = "";
	private String remaindBounus = "";
	private String resultNum_blue = "";
	private String resultNum_special = "";
	
	private String winningNum = "";
	private String bonusAmount = "";

	
	
	public String getResultNum_blue() {
		return resultNum_blue;
	}

	public void setResultNum_blue(String resultNum_blue) {
		this.resultNum_blue = resultNum_blue;
	}

	public String getResultNum_special() {
		return resultNum_special;
	}

	public void setResultNum_special(String resultNum_special) {
		this.resultNum_special = resultNum_special;
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