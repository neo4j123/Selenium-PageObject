package testScripts.shop;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_005 extends TestBase {

	@Test(description = "Shop-Default Sorting Functionality by Newness ratings")
	public void TC005_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO,
				"Test case for verifying Shop-Default Sorting Functionality by Newness ratings started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().sortingByNewnessRating();
		TestBase.test.log(Status.INFO,
				"Test case for verifying Shop-Default Sorting Functionality by Newness ratings finished");
	}

}
