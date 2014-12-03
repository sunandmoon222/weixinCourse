package org.weixin.course.service.timer;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class PaiLieSanUploadEveryday {

	private PailiesanBean bean = new PailiesanBean();
	
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

		DateFormat format = new SimpleDateFormat(Constant.DATE_FORMAT);
		
		String strTemp = null;
		Pattern p = Pattern.compile("(.*)(奖金</TD>\\s+</TR>)(.*)</TABLE>\\s+</TD>.*");
		Matcher m = p.matcher(html);
		while (m.find()) {
			strTemp = m.group(3);
		}
		String[] data = strTemp.split("</TR>");
		
		String dataTemp = data[0].replace("    ", "")
								 .replace(",", "")
								 .replaceAll("</?[^>]+>", "#").replaceAll("#+", "#")
								 .replaceAll("#\\s\\+\\s&", "#")
								 .replace("&nbsp;,", "")
								 .replace("&nbsp;", "");
		String[] dataTemp1 = dataTemp.substring(1, dataTemp.length() - 1).split("#");
		
		bean.setId(dataTemp1[0]);
		bean.setResultNum(dataTemp1[1]);
		bean.setWinningNum(dataTemp1[2]);
		bean.setBonusAmount(dataTemp1[3]);
		bean.setWinningNum_Three(dataTemp1[4]);
		bean.setBonusAmount_Three(dataTemp1[5]);
		bean.setWinningNum_Six(dataTemp1[6]);
		bean.setBonusAmount_Six(dataTemp1[7]);
		bean.setOpenTime(dataTemp1[8]);
		bean.setUpdateDate(format.format(new Date()));
	}

	private void makeXmlData() {

		XStream xs = new XStream();
		XStream xsBase = new XStream(new DomDriver());
		// Write to a file in the file system
		try {
			OutputStream fs1 = new FileOutputStream(Constant.getPaiLieSanPath_New());
			xs.toXML(bean, fs1);

			File file = new File(Constant.getPaiLieSanPath());
			FileInputStream input = new FileInputStream(file);
			@SuppressWarnings("unchecked")
			ArrayList<PailiesanBean> list = (ArrayList<PailiesanBean>)xsBase.fromXML(input);
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

	/**
	 * 彩票查询方法，供外部调用
	 * 
	 * @return
	 */
	public void makeCaipiaoInfo() {
		
		// 获取网页源代码
		String html = httpRequest(Constant.PAILIE_THREE_URL_NEW);
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
		PaiLieSanUploadEveryday paiLieSanUploadEveryday = new PaiLieSanUploadEveryday();
		paiLieSanUploadEveryday.makeCaipiaoInfo();
		System.out.print("success~~~");
	}
}