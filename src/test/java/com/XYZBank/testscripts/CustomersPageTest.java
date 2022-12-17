package com.XYZBank.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.XYZBank.testbase.TestBase;
import com.XYZBank.testpages.BankManagerLoginPage;
import com.XYZBank.testpages.HomePage;

public class CustomersPageTest extends TestBase {
	
	String expectedFName = "Bidya";
	
	@Test(enabled=true)
	public void DeleteCustomer() throws InterruptedException
	{
		openBrowser();
		logInfo("Browser Opened");
		HomePage homepage = new HomePage(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankManagerLoginPage  bankManagerLoginPage = homepage.clickBankManagetLoginBtn();
		
		logInfo("Clicked on Bank ManagerLogin Button");
		
		bankManagerLoginPage.clickCustomersBtn();
		
		logInfo("Clicked on Cusotmers Button");
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr"));
		
		for(int i=1;i<=list.size();i++)
		{
			String actualfName = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[1]")).getText();
			
			if(expectedFName.equals(actualfName))
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[5]/button")).click();
				break;
			}
		}
		
		logInfo("Expected customer "+expectedFName+" is deleted successfully!!!");
		
	}

}
