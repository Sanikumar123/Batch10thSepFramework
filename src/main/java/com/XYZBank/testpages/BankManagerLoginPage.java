package com.XYZBank.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerLoginPage extends Basepage {
	
	WebDriver driver;
	
	public BankManagerLoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElements
		@FindBy(xpath="//button[@ng-click='addCust()']")
		WebElement addCustBtn;
		
		@FindBy(xpath="//button[@ng-click='openAccount()']")
		WebElement openAccountBtn;
		
		@FindBy(xpath="//button[@ng-click='showCust()']")
		WebElement custBtn;
		
		
		//WebElments - BankManager - Add Customer Page
		@FindBy(xpath="//*[@ng-model='fName']")
		WebElement fName;
		
		@FindBy(xpath="//*[@ng-model='lName']")
		WebElement lName;
		
		@FindBy(xpath="//*[@ng-model='postCd']")
		WebElement postCode; 
		
		
		@FindBy(xpath="//*[text()='Add Customer']")
		WebElement addCustomer;
		
		
		public void clickAddCustomerBtn()
		{
			addCustBtn.click();
		}
		
		         //Add Customer
				public void addCustomer(String fname, String lname, String pCode)
				{
					//fName.sendKeys(fname);
					//lName.sendKeys(lname);
					//postCode.sendKeys(pCode);
					//addCustomer.click();
					type(fName,fname);
					type(lName,lname);
					type(postCode,pCode);
					click(addCustomer);
					
				}

}
