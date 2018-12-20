package testScripts.homePage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import testBase.TestBase;

public class TC_006 extends TestBase{
	
	@Test(description = "HomePage - Arrivals - Images - Add to Basket")
	public void TC006_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying HomePage - Arrivals - Images - Add to Basket started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickOnHomeLink().getArrivalsCount();
		homePage.gotoProduct("Selenium Ruby");
		ProductDetailPage pdp = new ProductDetailPage(driver);
		pdp.verifyArrivalImageCheck("Selenium Ruby");
		pdp.addToBakset("500.00").viewBasket("500.00");
		TestBase.test.log(Status.INFO, "Test case for verifying HomePage - Arrivals - Images - Add to Basket ended");
	}


}
