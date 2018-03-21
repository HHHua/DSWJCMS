package com.lbl.baseframe;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebElementUtils{
	public BasePage(WebDriver dr){
		super(dr);
		
	}
	//获取网页源代码
	public String getPageSource(){
		wait(3);
		return driver.getPageSource();
	}
	//js弹窗
	public void alertAccept(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss(){
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public String getAlertText(){
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}
	public void inputAlert(String value){
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	
	//多窗口处理
	public void SwitchToFrame(WebDriver dr){
		//获得当前窗口的句柄
		String defaultWindow=dr.getWindowHandle();
		wait(3);
		//创建一个set集合存放窗口句柄
		Set<String> currentWindows=dr.getWindowHandles();
		//通过循环切换窗口
		for(String window:currentWindows){
			if(!window.endsWith(defaultWindow)){
				//使用switchTo()跳转窗口
				dr=dr.switchTo().window(window);
				//设置页面等待时间
				dr.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				break;
			}
		}
	}
	
	
	
	
}
