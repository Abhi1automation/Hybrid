package com.amazon.qa.bases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Testbase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase(){
		
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/Abhi/workspace/HybridFramework/src/main/java/com/amazon/qa/config/config.properties");
			prop.load(ip);
	
		}
		
		catch(FileNotFoundException f){
			f.printStackTrace();
		}catch(IOException i){
			i.printStackTrace();
		}	
			
		}
	
	public static void initialization(){
		
		String browserName= prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

}
