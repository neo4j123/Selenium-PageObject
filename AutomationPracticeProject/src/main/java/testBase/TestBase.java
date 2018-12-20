package testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import helper.browserConfig.PropertyReader;
import helper.browserConfiguration.BrowserType;
import helper.browserConfiguration.ChromeBrowser;
import helper.browserConfiguration.FirefoxBrowser;
import helper.browserConfiguration.IEBrowser;
import helper.excel.ExcelHelper;
import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;
import helper.wait.WaitHelper;
import utils.ExtentHelper;

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectory;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentHelper.getInstance();
	}

	// We are getting class name to be printed on the reports
	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getSimpleName());
	}

	// We are initialising data on runtime
	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResourceHelper.getResourcePath("\\src\\main\\resources\\screenshot"));
		setUpDriver(ObjectReader.reader.getBrowserType());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName()+"**************test started***************");
		log.info("**************"+method.getName()+"Started***************");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is passed");
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************"+result.getName()+"Finished***************");
		extent.flush();
	}

	@AfterTest
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * This method is used for invoking different browsers
	 * 
	 * @param browserType
	 * @return
	 * @throws Exception
	 */
	public WebDriver getBrowserObject(BrowserType browserType) throws Exception {
		try {
			switch (browserType) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeOptions());

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxOptions());

			case IExplorer:
				IEBrowser iExplorer = IEBrowser.class.newInstance();
				return iExplorer.getExplorerDriver(iExplorer.getInternetExplorerCapabilities());

			default:
				throw new Exception("Driver not found: " + browserType.name());
			}

		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	public void setUpDriver(BrowserType browserType) throws Exception {
		driver = getBrowserObject(browserType);
		log.info("Driver is initialized");
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String captureScreen(String fileName, WebDriver driver) {
		if (driver == null) {
			log.info("Driver is null");
			return null;
		}
		if (fileName == "") {
			fileName = "navigation_pages";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("DD_MM-YYYY_HH_MM-SS");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectory + "/" + fileName + "_" + formatter.format(calendar.getTime()) + ".png");
			Files.copy(scrFile.toPath(), destFile.toPath());
			log.info("Screenshot has been captured");
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/></a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	public void getNavigationScreen(WebDriver driver) throws IOException {
		log.info("Capturing ui navigation screens.....");
		String screen = captureScreen("", driver);
		test.addScreenCaptureFromPath(screen);
	}

	public void getApplicationUrl(String url) {
		driver.get(url);
		log.info("Getting Application url..." + url);
	}

	public Object[][] getExcelData(String excelName, String sheetName) {
		String excelLocaton = ResourceHelper.getResourcePath("src\\main\\resources\\testData\\")+excelName;
		log.info("Excel Location found");
		ExcelHelper excel = new ExcelHelper();
		Object[][] data = excel.getExcelData(excelLocaton, sheetName);
		return data;
	}
}
