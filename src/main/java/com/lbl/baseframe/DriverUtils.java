package com.lbl.baseframe;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.lbl.config.LocalConfig;
import com.lbl.Utils.Log;
import com.lbl.baseframe.DriverUtils;

public class DriverUtils {
	protected static WebDriver driver;
	protected static MouseUtils mouse;
	protected static KeyBoardUtils keyboard;
	protected static Log log=new Log(DriverUtils.class);
	
	public DriverUtils(WebDriver driver){
		driver=driver;
		mouse=new MouseUtils(driver);
		keyboard=new KeyBoardUtils(driver);
	}
	public static void openUrl(String url){
		//
		driver.get(url);
		log.info("打开网址");
	}
	public void back(){
		driver.navigate().back();
		log.info("返回上一页");
	}
	public void forward(){
		driver.navigate().forward();
		log.info("进入下一页");

	}
	public void refresh(){
		driver.navigate().refresh();
		log.info("刷新");

	}
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void takeScreenShot(String...pngName) throws IOException{
		String fileName;
		String filePath=LocalConfig.SCREENSHOTPATH;
		File file=new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		if(pngName.length==0){
			fileName="shotImage";
		}else{
			fileName=pngName[0];
		}
		SimpleDateFormat sf=new SimpleDateFormat("yyyy_MM_dd_HH");
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		String dateStr=sf.format(date);
		String path="\\"+filePath+"\\"+fileName+"_"+date+"\\"+dateStr;
		takeScreenShot(driver,path);
	}
	public  void takeScreenShot(WebDriver drivername, String path) {
		String currentPath=System.getProperty("user.dir");
		File scrFile=((TakesScreenshot)drivername).getScreenshotAs(null);
		File picFile=new File(currentPath+path);
		try {
			FileUtils.copyFile(scrFile,picFile);
			log.info("截图成功，图片保存路径为： "+currentPath+path);
		} catch (IOException e) {
			log.error("截图失败");
		}
		log.screenShotLog("截图："+scrFile, picFile);
	}	

}
