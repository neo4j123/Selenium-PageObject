package testScripts.shop;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_002 extends TestBase{
	
	@Test(description = "Shop-Product Categories Functionality")
	public void TC002_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Product Categories Functionality started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickProductCategoryFilter("JavaScript");
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Product Categories Functionality finished");
	}

}
