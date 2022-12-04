package com.XYZBank.testscripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.XYZBank.datareaders.DataProviders;
import com.XYZBank.testbase.TestBase;
import com.XYZBank.testpages.BankManagerLoginPage;
import com.XYZBank.testpages.HomePage;

public class BankManagerLoginPageTest extends TestBase {
	
	
	@Test(enabled=true, dataProviderClass=DataProviders.class,dataProvider="CommonDataProvider")
	public void addACustomer(String fname, String Lname, String Pcode) throws InterruptedException
	{
		openBrowser();
        HomePage homepage = new HomePage(driver);
		
		//Thread.sleep(3000);
		BankManagerLoginPage bankManagerPage =  homepage.clickBankManagetLoginBtn();
		
		//Thread.sleep(3000);
		bankManagerPage.clickAddCustomerBtn();
		
		//Thread.sleep(3000);
		bankManagerPage.addCustomer(fname,Lname, Pcode );
		Alert alert = driver.switchTo().alert();
		
		String expectedMessage = "Customer added successfully with customer id ";
		
		String actualMessage  = alert.getText();
		
		String str[] = actualMessage.split(":");
		
		Assert.assertEquals(str[0], expectedMessage);
		
		
		alert.accept();
		
		
	}
	

	
	
	

}
