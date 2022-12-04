package com.XYZBank.testscripts;

import org.testng.annotations.Test;

import com.XYZBank.testbase.TestBase;
import com.XYZBank.testpages.BankManagerLoginPage;
import com.XYZBank.testpages.HomePage;

public class HomePageTest extends TestBase {
	
	
	@Test(enabled=true)
	public void bankManagerLoginBtn()
	{
		openBrowser();
		HomePage homepage = new HomePage(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankManagerLoginPage  bankManagerLoginPage = homepage.clickBankManagetLoginBtn();
	}
	
	
	
	
	
	

}
 