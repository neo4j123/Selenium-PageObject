package testScripts.homePage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.BasketPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import testBase.TestBase;

public class TC_009 extends TestBase{
	
	@Test(description = "Home-Arrivals-Add to Basket-Items-Coupon")
	public void TC009_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying Home-Arrivals-Add to Basket-Items-Coupon started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().clickOnHomeLink().getArrivalsCount();
		homePage.gotoProduct("Selenium Ruby");
		ProductDetailPage pdp = new ProductDetailPage(driver);		
		pdp.verifyArrivalImageCheck("Selenium Ruby");
		pdp.addToBakset("500.00").viewBasket("500.00");	
		BasketPage bp = new BasketPage(driver);
		bp.addCoupon("krishnasakinala");
		TestBase.test.log(Status.INFO, "Test case for verifying Home-Arrivals-Add to Basket-Items-Coupon ended");
	}


}
