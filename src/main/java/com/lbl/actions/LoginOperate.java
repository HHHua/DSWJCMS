package com.lbl.actions;

import org.openqa.selenium.WebDriver;

import com.lbl.pages.MainPage;
import com.lbl.pages.LoginPage;

public class LoginOperate {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		LoginOperate.driver = driver;
	}
	static LoginPage loginPage;
	
	//正确登录业务
		public static MainPage LoginSuccess(String name,String passwd){
			loginPage=new LoginPage(getDriver());
			loginPage.inputUserName(name);
			loginPage.inputPassword(passwd);
			loginPage.clickLoginButton();
			return new MainPage(getDriver());
		}
		public static String getLoginName(String name,String passwd){
			return LoginSuccess(name,passwd).getUserName();
		}	
		
	//错误登录业务
		public static MainPage LoginFail(String name,String passwd){
			loginPage=new LoginPage(getDriver());
			loginPage.inputUserName(name);
			loginPage.inputPassword(passwd);
			loginPage.clickLoginButton();
			return new MainPage(getDriver());
		}
}
