package com.XYZBank.testpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OpenAccountPage extends Basepage{

	public OpenAccountPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		//driverIntitialization(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElements
	
	@FindBy(xpath="//select[@id='userSelect']")
	WebElement custDropdown;
	
	@FindBy(xpath="//select[@id='currency']")
	WebElement currencyDropdown;
	
	@FindBy(xpath="//button[text()='Process']")
	WebElement processBtn;
	
	
	public void openCustomerAccount(String customerName,String currency)
	{
		selectDropdownValueByText(custDropdown,customerName);
		selectDropdownValueByText(currencyDropdown,currency);
		processBtn.click();
		
		
		
		
		
	}

}
