package com.lbl.baseframe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {
	private Actions action;

	public MouseUtils(WebDriver dr){
		action=new Actions(dr);
		
	}
	public void rightClick(WebElement e){
		action.contextClick(e).perform();
	}
	public void doubleClick(WebElement e){
		action.doubleClick(e).perform();
	}
	public void mouseHold(WebElement e){
		action.clickAndHold(e).perform();
	}
	public void Drop(WebElement e1,WebElement e2){
		action.dragAndDrop(e1, e2).perform();
	}
	public void mouseMove(WebElement e){
		action.moveToElement(e).perform();
	}
	public void clickHoldMove(WebElement e1,WebElement e2){
		action.clickAndHold(e1).moveToElement(e2).release();
	}
	 
}
