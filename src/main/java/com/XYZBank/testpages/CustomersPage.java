package com.XYZBank.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Basepage {

	public CustomersPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		//driverIntitialization(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElements
	@FindBy(xpath="//input[@ng-model='searchCustomer']")
	WebElement searchCustomer;
	
	
	
	

}
