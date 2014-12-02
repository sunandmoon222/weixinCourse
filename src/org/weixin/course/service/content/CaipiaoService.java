package org.weixin.course.service.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.weixin.course.service.content.bean.DaletouBean;
import org.weixin.course.service.content.bean.PailiesanBean;

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

//	private final static String filePath = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\daletou_new.xml";
	private final static String daletou_filePath = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/daletou_new.xml";
	private final static String pailiesan_filePath = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/pailiesan_new.xml";
	private final static String appName_daletou = "超级大乐透";
	private final static String appName_pailiesan = "排列三"; 
	
	private static String getDaletouInfo() {
		StringBuffer buffer = new StringBuffer();
		DaletouBean bean = new DaletouBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(daletou_filePath);
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
			  .append("一等奖中奖金额：").append(bean.getBonusAmount()).append("\n");
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
		
		File file = new File(pailiesan_filePath);
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(appName_pailiesan+"(期号:"+bean.getId()+")").append("\n")
			  .append("中奖号码：").append(bean.getResultNum()).append("\n");

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
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(strDaletou).append("\n\n")
			  .append(strPaiLieSan);

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