package org.weixin.course.service.tax.timer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.weixin.course.service.tax.bean.TaxBean;
import org.weixin.course.service.tax.bean.TaxBeanList;

import com.thoughtworks.xstream.XStream;

public class TaxTimer {

	private List<TaxBean> list = new ArrayList<TaxBean>();

	private void makeXml() {

		OutputStream out = null;
		try {
			out = new FileOutputStream(ConstantTax.getXmlFile());
			XStream xs = new XStream();
			xs.alias("TaxBean", TaxBean.class);
			xs.alias("TaxBeanList", TaxBeanList.class);
			xs.toXML(list, out);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void makeData() {
		Pattern p = null;
		Matcher m = null;
		TaxBean taxBean = new TaxBean();
		try {
			// FileReader reader = new FileReader(file);
			// BufferedReader br = new BufferedReader(reader);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(ConstantTax.getTxtFile()), "UTF-8"));
			String str = null;
			while ((str = br.readLine()) != null) {
				if (str.contains("等奖")) {
					p = Pattern.compile(".*等奖([0-9]*)个.*人民币(.*)元.*");
					m = p.matcher(str);

					while (m.find()) {
						if (m.group(2).equals("60万")) {
							taxBean.setId("一等奖");
							taxBean.setCount(m.group(1));
						} else if (m.group(2).equals("20万")) {
							list.add(taxBean);
							taxBean = new TaxBean();
							taxBean.setId("二等奖");
						} else if (m.group(2).equals("10万")) {
							list.add(taxBean);
							taxBean = new TaxBean();
							taxBean.setId("三等奖");
						} else if (m.group(2).equals("5万")) {
							list.add(taxBean);
							taxBean = new TaxBean();
							taxBean.setId("四等奖");
						} else if (m.group(2).equals("1万")) {
							list.add(taxBean);
							taxBean = new TaxBean();
							taxBean.setId("五等奖");
						} else if (m.group(2).equals("5千")) {
							list.add(taxBean);
							taxBean = new TaxBean();
							taxBean.setId("六等奖");
						} else if (m.group(2).equals("1千")) {
							list.add(taxBean);
							taxBean = new TaxBean();
							taxBean.setId("七等奖");
						}

						taxBean.setCount(m.group(1));
					}
				} else {
					TaxBeanList taxBeanData = new TaxBeanList();

					p = Pattern
							.compile(".*发票代码：([0-9]*).*发票号码：([0-9]*).*收款方名称：(.*)");
					m = p.matcher(str);

					while (m.find()) {
						taxBeanData.setCode(m.group(1));
						taxBeanData.setNum(m.group(2));
						taxBeanData.setPayee(m.group(3));
					}
					taxBean.getList().add(taxBeanData);
				}
			}
			list.add(taxBean);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TaxTimer tax = new TaxTimer();
		tax.makeData();
		tax.makeXml();

		System.out.print("Tax data Xml make success~~~");
	}
}
