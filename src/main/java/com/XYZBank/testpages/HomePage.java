package com.XYZBank.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Basepage  {
	
	 WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		//driverIntitialization(driver);
		PageFactory.initElements(driver, this);
	}
	

	
	//WebElements
	@FindBy(xpath="//button[@ng-click='customer()']")
	WebElement custLoginBtn;
	
	@FindBy(xpath="//button[@ng-click='manager()']")
	WebElement BankMngrLoginBtn;
	
	@FindBy(xpath="//button[@ng-click='home()']")
	WebElement HomeBtn;
	
	
	
	public BankManagerLoginPage clickBankManagetLoginBtn()
	{
		
		click(BankMngrLoginBtn);
		return new BankManagerLoginPage(driver);
	}
	
	

}
