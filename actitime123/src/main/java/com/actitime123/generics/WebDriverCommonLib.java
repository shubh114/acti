package com.actitime123.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * generic class for webdriver
 * @author shubh
 *
 */
public class WebDriverCommonLib {
	/**
	 * generic method for implicit wait
	 * @param driver
	 */
public static void waitForElementToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
/**
 * generic method for explicit wait with visibility condition
 * @param driver
 * @param element
 */
public void waitForElementPresent(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * generic method for custom wait for contain title
 * @param driver
 * @param data
 */
public void waitForTitleContain(WebDriver driver,String data) {
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.titleContains(data));
}
/**
 * generic method for custom wait
 * @param element
 */
public void customWaitForElementPresent(WebElement element){
	int i=0;
	while(i<=100) {
		try {
			element.isDisplayed();
		break;
		}catch (Exception e) {
			i++;
		}
	}
}
/**
 * generic method for selecting the value using index
 * @param element
 * @param i
 */
public void selectElement(WebElement element,int i) {
	Select s=new Select(element);
	s.selectByIndex(i);
}
/**
 * generic method for selecting the value using text
 * @param element
 * @param text
 */
public void selectElement(WebElement element,String text) {
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
}