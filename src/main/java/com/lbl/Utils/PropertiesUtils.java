package com.lbl.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
//读取properties文件
public class PropertiesUtils {
	private String propertiesName=null;
	
	public PropertiesUtils(){
		this.propertiesName="local.properties";
	}
	public PropertiesUtils(String fileName){
		this.propertiesName=fileName;
	}
	public String getValue(String key){
		Properties pro=null;
		String path ="configs\\"+this.propertiesName;
		try {
			FileInputStream in=new FileInputStream(path);
			pro=new Properties();
			pro.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro.getProperty(key);
		
		
	}
}
