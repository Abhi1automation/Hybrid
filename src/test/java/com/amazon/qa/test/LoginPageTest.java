package com.amazon.qa.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.bases.Testbase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SignInPage;

public class LoginPageTest extends Testbase{
	
	SignInPage signinpage;
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException{
		
		super();
	}
	
	@BeforeMethod
	public void setup()throws IOException{
		
		initialization();
		signinpage = new SignInPage();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void Signin(){
		loginpage=signinpage.clickSignIn();
		
	}
	
	@Test(priority=2)
	public void validateTitle(){
		String pgtitle= loginpage.getTitle();
		Assert.assertEquals(pgtitle, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");	
	}
	
	@Test(priority=3)
	public void Login(){
		loginpage=signinpage.clickSignIn();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}

}
