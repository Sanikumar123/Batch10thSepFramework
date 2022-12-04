package com.XYZBank.testpages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage  {
	
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    Select drop;
    Actions action;
	
	
	
	public  Basepage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	

	
	public void waitForPageToLoad(WebElement element) {
		

		
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void click(WebElement element) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}
		element.click();

	}

	public void type(WebElement element, String text) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		element.sendKeys(text);

	}

	public void switchToAlert() {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert = driver.switchTo().alert();

	}

	public void typeTextToAlert(String text) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert.sendKeys(text);

	}

	public void acceptAlert() {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert.accept();

	}

	public void dismissAlert() {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert.dismiss();

	}

	public void selectDropdownValueByText(WebElement element, String dropValue) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		drop = new Select(element);
		drop.selectByVisibleText(dropValue);

	}

	public void selectDropdownValueByIndex(WebElement element, int index) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		drop = new Select(element);
		drop.selectByIndex(index);

	}

	public void selectDropdownValueByValue(WebElement element, String value) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		drop = new Select(element);
		drop.selectByValue(value);

	}

	public void switchToFrameByFrameName(String frameName) {

		wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void switchToFrameByFrameIndex(int index) {

		wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void switchToFrameByFrameLocator(WebElement element) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void dragAndDrop(WebElement source, WebElement dest) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOf(source));
			wait.until(ExpectedConditions.visibilityOf(dest));
		} catch (Exception e) {
			System.out.println(e);
		}

		action = new Actions(driver);
		action.dragAndDrop(source, dest).perform();

	}

	public void moveToElement(WebElement element) {

		//wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			System.out.println(e);
		}

		action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void switchToTab(int index) {

		Set<String> tabs = driver.getWindowHandles();

		ArrayList<String> tabindex = new ArrayList<String>(tabs);

		driver.switchTo().window(tabindex.get(index));

	}


}
