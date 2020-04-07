package com.crm.qa.base;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class TestBase {
	

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Turorials\\FreeCRMTest\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Turorials\\FreeCRMTest\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase(("ie"))) {
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Browsers\\IE_Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		/*e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, SECONDS);
	}


}
