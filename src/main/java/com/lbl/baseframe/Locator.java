package com.lbl.baseframe;

public class Locator {
	//枚举类型
	public enum ByType{
		xpath,id,linkText,name,className,cssSelector,partiaLinkText
	}
	private String elementName;
	private String locateInfo;
	private int timeOuts;
	private ByType byType;
	
	public Locator(String element,int waitSec,ByType byType,String name){
		this.elementName=name;
		this.locateInfo=element;
		this.timeOuts=waitSec;
		this.byType=byType;
		
	}

	public String getElementName() {
		return elementName;
	}

	public String getLocateInfo() {
		return locateInfo;
	}

	public int getTimeOuts() {
		return timeOuts;
	}

	public ByType getByType() {
		return byType;
	}
	

}
