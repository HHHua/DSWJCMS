package com.lbl.pages;

import org.openqa.selenium.WebDriver;

import com.lbl.config.LocalConfig;
import com.lbl.baseframe.Locator;
import com.lbl.baseframe.BasePage;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver dr){
		super(dr);
		openUrl(LocalConfig.URL);//继承
//		openUrl("http://192.168.0.60/");
	}
	Locator goLoginBotton=getLocator("goLoginBotton");
	Locator usernameInputBox=getLocator("usernameInputBox");
	Locator passwordInputBox=getLocator("passwordInputBox");
	Locator loginBotton=getLocator("loginBotton");
	//page类中存放基本操作
	public void goLogin(){
		click(goLoginBotton);
	}
	
	public void inputUserName(String name){
		input(usernameInputBox,name);
	}
		
	public void inputPassword(String password){
		input(passwordInputBox,password);
	}
	
	public void clickLoginButton(){
		click(loginBotton);
	}
}
