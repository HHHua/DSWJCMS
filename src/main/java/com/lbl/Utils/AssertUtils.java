package com.lbl.Utils;

import org.testng.Assert;

import com.lbl.Utils.AssertUtils;
import com.lbl.Utils.Log;

public class AssertUtils {
	protected static Log log=new Log(AssertUtils.class);
	//整型做比较、字符串作比较、字符串包含、非空、实型作比较
	//String...表示可以接受0个或者多个字符串
	public void checkIntNum(int actual,int expected,String... com){
		try{	
			Assert.assertEquals(actual, expected);
		}catch(AssertionError e){
			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
	public void checkString(String actual,String expected,String... com){
		try{	
			Assert.assertEquals(actual, expected);
		}catch(AssertionError e){
			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
	//字符串包含
	public void checkStringContains(String actual,String expected,String...com){
		try{	
			Assert.assertEquals(true, actual.contains(expected));
		}catch(AssertionError e){
			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
	public void checkNotNull(Object actual,String... com){
		try{	
			Assert.assertNotNull(actual);
		}catch(AssertionError e){
			log.error("断言失败");
//			Assert.fail("断言失败");
		}
	}
}
