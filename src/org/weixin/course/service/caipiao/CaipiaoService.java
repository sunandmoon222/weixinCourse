package org.weixin.course.service.caipiao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.weixin.course.message.resp.Article;
import org.weixin.course.service.caipiao.bean.CaipiaoBaseBean;
import org.weixin.course.service.caipiao.bean.SevenHappyBean;
import org.weixin.course.service.caipiao.bean.ShuangSeQiuBean;
import org.weixin.course.service.caipiao.bean.ThreeDBean;
import org.weixin.course.service.caipiao.timer.ConstantCaipiao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 彩票查询服务
 * 
 * @author zhangtianming
 * @date 2014-12-01
 * 
 */
public class CaipiaoService {

	private static String getDaletouInfo() {
		StringBuffer buffer = new StringBuffer();
		CaipiaoBaseBean bean = new CaipiaoBaseBean();
		XStream xs = new XStream(new DomDriver());

		File file = new File(ConstantCaipiao.getDaLeTouPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.fromXML(input, bean);

		buffer.append(ConstantCaipiao.CAIPIAO_NAME_DALETOU)
			  .append(" 【第")
			  .append(bean.getId()).append("期】")
			  .append("\n").append("前区:").append(bean.getResultNum()).append("\n")
			  .append("后区:").append(bean.getResultNumBlue());

		// buffer.append(ConstantCaipiao.CAIPIAO_NAME_DALETOU).append("\n")
		// .append("期号:"+bean.getId()).append("\n")
		// .append("开奖日期：").append(bean.getOpenTime()).append("\n")
		// .append("中奖号码：").append("\n")
		// .append("红球：").append(bean.getResultNum_red()).append("\n")
		// .append("蓝球：").append(bean.getResultNum_blue()).append("\n")
		// .append("一等奖中奖人数：").append(bean.getWinningNum()).append("\n")
		// .append("一等奖中奖金额：").append(bean.getBonusAmount());
		// .append("二等奖中奖人数：").append(bean.getWinningNum_2()).append("\n")
		// .append("二等奖中奖金额：").append(bean.getBonusAmount_2()).append("\n");

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}

	private static String getPaiLieSanInfo() {
		StringBuffer buffer = new StringBuffer();
		CaipiaoBaseBean bean = new CaipiaoBaseBean();
		XStream xs = new XStream(new DomDriver());

		File file = new File(ConstantCaipiao.getPaiLieSanPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.fromXML(input, bean);

		buffer.append(ConstantCaipiao.CAIPIAO_NAME_PAILIESAN)
			  .append(" 【第")
			  .append(bean.getId())
			  .append("期】")
			  .append("\n").append("开奖结果: ").append(bean.getResultNum());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}

	private static String getPaiLieFiveInfo() {
		StringBuffer buffer = new StringBuffer();
		CaipiaoBaseBean bean = new CaipiaoBaseBean();
		XStream xs = new XStream(new DomDriver());

		File file = new File(ConstantCaipiao.getPaiLieFivePath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.fromXML(input, bean);

		buffer.append(ConstantCaipiao.CAIPIAO_NAME_PAILIEFIVE)
			  .append(" 【第")
			  .append(bean.getId())
			  .append("期】")
			  .append("\n").append("开奖结果: ").append(bean.getResultNum());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}

	private static String getSevenStarInfo() {
		StringBuffer buffer = new StringBuffer();
		CaipiaoBaseBean bean = new CaipiaoBaseBean();
		XStream xs = new XStream(new DomDriver());

		File file = new File(ConstantCaipiao.getSevenStarPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.fromXML(input, bean);

		buffer.append(ConstantCaipiao.CAIPIAO_NAME_SEVENSTAR)
			  .append(" 【第")
			  .append(bean.getId())
			  .append("期】")
			  .append("\n").append("开奖结果: ").append(bean.getResultNum());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}

	private static String getShuangSeQiuInfo() {
		StringBuffer buffer = new StringBuffer();
		CaipiaoBaseBean bean = new CaipiaoBaseBean();
		XStream xs = new XStream(new DomDriver());

		File file = new File(ConstantCaipiao.getShuangSeQiuPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.fromXML(input, bean);

		buffer.append(ConstantCaipiao.CAIPIAO_NAME_SHUANGSEQIU)
			  .append(" 【第")
			  .append(bean.getId())
			  .append("期】")
			  .append("\n").append("红球:").append(bean.getResultNum()).append("\n")
			  .append("蓝球:").append(bean.getResultNumBlue());
		
		if (!"".equals(bean.getResultNumSpecial())) {
			buffer.append("  幸运蓝球:").append(bean.getResultNumSpecial());
		}
		
//		buffer.append(ConstantCaipiao.CAIPIAO_NAME_SHUANGSEQIU).append("\n")
//				.append("期号:" + bean.getId()).append("\n").append("开奖日期：")
//				.append(bean.getOpenTime()).append("\n").append("中奖号码：")
//				.append("\n").append(" 红球：" + bean.getResultNum_red())
//				.append("\n").append(" 蓝球：" + bean.getResultNum_blue())
//				.append("\n").append("一等奖中奖人数：").append(bean.getWinningNum())
//				.append("\n").append("一等奖中奖金额：").append(bean.getBonusAmount())
//				.append("\n\n").append("二等奖中奖人数：")
//				.append(bean.getWinningNum_2()).append("\n").append("二等奖中奖金额：")
//				.append(bean.getBonusAmount_2()).append("\n\n")
//				.append(bean.getMesseage()).append("\n\n");

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}

	private static String getSevenHappyInfo() {
		StringBuffer buffer = new StringBuffer();
		CaipiaoBaseBean bean = new CaipiaoBaseBean();
		XStream xs = new XStream(new DomDriver());

		File file = new File(ConstantCaipiao.getSevenHappyPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.fromXML(input, bean);

		buffer.append(ConstantCaipiao.CAIPIAO_NAME_SEVEN_HAPPY)
			  .append(" 【第")
			  .append(bean.getId())
			  .append("期】")
			  .append("\n")
			  .append("开奖结果: ")
			  .append(bean.getResultNum())
			  .append("  特别号码:").append(bean.getResultNumBlue());
//		buffer.append(ConstantCaipiao.CAIPIAO_NAME_SEVEN_HAPPY).append("\n")
//				.append("期号:" + bean.getId()).append("\n").append("开奖日期：")
//				.append(bean.getOpenTime()).append("\n")
//				.append("基本号码：" + bean.getResultNum()).append("\n")
//				.append("特别号码：" + bean.getResultNum_add()).append("\n")
//				.append("一等奖中奖人数：").append(bean.getWinningNum()).append("\n")
//				.append("一等奖中奖金额：").append(bean.getBonusAmount())
//				.append("\n\n").append("二等奖中奖人数：")
//				.append(bean.getWinningNum_2()).append("\n").append("二等奖中奖金额：")
//				.append(bean.getBonusAmount_2()).append("\n\n")
//				.append(bean.getMesseage());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}

	private static String getThreeDInfo() {
		StringBuffer buffer = new StringBuffer();
		CaipiaoBaseBean bean = new CaipiaoBaseBean();
		XStream xs = new XStream(new DomDriver());

		File file = new File(ConstantCaipiao.getThreeDPath_New());
		InputStream input = null;
		try {
			input = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.fromXML(input, bean);

		buffer.append(ConstantCaipiao.CAIPIAO_NAME_THREE_D)
			  .append(" 【第")
			  .append(bean.getId())
			  .append("期】")
			  .append("\n")
			  .append("开奖结果: ")
			  .append(bean.getResultNum());

		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = null;
		return buffer.toString();
	}

	public static List<Article> getFuLiCaipiaoInfo() {
		List<Article> list = new ArrayList<Article>(4);
		String info = null;

		Article article1 = new Article();
		article1.setTitle("中国福利彩票开奖结果查询");
		article1.setDescription("");
		article1.setPicUrl("http://a3.qpic.cn/psb?/V14Tfb4s4TxSWi/jfkvg92YSby1ZAFkiOxlHuI2TFxpDFATttITTVAECEs!/b/dJqHjKe5HQAA&bo=gAKvAAAAAAAFBwk!&rf=viewer_4");
		article1.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/seq.do");

		list.add(article1);

		for (int i = 0; i < 3; i++) {
			Article article = new Article();

			switch (i) {
			case 0:
				info = getShuangSeQiuInfo();
				article.setTitle(info);
				article.setDescription("");
				article.setPicUrl("http://a3.qpic.cn/psb?/V14Tfb4s4TxSWi/IeL66k7FU5sgHqNzjnWZXfPzpccuO3xhJNS2bDSSGio!/b/dHCQjKdxHgAA&bo=UABQAAAAAAAFByQ!&rf=viewer_4");
				article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/seq.do");
				break;
			case 1:
				info = getSevenHappyInfo();
				article.setTitle(info);
				article.setDescription("");
				article.setPicUrl("http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/2VGbup1.PWR.5dc4cCF5ndcSP*Sy5h*XoJx9muU1U4Y!/b/dBha76aRMQAA&bo=UABRAAAAAAAFByU!&rf=viewer_4");
				article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/qlc.do");
				break;
			case 2:
				info = getThreeDInfo();
				article.setTitle(info);
				article.setDescription("");
				article.setPicUrl("http://a3.qpic.cn/psb?/V14Tfb4s4TxSWi/cY5skTUtrtTHPvpqi8mvNMgK4F6.zz4yxLq2KBCFcU4!/b/dKX5h6cAHQAA&bo=UABQAAAAAAAFByQ!&rf=viewer_4");
				article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/3d.do");
				break;
			}

			list.add(article);
		}

		return list;
	}

	public static List<Article> getSportsCaipiaoInfo() {
		List<Article> list = new ArrayList<Article>(5);
		String info = null;

		Article article1 = new Article();
		article1.setTitle("中国体育彩票开奖结果查询");
		article1.setDescription("");
		article1.setPicUrl("http://a3.qpic.cn/psb?/V14Tfb4s4TxSWi/svWbVN*Izr3huc4TzbyrsFamtx*tsMMX21.A5aFkXaU!/b/dNzmhKfjHQAA&bo=gAI5AQAAAAAFB54!&rf=viewer_4");
		article1.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/dlt.do");

		list.add(article1);

		for (int i = 0; i < 4; i++) {
			Article article = new Article();

			switch (i) {
			case 0:
				info = getDaletouInfo();
				article.setTitle(info);
				article.setDescription("");
				article.setPicUrl("http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/Ei2X27enXgTVdVxkxmxAebN51GcVOf3DcTVfrAAVGBQ!/b/dBTx8KbqMgAA&bo=UABRAAAAAAAFByU!&rf=viewer_4");
				article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/dlt.do");
				break;
			case 1:
				info = getPaiLieSanInfo();
				article.setTitle(info);
				article.setDescription("");
				article.setPicUrl("http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/.FXa6jGQdQrXSQm7DFI*nQWqxDb4Nvu5E3Yn9qzv0Gk!/b/dDXF6qYGMwAA&bo=UAA*AAAAAAAFB0s!&rf=viewer_4");
				article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/pls.do");
				break;
			case 2:
				info = getPaiLieFiveInfo();
				article.setTitle(info);
				article.setDescription("");
				article.setPicUrl("http://a3.qpic.cn/psb?/V14Tfb4s4TxSWi/aNkSlokxQgzIk1MAKImloYQy9nv1O6VDoIjSoMLEYNo!/b/dCNTg6cVHQAA&bo=UABaAAAAAAAFBy4!&rf=viewer_4");
				article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/plw.do");
				break;
			case 3:
				info = getSevenStarInfo();
				article.setTitle(info);
				article.setDescription("");
				article.setPicUrl("http://a2.qpic.cn/psb?/V14Tfb4s4TxSWi/nu5Jiq0646ywmLovzwxy6lUoB.G0RvQbDpv2fBG1TKg!/b/dFXR8KZpKwAA&bo=UABOAAAAAAAFBzo!&rf=viewer_4");
				article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/caipiao/qx.do");
				break;
			}

			list.add(article);
		}

		return list;
	}
	
//	public static String getFuLiCaipiaoInfo() {
//
//		ConstantCaipiao.setIsPC(false);
//
//		String strThreeD = getThreeDInfo();
//		String strShuangSeQiu = getShuangSeQiuInfo();
//		String strSevenHappy = getSevenHappyInfo();
//
//		StringBuffer buffer = new StringBuffer();
//		buffer.append(strThreeD).append(strShuangSeQiu).append(strSevenHappy);
//
//		return buffer.toString();
//	}
	
	// public static String getSportsCaipiaoInfo() {
	//
	// ConstantCaipiao.setIsPC(false);
	//
	// String strDaletou = getDaletouInfo();
	// String strPaiLieSan = getPaiLieSanInfo();
	// String strPaiLieFive = getPaiLieFiveInfo();
	// String strSevenStar = getSevenStarInfo();
	//
	// StringBuffer buffer = new StringBuffer();
	// buffer.append(strDaletou).append("\n\n").append(strPaiLieSan)
	// .append("\n\n").append(strPaiLieFive).append("\n\n")
	// .append(strSevenStar);
	//
	// return buffer.toString();
	// }

	/**
	 * 通过main在本地测试
	 * 
	 * @param args
	 */
	// public static void main(String[] args) {
	// getTodayDate();
	// System.out.print("success~~~");
	// }

}