package org.weixin.course.service.timer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
public class DaletouUploadEveryday {

	private DaletouBean bean = new DaletouBean();
	private final static String filePath = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\daletou.xml";
	private final static String filePath_1 = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\daletou_new.xml";
	private final static String url = "http://www.lottery.gov.cn/lottery/dlt/History.aspx";
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
		Pattern p = Pattern.compile("(.*)(追加奖金</td>\\s+</tr>)(.*)</TABLE>.*");
		Matcher m = p.matcher(html);
		while (m.find()) {
			strTemp = m.group(3);
		}

		String[] data = strTemp.split("</tr>");
		String dataTemp = data[0].replace("    ", "")
								 .replaceAll("</?[^>]+>", "&").replaceAll("&+", "&")
								 .replaceAll("&\\s\\+\\s&", "&");
		String[] dataTemp1 = dataTemp.substring(1, dataTemp.length() - 1).split("&");
		bean.setId(dataTemp1[0]);
		bean.setResultNum_red(dataTemp1[1]);
		bean.setResultNum_blue(dataTemp1[2]);
		bean.setWinningNum(dataTemp1[3]);
		bean.setBonusAmount(dataTemp1[4]);
		bean.setWinningNumAdd(dataTemp1[5]);
		bean.setBonusAmountAdd(dataTemp1[6]);
		bean.setWinningNum_2(dataTemp1[7]);
		bean.setBonusAmount_2(dataTemp1[8]);
		bean.setWinningNumAdd_2(dataTemp1[9]);
		bean.setBonusAmountAdd_2(dataTemp1[10]);
		bean.setOpenTime(dataTemp1[11]);
		bean.setUpdateDate(format.format(new Date()));
	}

	private void makeXmlData() {

		XStream xs = new XStream();
		XStream xsBase = new XStream(new DomDriver());
		// Write to a file in the file system
		try {
			OutputStream fs1 = new FileOutputStream(filePath_1);
			xs.toXML(bean, fs1);

			File file = new File(filePath);
			FileInputStream input = new FileInputStream(file);
			@SuppressWarnings("unchecked")
			ArrayList<DaletouBean> list = (ArrayList<DaletouBean>)xsBase.fromXML(input);
			list.add(0, bean);

			OutputStream fs = new FileOutputStream(filePath);
			
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
		String html = httpRequest(url);
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
		DaletouUploadEveryday daletouUploadEveryday = new DaletouUploadEveryday();
		daletouUploadEveryday.makeCaipiaoInfo();
		System.out.print("success~~~");
	}
}