package testScripts.shop;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_009 extends TestBase {

	@Test(description = "Shop Sale Price and Actual Price Verification Functionality")
	public void TC008_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO,
				"Test case for verifying Shop Sale Price and Actual Price Verification Functionality started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().checkSaleAndNormalPrices();
		TestBase.test.log(Status.INFO,
				"Test case for verifying Shop Sale Price and Actual Price Verification Functionality finished");
	}

}
