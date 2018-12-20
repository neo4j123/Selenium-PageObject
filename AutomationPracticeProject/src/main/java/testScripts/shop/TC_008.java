package testScripts.shop;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import objectRepository.ShopPage_OR;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_008 extends TestBase{
	
	@Test(description = "Shop-Default Sorting Functionality by Prices Low to High")
	public void TC008_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO,
				"Test case for verifying Shop Page out of stock verification started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().checkOutOfStockOption(ShopPage_OR.OUT_OF_STOCK_TEXT);;
		TestBase.test.log(Status.INFO,
				"Test case for verifying Shop Page out of stock verification finished");
	}

}
