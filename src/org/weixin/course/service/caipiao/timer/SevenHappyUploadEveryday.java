package org.weixin.course.service.caipiao.timer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.weixin.course.service.caipiao.bean.CaipiaoBaseBean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 彩票查询服务
 * 
 * @author zhangtianming
 * @date 2014-12-01
 * 
 */
public class SevenHappyUploadEveryday {

	private CaipiaoBaseBean bean = new CaipiaoBaseBean();
	
	/**
	 * 发起http get请求获取网页源代码
	 * 
	 * @param requestUrl
	 * @return
	 */
	private String httpRequest(String requestUrl) {
		StringBuffer buffer = null;

		try {
			// 建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");

			// 获取输入流
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			// 读取返回结果
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			httpUrlConn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * 从html中抽取出彩票数据
	 * 
	 * @param html
	 * @return
	 */
	private void extract(String html) {
		DateFormat format = new SimpleDateFormat(ConstantCaipiao.DATE_FORMAT);
		
		NumberFormat nf = new DecimalFormat("$,###");
		
		Pattern p = Pattern.compile(".*福利彩票.*七乐彩(.*)期.*([0-9]{4}-[0-9]{2}-[0-9]{2})(.*)奖金计算(.*)一 三 五.*");
		Matcher m = p.matcher(html);
		String temp1 = "";
		String temp2 = "";
		String temp3 = "";
		String temp4 = "";
		while (m.find()){
			temp1 = m.group(1);
			temp2 = m.group(2);
			temp3 = m.group(3);
			temp4 = m.group(4);
		}
		
		temp1 = temp1.replaceAll("<.*>", "").replaceAll("\\s", "");
		temp2 = temp2.replaceAll("\\s", "");
		temp3 = temp3.replaceAll("<.*ballbg\">", "")
					 .replaceAll("<a.*>", "")
					 .replaceAll("\\s", "");
		temp3 = temp3.replace("<spanclass=\"ball_1\">", "").replace("<spanclass=\"ball_2\">", "");
		String[] arr = temp3.split("</span>");

		temp4 = temp4.replaceAll("<.*￥", "").replaceAll("<.*>", "").replaceAll("\\s", "");
		
		this.bean.setId(temp1);
		this.bean.setResultNum(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5]+ " " + arr[6]);
		this.bean.setResultNumBlue(arr[7]);
		this.bean.setOpenTime(temp2);
		this.bean.setUpdateDate(format.format(new Date()));
		if (temp4 != null && !"".equals(temp4) && !"0".equals(temp4)) {			
			this.bean.setRemaindBounus(nf.format(Long.valueOf(temp4)).replace("$", ""));
		}

//		String strTemp1 = null;
//		String strTemp2 = null;
//		String strTemp3 = null;
//		String strTemp4 = null;
//		String strTemp5 = null;
//
//		Pattern p = Pattern.compile(".*<li class=\"caizhong\">(.+元</span>)</li>\\s+<li class=\"haoma3\">(.+</span>)"
//									+ "</li>\\s+</ul>.*一等奖</td>(.*)二等奖</td>(.*)三等奖</td>.*"
//									+ "<div class=\"mt10\">(.*)<div  class=\"page_box clearself mt10\">.*");
//		Matcher m = p.matcher(html);
//		while (m.find()) {
//			strTemp1 = m.group(1);
//			strTemp2 = m.group(2);
//			strTemp3 = m.group(3);
//			strTemp4 = m.group(4);
//			strTemp5 = m.group(5);
//		}
//		
//		String[] arrTemp1 = strTemp1.replace("<span>", "").replaceAll("</?i>", "").split("</span>");
//		String[] arrTemp2 = strTemp2.replaceAll("<i.*i>", "").replace("<span>", "").replace("<span class=\"blue\">", "").split("</span>");
//		String[] arrTemp3 = strTemp3.replaceAll("</tr.*>", "").replace("<td>", "").replaceAll("\\s*", "").split("</td>");
//		String[] arrTemp4 = strTemp4.replaceAll("</tr.*>", "").replace("<td>", "").replaceAll("\\s*", "").split("</td>");
//		strTemp5 = strTemp5.replace("<br>", "").replaceAll("</?.+>", "").replaceAll("\\s*", "");
//		
//    	bean.setId(arrTemp1[0].substring(1, arrTemp1[0].length()-1));
//    	bean.setOpenTime(arrTemp1[1].replaceAll("\\s*", "").replaceAll(".*：", ""));
//    	bean.setSalesTotals(arrTemp1[2].replaceAll("\\s*", "").replaceAll(".*：", ""));
//    	bean.setRemaindBounus(arrTemp1[3].replaceAll("\\s*", "").replaceAll(".*：", ""));
//    	bean.setResultNum(arrTemp2[0]+ "  " +arrTemp2[1]+ "  "+arrTemp2[2]+ "  "+arrTemp2[3]+ "  "+arrTemp2[4]+ "  "+arrTemp2[5]+ "  "+arrTemp2[6]);
//    	bean.setResultNum_add(arrTemp2[7]);
//    	
//    	bean.setWinningNum(arrTemp3[0]);
//    	bean.setBonusAmount(arrTemp3[1]);
//    	bean.setWinningNum_2(arrTemp4[0]);
//    	bean.setBonusAmount_2(arrTemp4[1]);
//		bean.setUpdateDate(format.format(new Date()));
//		bean.setMesseage(strTemp5);
	}

	private void makeXmlData() {

		XStream xs = new XStream();
		XStream xsBase = new XStream(new DomDriver());
		// Write to a file in the file system
		try {
			OutputStream fs1 = new FileOutputStream(ConstantCaipiao.getSevenHappyPath_New());
			xs.toXML(bean, fs1);

			File file = new File(ConstantCaipiao.getSevenHappyPath());
			FileInputStream input = new FileInputStream(file);
			@SuppressWarnings("unchecked")
			ArrayList<CaipiaoBaseBean> list = (ArrayList<CaipiaoBaseBean>)xsBase.fromXML(input);
			if (list.get(0).getOpenTime().equals(bean.getOpenTime())) {
				list.remove(0);
			} else {
				list.remove(9);
			}
			list.add(0, bean);

			OutputStream fs = new FileOutputStream(file);
			
			xsBase.toXML(list, fs);
			
			fs1.close();
			fs.close();
			fs1 = null;
			fs = null;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private String getUrlParamter() {
//		String str = null;
//		// 获取网页源代码
//		String html = httpRequest(ConstantCaipiao.SEVEN_HAPPY_URL);
//		
//		Pattern p = Pattern.compile(".*(kjxx/qlc/kjgg/[0-9]{6}.shtml).*");
//		Matcher m = p.matcher(html);
//		while (m.find()) {
//			str = m.group(1);
//		}
//		return str;
//	}
	
	/**
	 * 彩票查询方法，供外部调用
	 * 
	 * @return
	 */
	public void makeCaipiaoInfo() {
		
//		String urlParamter = getUrlParamter();
		// 获取网页源代码
//		String html = httpRequest(ConstantCaipiao.SEVEN_HAPPY_URL+"/"+urlParamter);
		String html = httpRequest(ConstantCaipiao.SEVEN_HAPPY_URL);
		// 从网页中抽取信息
		extract(html);
			
		makeXmlData();
	}
	
	/**
	 * 通过main在本地测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SevenHappyUploadEveryday sevenHappyUploadEveryday = new SevenHappyUploadEveryday();
		sevenHappyUploadEveryday.makeCaipiaoInfo();
		System.out.print("SevenHappy upload success~~~");
	}
}