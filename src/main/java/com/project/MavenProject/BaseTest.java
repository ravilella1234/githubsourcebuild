package com.project.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static String configPath=projectPath+"//config.properties";
	public static String orPath=projectPath+"//or.properties";
	public static String logpath=projectPath+"//log4j.properties";
	public static Properties p;
	public static Properties or;
	public static String screenshotFileName=null;
	
	
	static
	{
		Date dt=new Date();
		screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
	}
	
	
	public static ExtentReports report=ExtentManager.getInstance();
	public static ExtentTest test;
	
	public static void loadData() throws Exception
	{
		FileInputStream fis=new FileInputStream(configPath);
		p=new Properties();
		p.load(fis);
		
		FileInputStream fis1=new FileInputStream(orPath);
		or=new Properties();
		or.load(fis1);
		
		PropertyConfigurator.configure(logpath);
		
	}
	
	
	public static void launch(String browser)
	{
		if(browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
			
			//logs
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
			
			ChromeOptions option=new ChromeOptions();
			
			//PageLoad Strategy
			option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			//user defined profile
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			
			//Browser Notifications
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			
			//option.addArguments("--proxy-server=http://192.168.90.84:1234");
			
			
			driver=new ChromeDriver(option);
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			
			
			FirefoxOptions option=new FirefoxOptions();
			option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("sai");
			
			
			//notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//proxy servers
			/*profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.90.54");
			profile.setPreference("network.proxy.socks_port", 1744);*/
			
			option.setProfile(profile);
			
			
			driver=new FirefoxDriver(option);
			
		}
		else if(browser.equalsIgnoreCase("ie")) 
		{
			//logs
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "D:\\IE.log");
			
			InternetExplorerOptions option=new InternetExplorerOptions();
			
			//proxy servers
			DesiredCapabilities cap=new DesiredCapabilities();
			
			String proxy="80.200.90.81:4444";
			Proxy p =new Proxy();
			p.setAutodetect(false);
			p.setProxyType(p.getProxyType());
			p.setSocksProxy(proxy);
			cap.setCapability(CapabilityType.PROXY, p);
			option.merge(cap);
			
			driver=new InternetExplorerDriver(option);
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{
			//logs
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "null");
				
			driver=new EdgeDriver();
		}
		
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(p.getProperty(url));
		//implicit Wait
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	
	public static void selectItem(String locatorKey, String item)
	{
		getElement(locatorKey).sendKeys(or.getProperty(item));
		//driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(or.getProperty(item));
	}
	
	
	public static void type(String locatorKey, String value)
	{
		getElement(locatorKey).sendKeys(or.getProperty(value));
		//driver.findElement(By.name(or.getProperty(locatorKey))).sendKeys(or.getProperty(value));
	}
	
	
	public static void click(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
	}	
	
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		return element;
	
	}
	
	
	
	//*************************** Verification Methods *************************************
	
	public static boolean verifyTitle(String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(or.getProperty(expectedTitle)))
			return true;
		else
			return false;	
	}
	
	
	public static boolean verifyText(String locatorKey, String expectedText) 
	{
		String actualText = getElement(locatorKey).getText().trim();
		
		if(actualText.equals(or.getProperty(expectedText)))
			return true;
		else
			return false;
	}
	
	
	//*************************** Reporting Methods *************************************
	
	public static void reportPass(String msg) 
	{
		test.log(LogStatus.PASS, msg);		
	}

	public static void reportFail(String msg) 
	{
		test.log(LogStatus.FAIL, msg);
		takeScreenShot();
	}


	public static void takeScreenShot() 
	{
		Date dt=new Date();
		String screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File(projectPath+"//failure//"+screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//put screen shot file in extent reports
		test.log(LogStatus.INFO, "Screenshot --> "+ test.addScreenCapture(projectPath+"//failure//"+screenshotFileName));
	}

	
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	
	public int randomNumber() 
	{
		Random r=new Random();
		int ranNum = r.nextInt(99999);
		return ranNum;
	}
	
	public void waitForElement(WebElement locator,int timeInSeconds,String operationType)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, timeInSeconds);
		
		if(operationType.equals("elementToClick")){
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}else if(operationType.equals("elementToVisible")) {
			wait.until(ExpectedConditions.visibilityOf(locator));
		}
		
		
	}
	
	
}
