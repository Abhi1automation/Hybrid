package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.bases.Testbase;

public class SignInPage extends Testbase{
	
	@FindBy(id="nav-link-accountList")
	WebElement signinbutton;
	
	//Initialize Page Objects
	public SignInPage(){
		
		PageFactory.initElements(driver, this);
	}

	
	//Actions
   public LoginPage clickSignIn(){
	   signinbutton.click();
	   return new LoginPage();
   }
	
}
