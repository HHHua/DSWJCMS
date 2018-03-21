package com.lbl.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class testCase {
	WebDriver driver = null;

	//数据分离：测试数据（数据驱动、xml文件parameter配置、excel）
	@DataProvider(name="testData")
	public static Object[][] primeNumbers(){
		return new Object[][]{{"lbl","123456"},{"lbl01","123456"},{"***","123"}};
	}
	
	//测试准备：打开被测系统
	@BeforeMethod
	//参数化
	@Parameters("url")
	public void setUp(String url){
		driver = ElementOperate.openWeb(driver, url);
		System.out.println("网站已经打开！");
	}
	
	@Test(dataProvider="testData")
	public void loginTest(String account,String password){
		driver = ElementOperate.login(driver,account,password);	
	}
	
	
	//测试后续工作：退出浏览器
	@AfterMethod
	public void quit(){
		try {
			wait(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
  
}
