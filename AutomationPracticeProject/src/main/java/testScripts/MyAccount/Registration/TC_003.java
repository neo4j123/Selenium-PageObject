package testScripts.MyAccount.Registration;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import helper.browserConfig.ObjectReader;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_003 extends TestBase{
	
	@Test(description = "Registration with empty Email-id")
	public void TC003_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with empty Email-id started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().registerWithEmptyEmail("AkashSrivastava@1234567890");
		TestBase.test.log(Status.INFO, "Test case for verifying Registration with empty Email-id finished");
	}

}
