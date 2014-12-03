package org.weixin.course.service.timer;

public class Constant {

	public final static String SHELL_PAHT = "/alidata/www/weixin_shell/";
	public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static int THREAD_SLEEP_TIME = 2;
	public final static boolean isPC = false;
	//大乐透
	public final static String DALETOU_URL = "http://www.lottery.gov.cn/lottery/dlt/History.aspx?p=";
	public final static String DALETOU_NEW_URL = "http://www.lottery.gov.cn/lottery/dlt/History.aspx";
	public final static int DALETOU_BASE_PAGENUM = 24;
	//排列三
	public final static String PAILIE_THREE_URL = "http://www.lottery.gov.cn/lottery/pls/History.aspx?p=";
	public final static String PAILIE_THREE_URL_NEW = "http://www.lottery.gov.cn/lottery/pls/History.aspx";
	public final static int PAILIE_THREE_BASE_PAGENUM = 74;
	//排列五
	public final static String PAILIE_FIVE_URL = "http://www.lottery.gov.cn/lottery/plw/History.aspx?p=";
	public final static String PAILIE_FIVE_URL_NEW = "http://www.lottery.gov.cn/lottery/plw/History.aspx";
	public final static int PAILIE_FIVE_BASE_PAGENUM = 74;
	//双色球
	public final static String SHUANGSEQIU_LOCAL_PATH = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\shuangseqiuData.txt";
	public final static String SHUANGSEQIU_URL = "http://www.cwl.gov.cn/kjxx/ssq/kjgg/388484.shtml";
	
	//七星
	public final static String SEVEN_STAR_URL = "http://www.lottery.gov.cn/lottery/qxc/History.aspx?p=";
	public final static String SEVEN_STAR_URL_NEW = "http://www.lottery.gov.cn/lottery/qxc/History.aspx";
	public final static int SEVEN_STAR_BASE_PAGENUM = 34;
	public static String getDaLeTouPath() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\daletou.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/daletou.xml";
		}
		return path;
	}
	
	public static String getDaLeTouPath_New() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\daletou_new.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/daletou_new.xml";
		}
		return path;
	}
	

	public static String getPaiLieSanPath() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\pailiesan.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/pailiesan.xml";
		}
		return path;
	}
	
	public static String getPaiLieSanPath_New() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\pailiesan_new.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/pailiesan_new.xml";
		}
		return path;
	}
	

	public static String getPaiLieFivePath() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\pailieFive.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/pailieFive.xml";
		}
		return path;
	}
	
	public static String getPaiLieFivePath_New() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\pailieFive_new.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/pailieFive_new.xml";
		}
		return path;
	}

	
	public static String getSevenStarPath() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\sevenstar.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/sevenstar.xml";
		}
		return path;
	}
	
	public static String getSevenStarPath_New() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\sevenstar_new.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/sevenstar_new.xml";
		}
		return path;
	}
	
	
	public static String getShuangSeQiuPath() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\shuangseqiu.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/shuangseqiu.xml";
		}
		return path;
	}
	
	public static String getShuangSeQiuPath_New() {
		
		String path = "";
		
		if (isPC) {
			path = System.getProperty("user.dir") + "\\src\\Resources\\data\\caipiao\\shuangseqiu_new.xml";
		} else {
			path = "/alidata/server/tomcat7/webapps/weixinCourse/WEB-INF/classes/Resources/data/caipiao/shuangseqiu_new.xml";
		}
		return path;
	}
}
