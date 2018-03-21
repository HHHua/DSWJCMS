package com.lbl.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementOperate {

	public static void main(String[] args){
		//利用cookie绕过登录验证码
		//1.删除cookie内容
//		dr.manage().deleteAllCookies();
//		Cookie ck=new Cookie("PHPSESSID","817otcrs4ngglstqts6tq8ndi7");
//		dr.manage().addCookie(ck);
		
	}

	//打开浏览器
	public static WebDriver openWeb(WebDriver dr,String url){
		//指定驱动路径
		System.setProperty("webdriver.chrome.driver", "G:\\newdream\\000\\Google\\Chrome\\Application\\chromedriver.exe");
		//新建一个chrome浏览器
		dr=new ChromeDriver();
		//获取网址
		dr.get(url);
		//浏览器最大化
		dr.manage().window().maximize();
		//设置页面隐式等待时间为30s
		dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//强制等待3s
		wait(3);
		//返回驱动，保持连接
		return dr;
	}
	
	//登录系统
	public static WebDriver login(WebDriver dr,String account,String password){
		//点击登录按钮
		dr.findElement(By.cssSelector("body > header > div > div > div.info.span6 > a:nth-child(1)")).click();
		//输入用户名
		dr.findElement(By.cssSelector("input[name='username']")).sendKeys(account);
		//输入密码
		dr.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		//点击验证码
		dr.findElement(By.cssSelector("input#CaptchaInputText")).click();
		//等待8秒
		wait(8);
		//点击验证码输入框
		dr.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/form/div/button")).click();
		wait(3);
		return dr;
	}
	
	//线下充值
	public static WebDriver offlinePay(WebDriver dr){
		dr.findElement(By.cssSelector("#content > div > div > div > a.btn.btn-warning")).click();
		dr.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(2) > td.form-inline.fund_audit > div.offline > label:nth-child(2)")).click();
		dr.findElement(By.cssSelector("#content > form > table > tbody > tr.offline > td:nth-child(2) > input[type='text']")).sendKeys("33103333333333333333333");
		dr.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > div > input")).sendKeys("500");
		dr.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > input")).click();
		wait(8);
		dr.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(6) > td:nth-child(2) > button")).click();
		wait(3);
		return dr;
	}
	
	
	//撤销充值
	public static WebDriver offlinePayBack(WebDriver dr){
		dr.findElement(By.cssSelector("#table > tbody > tr:nth-child(1) > td:nth-child(8) > a")).click();
		wait(3);
		return dr;
	}
	
	//退出浏览器
	private static void logOut(WebDriver driver) {
		driver.quit();
	}
	
	public static void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
