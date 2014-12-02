package org.weixin.course.service.timer;

import java.io.BufferedReader;
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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.weixin.course.service.content.bean.PailiesanBean;

import com.thoughtworks.xstream.XStream;

/**
 * 彩票查询服务
 * 
 * @author zhangtianming
 * @date 2014-12-01
 * 
 */
public class PaiLieSanUploadBase {

	private List<PailiesanBean> dataList = new ArrayList<PailiesanBean>();
	private final static String filePath = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\pailiesan.xml";
	private final String url = "http://www.lottery.gov.cn/lottery/pls/History.aspx?p=";
	private final int pageNum = 74;
	private final String dateFormate = "yyyy-MM-dd HH:mm:ss";
	
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
		DateFormat format = new SimpleDateFormat(dateFormate);
		
		String strTemp = null;
		Pattern p = Pattern.compile("(.*)(奖金</TD>\\s+</TR>)(.*)</TABLE>\\s+</TD>.*");
		Matcher m = p.matcher(html);
		while (m.find()) {
			strTemp = m.group(3);
		}
		String[] data = strTemp.split("</TR>");

		for (int i = 0; i < data.length - 1; i++) {

			PailiesanBean bean = new PailiesanBean();
			String dataTemp = data[i].replace("    ", "")
									 .replace(",", "")
									 .replaceAll("</?[^>]+>", "#").replaceAll("#+", "#")
									 .replaceAll("#\\s\\+\\s&", "#")
									 .replace("&nbsp;,", "")
									 .replace("&nbsp;", "");
			String[] dataTemp1 = dataTemp.substring(1, dataTemp.length() - 1).split("#");
			if ("13321".equals(dataTemp1[0])) {
				bean.setId(dataTemp1[0]);
				bean.setResultNum(dataTemp1[1]);
				bean.setWinningNum(dataTemp1[2]);
				bean.setBonusAmount(dataTemp1[3]);
				bean.setWinningNum_Three(dataTemp1[4]);
				bean.setBonusAmount_Three(dataTemp1[5]);
				bean.setWinningNum_Six("0");
				bean.setBonusAmount_Six(dataTemp1[6]);
				bean.setOpenTime(dataTemp1[7]);
				bean.setUpdateDate(format.format(new Date()));
			} else {
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
			dataList.add(bean);
		}

	}

	private void makeXmlData() {

		XStream xs = new XStream();
		// Write to a file in the file system
		try {
			OutputStream fs = new FileOutputStream(filePath,true);
			xs.toXML(dataList, fs);
			fs.close();
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
		for (int i = 1; i < pageNum; i++) {
			
			String html = httpRequest(url+String.valueOf(i));
			// 从网页中抽取信息
			extract(html);
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("i == " +i);
		}

		makeXmlData();
	}
	
	/**
	 * 通过main在本地测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PaiLieSanUploadBase paiLiesSanUploadBase = new PaiLieSanUploadBase();
		paiLiesSanUploadBase.makeCaipiaoInfo();
		System.out.print("success~~~");
	}
}