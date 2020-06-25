package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.testUtils.WebEventListener;



public class TestBase {

	public static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static Properties prop;
	public static WebElement element;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public FileInputStream fis=null;

	public TestBase() {
		String propPath=System.getProperty("user.dir")+"/src/main/resources/config.properties";
		prop = new Properties();
		try {
			fis = new FileInputStream((propPath));
			prop.load(fis);
			logger.info("loading config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		
		  String browsername = prop.getProperty("browser");
		  if (browsername.equalsIgnoreCase("Firefox")) { 
			  System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
			  driver = new FirefoxDriver();
		 
		 } else if (browsername.equalsIgnoreCase("Chrome")) {
		 System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		  driver = new ChromeDriver();
		 
		  }
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
