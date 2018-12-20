package testScripts.MyAccount.Registration;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_004 extends TestBase{
	
	@Test(description = "Registration with empty password")
	public void TC004_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with empty password started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().registerWithEmptyPassword("aloha@test.com");
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with empty password finished");
	}

}
