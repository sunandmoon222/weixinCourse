package org.weixin.course.service.tax.timer;

public class ConstantTax {
	private static boolean isPC = false;
	
	public static void setIsPC(boolean bool) {
		isPC = bool;
	}

	public static String getTxtFile() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\tax\\taxData.txt";
		else {
			path = "/alidata/www/taxData/taxData.txt";
		}
		return path;
	}

	public static String getXmlFile() {
		String path = "";

		if (isPC)
			path = System.getProperty("user.dir")
					+ "\\src\\Resources\\data\\tax\\taxData.xml";
		else {
			path = "/alidata/www/taxData/taxData.xml";
		}
		return path;
	}
}