package testScripts.MyAccount.Login;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_003 extends TestBase{
	
	@Test(description = "Login with correct username and blank password")
	public void TC003_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying login with correct username and blank password started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().correctEmailBlankPassword("akash.srivastava");
		TestBase.test.log(Status.INFO, "Test case for verifying login with correct username and blank password finished");
	}

}
