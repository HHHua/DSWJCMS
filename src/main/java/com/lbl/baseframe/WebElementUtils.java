package com.lbl.baseframe;

import java.io.IOException;
import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lbl.baseframe.Locator;
import com.lbl.baseframe.Locator.ByType;
import com.lbl.Utils.xmlUtils;

import junit.framework.Assert;

public class WebElementUtils extends DriverUtils {
	protected HashMap<String,Locator> locatorMap;
	protected String path;

	public WebElementUtils(WebDriver dr) {
		super(dr);
		path=System.getProperty("user.dir")+"/webelementdata/"+this.getClass().getSimpleName()+".xml";
		try {
			locatorMap=xmlUtils.readElementInfo(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	//点击、输入、提交、查找元素、获取元素属性、获取元素文本
	public WebElement getElement(Locator locator)  {
		WebElement el = null;
		ByType type=locator.getByType();
		try{
		switch(type){
		case id:
			el=driver.findElement(By.id(locator.getLocateInfo()));
			break;
		case name:
			el=driver.findElement(By.name(locator.getLocateInfo()));
			break;
		case xpath:
			el=driver.findElement(By.xpath(locator.getLocateInfo()));
			break;
		case cssSelector:
			el=driver.findElement(By.cssSelector(locator.getLocateInfo()));
			break;
		}}catch(Exception e){
			try {
				log.info("元素： "+locator.getElementName()+" 识别异常");
				takeScreenShot("findElementErrorImage");
				Assert.fail("查找元素异常，退出当前测试用例");
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			
			
		}
		return el;
	}
	
	
	public WebElement findElement(final Locator locator){
		//使用WebDriverWait显示等待
		WebDriverWait wait=new WebDriverWait(driver,locator.getTimeOuts());
		WebElement el=wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return getElement(locator);
			}
		});
		return el;
	}
	
	
	public void click(Locator locator){
		WebElement e=findElement(locator);
		e.click(); 
		log.info("点击元素： "+locator.getElementName());
	}
	public void input(Locator locator,String content){
		WebElement e=findElement(locator);
		e.sendKeys(content);
		log.info("在元素： "+locator.getElementName()+" 输入："+content);

	}
	public void submit(Locator locator){
		WebElement e=findElement(locator);
		e.submit();
	}
	public String getText(Locator locator){
		WebElement e=findElement(locator);
		log.info("获取元素： "+locator.getElementName()+"文本值");
		return e.getText();
	}
	public String getAttribute(Locator locator,String attribute){
		WebElement e=findElement(locator);
		return e.getAttribute(attribute);
	}
	public Locator getLocator(String locatorName){
		Locator locator=locatorMap.get(locatorName);
		return locator;
	}
}
