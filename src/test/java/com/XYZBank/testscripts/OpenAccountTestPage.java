package com.XYZBank.testscripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.XYZBank.testbase.TestBase;
import com.XYZBank.testpages.BankManagerLoginPage;
import com.XYZBank.testpages.HomePage;
import com.XYZBank.testpages.OpenAccountPage;

public class OpenAccountTestPage extends TestBase {
	
	
	@Test(enabled=true)
	public void openCustomerAccount() throws InterruptedException
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
		
		logInfo("Clicked on BankManager Login Button");
		
		OpenAccountPage openAccountPage = 	bankManagerLoginPage.clickOpenAccountBtn();
		
		logInfo("Clicked on OpenAccount Button");
		
		openAccountPage.openCustomerAccount("Harry Potter", "Rupee");
		
		logInfo("Account created successfully!!");
		
		Alert alert = driver.switchTo().alert();
		
		logInfo("Swtiched to Alert");
		String actualResult = alert.getText();
		
        String str[] = actualResult.split(":");
		
		Assert.assertEquals(str[0], "Account created successfully with account Number ");
		
		logInfo("Expected and Actual matching successfully!!");
		
		alert.accept();
		
		

}
	
}
