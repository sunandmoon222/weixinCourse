package org.weixin.course.service.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.weixin.course.service.content.bean.DaletouBean;

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
	private final static String filePath = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/daletou_new.xml";
	private final static String appName = "超级大乐透"; 
	
	public static String getCaipiaoInfo() {
		
		StringBuffer buffer = new StringBuffer();
		DaletouBean bean = new DaletouBean();
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(filePath);
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		xs.fromXML(input, bean);
		
		buffer.append(appName+"(期号:"+bean.getId()+")").append("\n")
			  .append("中奖号码：").append("\n")
			  .append("红球：").append(bean.getResultNum_red()).append("\n")
			  .append("蓝球：").append(bean.getResultNum_blue()).append("\n")
			  .append("一等奖中奖人数：").append(bean.getWinningNum()).append("\n")
			  .append("一等奖中奖金额：").append(bean.getBonusAmount()).append("\n")
			  .append("二等奖中奖人数：").append(bean.getWinningNum_2()).append("\n")
			  .append("二等奖中奖金额：").append(bean.getBonusAmount_2()).append("\n");

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
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