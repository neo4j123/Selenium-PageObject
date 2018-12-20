package testScripts.MyAccount.Login;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_005 extends TestBase{
	
	@Test(description = "Login with blank username and password")
	public void TC005_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Login with blank username and password started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().blankUsernamePassword();
		TestBase.test.log(Status.INFO, "Test case for verifying Login with blank username and password finished");
	}

}
