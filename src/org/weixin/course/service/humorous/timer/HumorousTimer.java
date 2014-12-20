package org.weixin.course.service.humorous.timer;

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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.weixin.course.service.humorous.HumorousConst;
import org.weixin.course.service.humorous.HumorousService;
import org.weixin.course.service.humorous.bean.HumorousBean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class HumorousTimer {

	List<HumorousBean> list = new ArrayList<HumorousBean>();
	
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
					inputStream, "gbk");
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

	private String extract(String html, String id) throws Exception {

		DateFormat format = new SimpleDateFormat(HumorousConst.DATE_FORMAT);
		HumorousBean humorousBean = new HumorousBean();

		String str1=null;
		String strTemp = null;
		Pattern p = Pattern.compile(".*article-text\">(.*)<div data-id.*");
		Matcher m = p.matcher(html);
		while (m.find()) {
			strTemp = m.group(1);
		}

		if (strTemp.contains("img")) {
			return "next";
		}
		if (strTemp.contains("&gt;") || strTemp.contains("&lt;") || strTemp.contains("img")) {
			return "next";
		}
		str1 = strTemp.replace("</div>", "")
		   .replace("</p>", "")
		   .replace("<p>", "\n");
		str1 = str1.replace("&quot;", "")
		   .replace("&amp;", "")
		   .replace("&gt;", "")
		   .replace("&lt;", "")
		   .replace("nbsp", "")
		   .replaceAll("\\s*", "");
		   
		humorousBean.setContent(str1);
		humorousBean.setTime(format.format(new Date()));

		list.add(humorousBean);
		
		return "success";
	}

	private void makeInfo() {

		// 获取网页源代码
		for (int i = HumorousConst.URL_PATH_NUM; i < HumorousConst.URL_PATH_NUM + HumorousConst.URL_PATH_NUM_ADD; i++) {

			String html = httpRequest(HumorousConst.HUMOROUS_URL + String.valueOf(i) + ".html");
			String strFlg = "";

			try {
				// 从网页中抽取信息
				strFlg = extract(html, String.valueOf(i));
				Thread.sleep(HumorousConst.THREAD_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("error::i == " + i);
				continue;
			}

			if (strFlg.equals("next")) {
				System.out.println("no Data::i== " + i);
				continue;
			}
			System.out.println("i == " + i);
		}

		makeXmlData();
	}

	private void makeXmlData() {
		XStream xsBase = new XStream(new DomDriver());
		try {

			File file = new File(HumorousConst.getHumorousPath());
			FileInputStream input = new FileInputStream(file);

			ArrayList<HumorousBean> listBase = (ArrayList<HumorousBean>)xsBase.fromXML(input);
			int listBaseSize = listBase.size();
			
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setId(String.valueOf(listBaseSize+i));
				listBase.add(list.get(i));
			}

			OutputStream fs = new FileOutputStream(file);

			xsBase.toXML(listBase, fs);
			HumorousService.listBase = null;
			
			fs.close();
			fs = null;
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
		HumorousTimer humorousTimer = new HumorousTimer();
		humorousTimer.makeInfo();
		System.out.print("humorous get success~~~");
	}
}
