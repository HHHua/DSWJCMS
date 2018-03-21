package com.lbl.config;

import com.lbl.Utils.PropertiesUtils;

//调用PropertiesUtils，取得文件的值
public class LocalConfig {
	static PropertiesUtils propertiesUtils=new PropertiesUtils("local.properties");
	public static final String URL=propertiesUtils.getValue("url");
	public static final String CHROME_PATH=propertiesUtils.getValue("chromeDriverPath");
	public static final String FIREFOX_PATH=propertiesUtils.getValue("fireFoxDriverPath");
	public static final String SCREENSHOTPATH=propertiesUtils.getValue("shotPath");

}
