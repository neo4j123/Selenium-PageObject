package testScripts.MyAccount.Registration;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_005 extends TestBase{
	
	@Test(description = "Registration with empty Email-id & password")
	public void TC005_test() throws IOException {
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with empty Email-id & password started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().registerWithEmptyEmailPassword();
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with empty Email-id & password finished");
	}

}
