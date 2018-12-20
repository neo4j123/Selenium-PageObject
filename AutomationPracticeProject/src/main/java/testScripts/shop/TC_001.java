package testScripts.shop;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_001 extends TestBase{
	
	@Test(description = "Shop-Filter by price Functionality")
	public void TC001_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Filter by price Functionality started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().viewBookMinMaxPrice(150, 450);
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Filter by price Functionality finished");
	}

}
