package testScripts.MyAccount.Registration;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_002 extends TestBase{
	
	@Test(description = "Registration with existing Email-id")
	public void TC002_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with existing Email-id started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().registerWithAlreadyExistingEmail("test@test.com", "AkashSrivastava@1234567890");
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with existing Email-id finished");
	}

}
