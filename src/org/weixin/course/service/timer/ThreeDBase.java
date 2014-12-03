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

import org.weixin.course.service.content.bean.ThreeDBean;

import com.thoughtworks.xstream.XStream;

/**
 * 彩票查询服务
 * 
 * @author zhangtianming
 * @date 2014-12-01
 * 
 */
public class ThreeDBase {

//	private List<ThreeDBean> dataList = new ArrayList<ThreeDBean>();
////	private final String url = "http://datachart.500.com/sd/history/history.shtml";
//
//	private void makeXmlData() {
//		DateFormat format = new SimpleDateFormat(Constant.DATE_FORMAT);
//		XStream xs = new XStream();
//		String tempString  = null;
//		String[] tempArr = null;
//		try {
//			File file = new File(Constant.THREE_D_LOCAL_PATH);
//            BufferedReader reader = new BufferedReader(new FileReader(file)); 
//            while ((tempString = reader.readLine()) != null) {
//            	ThreeDBean bean = new ThreeDBean();
//            	
//            	tempArr = tempString.replaceAll("\\s+", "&").split("&");
//            	if (Integer.valueOf(tempArr[0]) > 11070) {
//	            	bean.setId("20"+tempArr[0]);
//	            	bean.setResultNum_red(tempArr[1]+ "  " +tempArr[2]+ "  "+tempArr[3]+ "  "+tempArr[4]+ "  "+tempArr[5]+ "  "+tempArr[6]);
//	            	bean.setResultNum_blue(tempArr[7]);
//	            	bean.setRemaindBounus(tempArr[8]);
//	            	bean.setWinningNum(tempArr[9]);
//	            	bean.setBonusAmount(tempArr[10]);
//	            	bean.setWinningNum_2(tempArr[11]);
//	            	bean.setBonusAmount_2(tempArr[12]);
//	            	bean.setSalesTotals(tempArr[13]);
//	        		bean.setOpenTime(tempArr[14]);
//	        		bean.setUpdateDate(format.format(new Date()));
//	        		bean.setResultNum_happy("-");
//	        		bean.setMesseage("-");
//            	} else {
//	            	bean.setId("20"+tempArr[0]);
//	            	bean.setResultNum_red(tempArr[1]+ "  " +tempArr[2]+ "  "+tempArr[3]+ "  "+tempArr[4]+ "  "+tempArr[5]+ "  "+tempArr[6]);
//	            	bean.setResultNum_blue(tempArr[7]);
//	            	bean.setResultNum_happy(tempArr[8].equals("0")?"-":tempArr[8]);
//	            	bean.setRemaindBounus(tempArr[9]);
//	            	bean.setWinningNum(tempArr[10]);
//	            	bean.setBonusAmount(tempArr[11]);
//	            	bean.setWinningNum_2(tempArr[12]);
//	            	bean.setBonusAmount_2(tempArr[13]);
//	            	bean.setSalesTotals(tempArr[14]);
//	        		bean.setOpenTime(tempArr[15]);
//	        		bean.setUpdateDate(format.format(new Date()));
//	        		bean.setMesseage("-");
//            	}
//            	
//        		dataList.add(bean);
//            }
//
//			OutputStream fs = new FileOutputStream(Constant.getShuangSeQiuPath());
//			xs.toXML(dataList, fs);
//			fs.close();
//			fs = null;
//			reader.close();
//			reader = null;
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 通过main在本地测试
//	 * 
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		ThreeDBase threeDBase = new ThreeDBase();
//		threeDBase.makeXmlData();
//		System.out.print("success~~~");
//	}
}