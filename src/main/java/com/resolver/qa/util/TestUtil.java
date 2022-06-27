package com.resolver.qa.util;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resolver.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	
	public static void javascriptExcuterClick(WebElement ele) {
		JavascriptExecutor j=(JavascriptExecutor) dr;
		j.executeScript("arguments[0].click();",ele);
	}
	
	public static String getTextValueByJs(WebElement ele) {
		JavascriptExecutor j=(JavascriptExecutor) dr;
		String title=j.executeScript("return document.getElementById('dropdownMenuButton').innerText").toString();
		return title;
		
	}
	
	//it is wait until element is visible
		public static void waitForElementVisible(WebElement ele) {
			WebDriverWait wait=new WebDriverWait(dr,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	
	

	
}
