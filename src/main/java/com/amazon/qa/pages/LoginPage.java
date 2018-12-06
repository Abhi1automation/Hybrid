package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.bases.Testbase;

public class LoginPage extends Testbase{

@FindBy(id="ap_email")
WebElement uname;

@FindBy(id="ap_password")
WebElement passw;

@FindBy(id="signInSubmit")
WebElement loginbutton;

public LoginPage(){
	
	PageFactory.initElements(driver, this);
}

public String getTitle(){
	
	String title = driver.getTitle();
	return title;
}

public HomePage Login(String un, String pwd){
	
	uname.sendKeys(un);
	passw.sendKeys(pwd);
	loginbutton.click();
	return new HomePage();
			
}
	
	
}
