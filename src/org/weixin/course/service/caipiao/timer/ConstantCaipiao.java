package org.weixin.course.service.caipiao.timer;

public class ConstantCaipiao {
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final int THREAD_SLEEP_TIME = 2;
	private static boolean isPC = false;
	
	//超级大乐透
	public static final String CAIPIAO_NAME_DALETOU = "超级大乐透";
	public static final String DALETOU_URL = "http://www.lottery.gov.cn";
	public static final String DALETOU_NEW_URL = "http://www.lottery.gov.cn/lottery/dlt/History.aspx";
	public static final int DALETOU_BASE_PAGENUM = 24;
	
	//排列三
	public static final String CAIPIAO_NAME_PAILIESAN = "排列三";
	public static final String PAILIE_THREE_URL = "http://www.lottery.gov.cn/";
	public static final String PAILIE_THREE_URL_NEW = "http://www.lottery.gov.cn/lottery/pls/History.aspx";
	public static final int PAILIE_THREE_BASE_PAGENUM = 74;
	
	//排列五
	public static final String CAIPIAO_NAME_PAILIEFIVE = "排列五";
	public static final String PAILIE_FIVE_URL = "http://www.lottery.gov.cn";
	public static final String PAILIE_FIVE_URL_NEW = "http://www.lottery.gov.cn/lottery/plw/History.aspx";
	public static final int PAILIE_FIVE_BASE_PAGENUM = 74;
	
	//七星彩
	public static final String CAIPIAO_NAME_SEVENSTAR = "七星彩";
	public static final String SEVEN_STAR_URL = "http://www.lottery.gov.cn/";
	public static final String SEVEN_STAR_URL_NEW = "http://www.lottery.gov.cn/lottery/qxc/History.aspx";
	public static final int SEVEN_STAR_BASE_PAGENUM = 34;
	
	//双色球
	public static final String CAIPIAO_NAME_SHUANGSEQIU = "双色球";
	public static final String SHUANGSEQIU_LOCAL_PATH = System.getProperty("user.dir")+ "\\src\\Resources\\data\\caipiao\\shuangseqiuData.txt";
	public static final String SHUANGSEQIU_URL = "http://www.cwl.gov.cn";
	
	//七乐彩
	public static final String CAIPIAO_NAME_SEVEN_HAPPY = "七乐彩";
	public static final String SEVEN_HAPPY_LOCAL_PATH = System.getProperty("user.dir")+ "\\src\\Resources\\data\\caipiao\\sevenhappyData.txt";
	public static final String SEVEN_HAPPY_URL = "http://www.cwl.gov.cn";
	
	//3D
	public static final String CAIPIAO_NAME_THREE_D = "3D";
	public static final String THREE_D_LOCAL_PATH = System.getProperty("user.dir")+ "\\src\\Resources\\data\\caipiao\\threeDData.txt";
	public static final String THREE_D_URL = "http://www.cwl.gov.cn";

	public static void setIsPC(boolean bool) {
		isPC = bool;
	}

	public static String getDaLeTouPath() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\daletou.xml";
		else {
			path = "/alidata/www/caipiao_data/daletou.xml";
		}
		return path;
	}

	public static String getDaLeTouPath_New() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\daletou_new.xml";
		else {
			path = "/alidata/www/caipiao_data/daletou_new.xml";
		}
		return path;
	}

	public static String getPaiLieSanPath() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\pailiesan.xml";
		else {
			path = "/alidata/www/caipiao_data/pailiesan.xml";
		}
		return path;
	}

	public static String getPaiLieSanPath_New() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\pailiesan_new.xml";
		else {
			path = "/alidata/www/caipiao_data/pailiesan_new.xml";
		}
		return path;
	}

	public static String getPaiLieFivePath() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\pailieFive.xml";
		else {
			path = "/alidata/www/caipiao_data/pailieFive.xml";
		}
		return path;
	}

	public static String getPaiLieFivePath_New() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\pailieFive_new.xml";
		else {
			path = "/alidata/www/caipiao_data/pailieFive_new.xml";
		}
		return path;
	}

	public static String getSevenStarPath() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\sevenstar.xml";
		else {
			path = "/alidata/www/caipiao_data/sevenstar.xml";
		}
		return path;
	}

	public static String getSevenStarPath_New() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\sevenstar_new.xml";
		else {
			path = "/alidata/www/caipiao_data/sevenstar_new.xml";
		}
		return path;
	}

	public static String getShuangSeQiuPath() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\shuangseqiu.xml";
		else {
			path = "/alidata/www/caipiao_data/shuangseqiu.xml";
		}
		return path;
	}

	public static String getShuangSeQiuPath_New() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\shuangseqiu_new.xml";
		else {
			path = "/alidata/www/caipiao_data/shuangseqiu_new.xml";
		}
		return path;
	}

	public static String getSevenHappyPath() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\sevenhappy.xml";
		else {
			path = "/alidata/www/caipiao_data/sevenhappy.xml";
		}
		return path;
	}

	public static String getSevenHappyPath_New() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\sevenhappy_new.xml";
		else {
			path = "/alidata/www/caipiao_data/sevenhappy_new.xml";
		}
		return path;
	}

	public static String getThreeDPath() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\threeD.xml";
		else {
			path = "/alidata/www/caipiao_data/threeD.xml";
		}
		return path;
	}

	public static String getThreeDPath_New() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\caipiao\\threeD_new.xml";
		else {
			path = "/alidata/www/caipiao_data/threeD_new.xml";
		}
		return path;
	}
}