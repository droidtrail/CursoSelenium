package br.ce.wcaquino.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {

	}

	public static WebDriver getDriver() {

		if (driver == null) {
			
			switch (Propriedades.browser) {
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver",
						"e:\\GeckoDriver\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case CHROME: 
				System.setProperty("webdriver.chrome.driver",
						"E:\\ChromeDriver_win32\\chromedriver.exe");
				driver  = new ChromeDriver();
				break;
				
			case INTERNETEXPLORER: 
				System.setProperty("webdriver.ie.driver",
						"E:\\ieDriver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
				
			case EDGE: 
				System.setProperty("webdriver.edge.driver",
						"E:\\EdgeDriver\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				break;
		
			default:
				break;
			}
			
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void killDriver() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
