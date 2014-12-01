package org.weixin.course.service.content.bean;

public class CaipiaoBaseBean {

	//期数
	private String id = "";
	//中奖数目
	private String winningNum = "";
	//中奖金额
	private String bonusAmount = "";
	//开奖日期
	private String openTime = "";
	//更新日期
	private String updateDate = "";
	
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWinningNum() {
		return winningNum;
	}

	public void setWinningNum(String winningNum) {
		this.winningNum = winningNum;
	}

	public String getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(String bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
}