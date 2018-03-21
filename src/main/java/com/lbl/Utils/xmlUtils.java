package com.lbl.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.lbl.baseframe.Locator;
import com.lbl.baseframe.Locator.ByType;


public class xmlUtils {
	public static HashMap<String,Locator> readElementInfo(String filePath) throws DocumentException {
//		String xmlFilePath=System.getProperty("user.dir")+"/webelementdata/"+fileName;
		Map<String,Locator> elementInfos=new HashMap<String,Locator>();
		SAXReader saxReader=new SAXReader();
		Document document=saxReader.read(new File(filePath));
		Element root=document.getRootElement();
		List<Element> childList=root.elements("locator");
		for(Element e:childList){
			String value=e.attributeValue("value").toString();
			int timeOut=Integer.parseInt(e.attributeValue("timeout"));
			String name=e.attributeValue("name").toString();
			String type=e.attributeValue("type").toString();
			Locator locator=new Locator(value,timeOut,getType(type),name);
			String keyName=e.getText();
			elementInfos.put(keyName, locator);
		}
		return (HashMap<String, Locator>) elementInfos;
		
	}
	public static ByType getType(String value){
		ByType type=null;
		switch(value){
		case "css":
			type=ByType.cssSelector;
			break;
		case "xpath":
			type=ByType.xpath;
			break;
		case "id":
			type=ByType.id;
			break;	
		case "name":
			type=ByType.name;
			break;
		case "className":
			type=ByType.className;
			break;
		case "partiaLinkText":
			type=ByType.partiaLinkText;
			break;
		case "linkText":
			type=ByType.linkText;
			break;
		}
		
		return type;

}
}
