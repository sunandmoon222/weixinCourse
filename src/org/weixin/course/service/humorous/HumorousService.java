package org.weixin.course.service.humorous;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.weixin.course.service.humorous.bean.HumorousBean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class HumorousService {

	public static ArrayList<HumorousBean> listBase = null;

	@SuppressWarnings("unchecked")
	public static String getHumorousInfor() {

		if (listBase == null) {
		
			XStream xsBase = new XStream(new DomDriver());
			try {
				File file = new File(HumorousConst.getHumorousPath());
				FileInputStream input = new FileInputStream(file);
	
				listBase = (ArrayList<HumorousBean>) xsBase.fromXML(input);
				input.close();
				input = null;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return listBase.get(Long.valueOf(Math.round(Math.random() * (listBase.size() - 1))).intValue()).getContent();
	}
}
