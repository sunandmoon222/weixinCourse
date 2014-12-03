package org.weixin.course.service.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.weixin.course.service.content.bean.DaletouBean;
import org.weixin.course.service.content.bean.PailieFiveBean;
import org.weixin.course.service.content.bean.PailiesanBean;
import org.weixin.course.service.content.bean.SevenHappyBean;
import org.weixin.course.service.content.bean.SevenStarBean;
import org.weixin.course.service.content.bean.ShuangSeQiuBean;
import org.weixin.course.service.content.bean.ThreeDBean;
import org.weixin.course.service.timer.Constant;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 彩票查询服务
 * 
 * @author zhangtianming
 * @date 2014-12-01
 * 
 */
public class CaipiaoService {
	
	private static String getDaletouInfo() {
		StringBuffer buffer = new StringBuffer();
		DaletouBean bean = new DaletouBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(Constant.getDaLeTouPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(Constant.CAIPIAO_NAME_DALETOU).append("\n")
			  .append("期号:"+bean.getId()).append("\n")
		  	  .append("开奖日期：").append(bean.getOpenTime()).append("\n")
			  .append("中奖号码：").append("\n")
			  .append("红球：").append(bean.getResultNum_red()).append("\n")
			  .append("蓝球：").append(bean.getResultNum_blue()).append("\n")
			  .append("一等奖中奖人数：").append(bean.getWinningNum()).append("\n")
			  .append("一等奖中奖金额：").append(bean.getBonusAmount());
//			  .append("二等奖中奖人数：").append(bean.getWinningNum_2()).append("\n")
//			  .append("二等奖中奖金额：").append(bean.getBonusAmount_2()).append("\n");

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}
	
	private static String getPaiLieSanInfo() {
		StringBuffer buffer = new StringBuffer();
		PailiesanBean bean = new PailiesanBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(Constant.getPaiLieSanPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(Constant.CAIPIAO_NAME_PAILIESAN).append("\n")
			  .append("期号:"+bean.getId()).append("\n")
		  	  .append("开奖日期：").append(bean.getOpenTime()).append("\n")
			  .append("中奖号码：").append(bean.getResultNum());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}
	
	private static String getPaiLieFiveInfo() {
		StringBuffer buffer = new StringBuffer();
		PailieFiveBean bean = new PailieFiveBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(Constant.getPaiLieFivePath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(Constant.CAIPIAO_NAME_PAILIEFIVE).append("\n")
			  .append("期号:"+bean.getId()).append("\n")
			  .append("开奖日期：").append(bean.getOpenTime()).append("\n")
			  .append("中奖号码：").append(bean.getResultNum());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}
	
	private static String getSevenStarInfo() {
		StringBuffer buffer = new StringBuffer();
		SevenStarBean bean = new SevenStarBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(Constant.getSevenStarPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(Constant.CAIPIAO_NAME_SEVENSTAR).append("\n")
			  .append("期号:"+bean.getId()).append("\n")
			  .append("开奖日期：").append(bean.getOpenTime()).append("\n")
			  .append("中奖号码：").append(bean.getResultNum());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}
	
	private static String getShuangSeQiuInfo() {
		StringBuffer buffer = new StringBuffer();
		ShuangSeQiuBean bean = new ShuangSeQiuBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(Constant.getShuangSeQiuPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(Constant.CAIPIAO_NAME_SHUANGSEQIU).append("\n")
			  .append("期号:"+bean.getId()).append("\n")
		  	  .append("开奖日期：").append(bean.getOpenTime()).append("\n")
			  .append("中奖号码：").append("\n")
			  .append(" 红球："+bean.getResultNum_red()).append("\n")
			  .append(" 蓝球："+bean.getResultNum_blue()).append("\n")
			  .append("一等奖中奖人数：").append(bean.getWinningNum()).append("\n")
			  .append("一等奖中奖金额：").append(bean.getBonusAmount()).append("\n\n")
			  .append("二等奖中奖人数：").append(bean.getWinningNum_2()).append("\n")
			  .append("二等奖中奖金额：").append(bean.getBonusAmount_2()).append("\n\n")
			  .append(bean.getMesseage()).append("\n\n");

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}
	
	private static String getSevenHappyInfo() {
		StringBuffer buffer = new StringBuffer();
		SevenHappyBean bean = new SevenHappyBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(Constant.getSevenHappyPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(Constant.CAIPIAO_NAME_SEVEN_HAPPY).append("\n")
			  .append("期号:"+bean.getId()).append("\n")
		  	  .append("开奖日期：").append(bean.getOpenTime()).append("\n")
			  .append("基本号码："+bean.getResultNum()).append("\n")
			  .append("特别号码："+bean.getResultNum_add()).append("\n")
			  .append("一等奖中奖人数：").append(bean.getWinningNum()).append("\n")
			  .append("一等奖中奖金额：").append(bean.getBonusAmount()).append("\n\n")
			  .append("二等奖中奖人数：").append(bean.getWinningNum_2()).append("\n")
			  .append("二等奖中奖金额：").append(bean.getBonusAmount_2()).append("\n\n")
			  .append(bean.getMesseage());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}
	
	private static String getThreeDInfo() {
		StringBuffer buffer = new StringBuffer();
		ThreeDBean bean = new ThreeDBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(Constant.getThreeDPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(Constant.CAIPIAO_NAME_THREE_D).append("\n")
			  .append("期号:"+bean.getId()).append("\n")
		  	  .append("开奖日期：").append(bean.getOpenTime()).append("\n")
			  .append("中奖号码：").append(bean.getResultNum()).append("\n\n");

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}
	
	public static String getFuLiCaipiaoInfo() {

		String strThreeD = getThreeDInfo();
		String strShuangSeQiu = getShuangSeQiuInfo();
		String strSevenHappy = getSevenHappyInfo();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(strThreeD)
			  .append(strShuangSeQiu)
			  .append(strSevenHappy);

		return buffer.toString();
	}
	
	public static String getSportsCaipiaoInfo() {
		
		String strDaletou = getDaletouInfo();
		String strPaiLieSan = getPaiLieSanInfo();
		String strPaiLieFive = getPaiLieFiveInfo();
		String strSevenStar = getSevenStarInfo();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(strDaletou).append("\n\n")
			  .append(strPaiLieSan).append("\n\n")
			  .append(strPaiLieFive).append("\n\n")
			  .append(strSevenStar);

		return buffer.toString();
	}
	
	/**
	 * 通过main在本地测试
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		getTodayDate();
//		System.out.print("success~~~");
//	}

}