package testScripts.MyAccount.Login;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_004 extends TestBase{
	
	@Test(description = "Login with blank username and valid password")
	public void TC004_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying login blank username and valid password started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().emptyUsernameValidPassword("AkashSrivastava@1234567890");
		TestBase.test.log(Status.INFO, "Test case for verifying login with blank username and valid password finished");
	}


}
