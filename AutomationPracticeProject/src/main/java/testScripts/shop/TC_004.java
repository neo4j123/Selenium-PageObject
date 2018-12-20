package testScripts.shop;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_004 extends TestBase{
	
	@Test(description = "Shop-Default Sorting Functionality by average rating")
	public void TC004_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Default Sorting Functionality by average rating started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().sortingByAverageRating();
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Default Sorting Functionality by average rating finished");
	}

}
