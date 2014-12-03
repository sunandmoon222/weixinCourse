package org.weixin.course.service.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.weixin.course.service.content.bean.DaletouBean;
import org.weixin.course.service.content.bean.PailieFiveBean;
import org.weixin.course.service.content.bean.PailiesanBean;
import org.weixin.course.service.content.bean.SevenStarBean;
import org.weixin.course.service.content.bean.ShuangSeQiuBean;
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

	private final static String appName_daletou = "超级大乐透";
	private final static String appName_pailiesan = "排列三"; 
	private final static String appName_pailiefive = "排列五"; 
	private final static String appName_sevenstar = "七星彩";
	private final static String appName_shuangseqiu = "双色球";
	
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
		
		buffer.append(appName_daletou+"(期号:"+bean.getId()+")").append("\n")
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
		
		buffer.append(appName_pailiesan+"(期号:"+bean.getId()+")").append("\n")
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
		
		buffer.append(appName_pailiefive+"(期号:"+bean.getId()+")").append("\n")
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
		
		buffer.append(appName_sevenstar+"(期号:"+bean.getId()+")").append("\n")
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
		
		buffer.append(appName_shuangseqiu+"(期号:"+bean.getId()+")").append("\n")
			  .append("中奖号码：").append("\n")
			  .append(" 红球："+bean.getResultNum_red()).append("\n")
			  .append(" 蓝球："+bean.getResultNum_blue()).append("\n")
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
	
	public static String getCaipiaoInfo() {
		
		String strDaletou = getDaletouInfo();
		String strPaiLieSan = getPaiLieSanInfo();
		String strPaiLieFive = getPaiLieFiveInfo();
		String strSevenStar = getSevenStarInfo();
		String strShuangSeQiu = getShuangSeQiuInfo();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(strDaletou).append("\n\n")
			  .append(strPaiLieSan).append("\n\n")
			  .append(strPaiLieFive).append("\n\n")
			  .append(strSevenStar).append("\n\n")
			  .append(strShuangSeQiu);

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