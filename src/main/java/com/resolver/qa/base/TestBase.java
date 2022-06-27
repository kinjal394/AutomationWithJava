package com.resolver.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver dr;
	public static Properties pro;
	
	public TestBase(){
		try {
			
			String path="./src/main/java/com/resolver/qa/config/config.properties";
			FileInputStream file=new FileInputStream(new File(path));
			pro=new Properties();
			pro.load(file);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	public static void initialization() {
		String browserName = pro.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			dr=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			dr=new FirefoxDriver();
		}

        dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
		
		dr.get(pro.getProperty("url"));
	}
}
