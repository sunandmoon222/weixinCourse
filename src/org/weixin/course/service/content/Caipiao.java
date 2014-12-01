package org.weixin.course.service.content;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caipiao {

	/**
	 * 发起http get请求获取网页源代码
	 * 
	 * @param requestUrl
	 * @return
	 */
	private static String httpRequest(String requestUrl) {
		StringBuffer buffer = null;

		try {
			// 建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");

			// 获取输入流
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

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
	 * 解析气象信息
	 * 
	 * @param json
	 * @return
	 */
	private static String extract(String data) {
		
//		Pattern p = Pattern.compile("(.*)(<div class=\"listren\">)(.*?)(</div>)(.*)");
		
		String str = "dfsafasdfsdf<div class=\"listren\">asdfasdfsdsdf</div>jh";
		Pattern p = Pattern.compile("(.*)(<div class=\"listren\">)(.*?)(</div>)(.*)");
		Matcher m = p.matcher(str);
		
		
//		Pattern p = Pattern.compile("。*<td width=\"69\">追加奖金</td>\\s*</tr>([^</TABLE>])+</TABLE>.*");
//		Matcher m = p.matcher(data);
		return m.group(1);
	}

	/**
	 * 彩票接口，供外部调用
	 * 
	 * @return
	 */
	public static String getResultInfo() {
		// 获取气象网中
		String data = httpRequest("http://www.lottery.gov.cn/lottery/dlt/History.aspx?p=1");
		String result = extract(data);

		return result;
	}

	/**
	 * 通过main在本地测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String info = getResultInfo();
		
		System.out.println(info);
	}
}
