package com.XYZBank.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.XYZBank.extentlisteners.ExtentListeners;
import com.XYZBank.utility.Constants;
import com.XYZBank.utility.DriverFactory;


public class TestBase {
	
	public static WebDriver driver = null;
	static Properties  config = new Properties();
	FileInputStream fin;
	
	
	@BeforeSuite
	public void frameworkSetUp()
	{
		
		DriverFactory.setConfigPropertyFile(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.prop");
		DriverFactory.setChromeDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\driverexecutables\\chromedriver.exe");
		DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
		
		
		try {
			fin = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set up hub location
		DriverFactory.setGridPath(config.getProperty("huburl"));
		
		
		
		}
	
	public void logInfo(String message) {
		ExtentListeners.testReport.get().info(message);
	}
	
	
	public void openBrowser()
	{
		DriverFactory.setRemote(Constants.REMOTE_STATUS);

		if (DriverFactory.isRemote()) {
			DesiredCapabilities cap = null;

			if (config.getProperty("browser").equals("chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (config.getProperty("browser").equals("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			}

			try {
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

			else if (config.getProperty("browser").equals("chrome")) {

					// Driver location
					System.setProperty("webdriver.chrome.driver",
						DriverFactory.getChromeDriverExePath());

					// open a chrome browser
					
					driver = new ChromeDriver();
				} else if (config.getProperty("browser").equals("firefox")) {
					// Driver location
					System.setProperty("webdriver.firefox.driver",
							DriverFactory.getGeckoDriverExePath());

					// open a chrome browser
					driver = new FirefoxDriver();
				}
		
		
		//open testurl
		driver.manage().window().maximize();// maximize the browser
		
		// launch testurl
		driver.get(config.getProperty("testurl"));// open the URL in the
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_TIME, TimeUnit.SECONDS);

	
	}
	
	
	
	
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
	}

}
