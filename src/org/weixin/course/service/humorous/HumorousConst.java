package org.weixin.course.service.humorous;

public class HumorousConst {

	public static final String HUMOROUS_URL = "http://xiaohua.zol.com.cn/detail44/";
	//last 43912
	public static final int URL_PATH_NUM = 38000;
	public static final int URL_PATH_NUM_ADD = 1200;
	public static final int THREAD_SLEEP_TIME = 2;
	private static boolean isPC = false;
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static String getHumorousPath() {
		String path = "";

		if (isPC)
			path= System.getProperty("user.dir") + "\\src\\Resources\\data\\humorous\\humorous_3.xml";
		else {
			path = "/alidata/www/humorous/humorous.xml";
		}
		return path;
	}
}
