package testScripts.MyAccount.Registration;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.browserConfig.ObjectReader;
import helper.generic.RandomTestDataGenerator;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_001 extends TestBase {

	@Test(description = "Registration-Sign-in")
	public void TC001_test() throws IOException, InterruptedException {
		TestBase.test.log(Status.INFO, "Test case for verifying Registration-Sign-in started");
		getApplicationUrl(ObjectReader.reader.getUrl());
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToMyAccountPage().registerWithEmailAndPassword(RandomTestDataGenerator.email,
				RandomTestDataGenerator.password);
		TestBase.test.log(Status.INFO, "Test case for verifying Registration-Sign-in finished");
	}

}
