package com.actitime123.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
static {
	System.setProperty("webdriver.chrome.driver", "E:\\eclipse java program\\actitime123\\src\\main\\resources\\driver\\chromedriver.exe");
}
public WebDriver driver;
@BeforeTest
public void openBrowser() {
	Reporter.log("openbrowser",true);
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
@AfterTest
public void closewBrowser() {
	Reporter.log("closebrowser",true);
	driver.close();
}
@BeforeMethod
public void login() {
	Reporter.log("login",true);
	driver.get("https://demo.actitime.com/");
	driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("pwd")).sendKeys("manager");
    driver.findElement(By.xpath("//div[.='Login ']")).click();
}
@AfterMethod
public void logout() {
	Reporter.log("logout",true);
	driver.findElement(By.id("logoutLink")).click();
}
}
