package org.weixin.course.service.tax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.weixin.course.message.resp.Article;
import org.weixin.course.service.tax.bean.TaxBean;
import org.weixin.course.service.tax.bean.TaxBeanList;
import org.weixin.course.service.tax.timer.ConstantTax;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TaxService {
	public static List<Article> getTaxInfo() {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		List<Article> list = new ArrayList<Article>(1);

		Article article = new Article();
		article.setTitle(cal.get(Calendar.YEAR)+"年第"+ getRealMonth(cal.get(Calendar.MONTH)) +"期发票摇奖结果");
		article.setDescription(getXmlInfo());
		article.setPicUrl("");
		article.setUrl("http://www.xutian-technology.com:8080/weixinCourse_sp/tax/query.do");

		list.add(article);
		return list;
	}
	
	
	private static String getXmlInfo() {
		
		StringBuffer buffer = new StringBuffer();
		
		XStream xs = new XStream(new DomDriver());
		
		File file = new File(ConstantTax.getXmlFile());
		FileInputStream input = null;;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		xs.alias("TaxBean", TaxBean.class);
		xs.alias("TaxBeanList", TaxBeanList.class);
		ArrayList<TaxBean> list = (ArrayList<TaxBean>)xs.fromXML(input);

		buffer.append("一等奖"+list.get(0).getCount()+"名，奖金60万元\n\n")
			  .append("二等奖"+list.get(1).getCount()+"名，奖金20万元\n\n")
			  .append("三等奖"+list.get(2).getCount()+"名，奖金10万元\n\n")
			  .append("四等奖"+list.get(3).getCount()+"名，奖金5万元\n\n")
			  .append("五等奖"+list.get(4).getCount()+"名，奖金1万元\n\n")
			  .append("六等奖"+list.get(5).getCount()+"名，奖金5千元\n\n")
			  .append("七等奖"+list.get(6).getCount()+"名，奖金1千元\n\n");
//		for (int i = 0; i < list.get(0).getList().size(); i++) {
//			buffer.append(emoji(0x1F4B0) + "发票代码：" + list.get(0).getList().get(i).getCode()).append("\n");
//			buffer.append("     "+ "发票号码：" + list.get(0).getList().get(i).getNum()).append("\n");
//		}
//		buffer.append("\n");
		
		
//		for (int j = 0; j < list.get(1).getList().size(); j++) {
//			buffer.append(emoji(0x1F4B0) + "发票代码：" + list.get(0).getList().get(j).getCode()).append("\n");
//			buffer.append("     "+ "发票号码：" + list.get(0).getList().get(j).getNum()).append("\n");
//		}		
	
		buffer.append("查询自己是否中奖请点击进入" + emoji(0X1F449));
		
		return buffer.toString();
	}
	
    /** 
     * emoji表情转换(hex -> utf-16) 
     *  
     * @param hexEmoji 
     * @return 
     */  
    public static String emoji(int hexEmoji) {  
        return String.valueOf(Character.toChars(hexEmoji));  
    } 
    
    
    private static String getRealMonth(int month) {
    	
    	String str = null;
    	switch (month) {
		case 0:
			str = "一";
			break;
		case 1:
			str = "二";
			break;
		case 2:
			str = "三";
			break;
		case 3:
			str = "四";
			break;
		case 4:
			str = "五";
			break;
		case 5:
			str = "六";
			break;
		case 6:
			str = "七";
			break;
		case 7:
			str = "八";
			break;
		case 8:
			str = "九";
			break;
		case 9:
			str = "十";
			break;
		case 10:
			str = "十一";
			break;
		case 11:
			str = "十二";
			break;
		}
    	return str;
    }
    
}
