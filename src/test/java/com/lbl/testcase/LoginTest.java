package com.lbl.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lbl.Utils.AssertUtils;
import com.lbl.actions.LoginOperate;
import com.lbl.baseframe.DriverFactory;
import com.lbl.pages.MainPage;

public class LoginTest {
	WebDriver driver;
	AssertUtils assertUtils;
	//测试准备工作
	@BeforeTest
	public void SetUp(){
		try{
			assertUtils=new AssertUtils();
			driver=DriverFactory.getChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}catch(Exception e){
			Assert.fail("初始化报错，不执行后续代码");
		}
	}
	
	@Test
	public void SuccessLoginTest(){
		LoginOperate.setDriver(driver);
		MainPage mp=LoginOperate.LoginSuccess("lbl", "123456");
		String userName=mp.getUserName();
		Assert.assertEquals(userName.contains("lbl"),true,"登录测试用例执行成功！");//显示登录用户的菜单
	}
	
	 @AfterTest
	  public void tearDown() throws InterruptedException{
		  Thread.sleep(3000);
//		  driver.quit();
	  }
  
}
