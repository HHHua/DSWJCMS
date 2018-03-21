package com.lbl.pages;

import org.openqa.selenium.WebDriver;

import com.lbl.baseframe.BasePage;
import com.lbl.baseframe.Locator;

public class MainPage extends BasePage {
	public MainPage(WebDriver dr){
		super(dr);
	}
	Locator payBotton=getLocator("PayBotton");
	Locator offLinePay=getLocator("offLinePay");
	Locator accountInputBox=getLocator("accountInputBox");
	Locator moneyInputBox=getLocator("MoneyInputBox");
	Locator mNumInputbox=getLocator("mNumInputbox");
	Locator submitBotton=getLocator("submitBotton");
	Locator userMenu=getLocator("userMenu");

	public void clickPayButton(){
		click(payBotton);
	}
	
	public void clickoffLinePay(){
		click(offLinePay);
	}
	public void inputAccount(String account){
		input(accountInputBox,account);
	}
	public void inputMoney(String money){
		input(moneyInputBox,money);
	}
	public void clickmNumInputbox(){
		click(mNumInputbox);
	}
	public void clicksubmitBotton(){
		click(submitBotton);
	}
	public String getUserName(){
		return getText(userMenu);
	}
}
