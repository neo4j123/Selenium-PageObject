package testScripts.shop;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_003 extends TestBase{
	
	@Test(description = "Shop-Default Sorting Functionality")
	public void TC003_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Default Sorting Functionality started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnShopLink().sortingByPopularity();
		TestBase.test.log(Status.INFO, "Test case for verifying Shop-Default Sorting Functionality finished");
	}

}
