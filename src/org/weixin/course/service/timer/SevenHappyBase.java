package org.weixin.course.service.timer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.weixin.course.service.content.bean.SevenHappyBean;

import com.thoughtworks.xstream.XStream;

/**
 * 彩票查询服务
 * 
 * @author zhangtianming
 * @date 2014-12-01
 * 
 */
public class SevenHappyBase {

	private List<SevenHappyBean> dataList = new ArrayList<SevenHappyBean>();
//	private final String url = "http://datachart.500.com/qlc/history/history.shtml";

	private void makeXmlData() {
		DateFormat format = new SimpleDateFormat(Constant.DATE_FORMAT);
		XStream xs = new XStream();
		String tempString  = null;
		String[] tempArr = null;
		try {
			File file = new File(Constant.SEVEN_HAPPY_LOCAL_PATH);
            BufferedReader reader = new BufferedReader(new FileReader(file)); 
            while ((tempString = reader.readLine()) != null) {
            	SevenHappyBean bean = new SevenHappyBean();
            	
            	tempArr = tempString.replaceAll("\\s+", "&").split("&");
	            	bean.setId("20"+tempArr[0]);
	            	bean.setResultNum(tempArr[1]+ "  " +tempArr[2]+ "  "+tempArr[3]+ "  "+tempArr[4]+ "  "+tempArr[5]+ "  "+tempArr[6]+"  "+tempArr[7]);
	            	bean.setResultNum_add(tempArr[8]);
	            	bean.setSalesTotals(tempArr[10]);
	            	bean.setRemaindBounus(tempArr[11]);
	            	bean.setOpenTime(tempArr[12]);
	            	bean.setWinningNum("");
	            	bean.setBonusAmount("");
	            	bean.setWinningNum_2("");
	            	bean.setBonusAmount_2("");

	        		bean.setUpdateDate(format.format(new Date()));
	        		bean.setMesseage("");
            	
        		dataList.add(bean);
            }

			OutputStream fs = new FileOutputStream(Constant.getSevenHappyPath());
			xs.toXML(dataList, fs);
			fs.close();
			fs = null;
			reader.close();
			reader = null;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过main在本地测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SevenHappyBase sevenHappyBase = new SevenHappyBase();
		sevenHappyBase.makeXmlData();
		System.out.print("success~~~");
	}
}