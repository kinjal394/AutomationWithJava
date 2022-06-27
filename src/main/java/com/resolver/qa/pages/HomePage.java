package com.resolver.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resolver.qa.base.TestBase;
import com.resolver.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath="//input[@id='inputEmail']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='inputPassword']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signin;
	
	@FindBy(css = "[class='list-group'] li")
	List<WebElement> listItem;

	
	@FindBy(css="[class=\"list-group\"]>li:nth-child(2)")
	WebElement listItem2;
	
	@FindBy(css="[class=\"list-group\"]>li:nth-child(2)>span")
	WebElement badgeItem2;
	 
	@FindBy(xpath = "//button[@id='dropdownMenuButton']") //dropdownMenuButton
	WebElement option1;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][3]")
	WebElement option3;
	
	@FindBy(xpath = "//*[@id=\"test-4-div\"]/descendant::button[1]")
	WebElement enabledButton;
	
	@FindBy(xpath = "//*[@id=\"test-4-div\"]/descendant::button[2]")
	WebElement disabledButton;
	
	@FindBy(xpath = "//button[@id='test5-button']")
	WebElement button5;
	
	@FindBy(xpath = "//*[@id='test5-alert']")
	WebElement test5Text;
	
	//*[@class='table table-bordered table-dark']/descendant::tr[2] ----- row
	//*[@class='table table-bordered table-dark']/descendant::tr[2]/descendant::td[1] --- cell
	
	
	
	//Initializing the page objects 
	public HomePage() {
		PageFactory.initElements(dr, this);
		//this means current class object 
	}
	
	public String getTitile() {
		
		return dr.getTitle();
		
	}
	
	public boolean verifyEmail() {
		return emailId.isDisplayed();
	}
	
	public boolean verifyPassword() {
		return password.isDisplayed();
	}
	
	public boolean verifySignin() {
		return signin.isDisplayed();
	}
	public void loginToApp(String username,String pass) {
		emailId.sendKeys(username);
		password.sendKeys(pass);
		signin.click();
		
	}
	
	public List<WebElement> verifyListSize() {
	      return listItem;
	    }  
	
	
	
	public String verifyListItem2() {
		return listItem2.getText().trim();
	}
	
	public int verifyBadgevalue() {
		int val=Integer.parseInt(badgeItem2.getText());
		 return val;
	}
	
	public String verifyOption1Text() {
		String val=TestUtil.getTextValueByJs(option1);
		return val;
	}
	
	public void clickOption1() {
		TestUtil.javascriptExcuterClick(option1);
		
	}
	
	public void clickOnOption3() {
		TestUtil.javascriptExcuterClick(option3);
	}
	
	public boolean verifyEnabledButton() {
		return enabledButton.isEnabled();
	}
	
	
	public boolean verifyDisabledButton() {
		return disabledButton.isEnabled();
	}
	
	public boolean verifyBtn5Display() {
		TestUtil.waitForElementVisible(button5);
		return button5.isDisplayed();
	}
	
	public void clickBtn5Display() {
		button5.click();;
	}
	
	public String verifyTest5Alert() {
		return test5Text.getText();
	}
	
	public boolean verifyDisabledBtn5() {
		return button5.isEnabled();
	}
	
	public String getDataTable() {
		String s=null;
		 int row = dr.findElements(By.xpath("//*[@class='table table-bordered table-dark']/descendant::tr")).size();
		 int cell=dr.findElements(By.xpath("//*[@class='table table-bordered table-dark']/descendant::tr[2]/descendant::td")).size();
		 
		 for(int i=2;i<=row;i++) {
				for(int j=1;j<=cell;j++) {
					
					//dr.findElement(By.xpath("//*[@class='table table-bordered table-dark']/descendant::tr["+i+"]/descendant::td["+j+"]")).getText();
					if(i==4 && j==3) {
						s=dr.findElement(By.xpath("//*[@class='table table-bordered table-dark']/descendant::tr["+i+"]/descendant::td["+j+"]")).getText();
					}
				}
			
			}
		return s;
		
		
	}
}


