package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.wait.WaitHelper;
import testBase.TestBase;

public class EditBillingAddressPage {

	private WebDriver driver;
	public WaitHelper wait;
	
	public EditBillingAddressPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new TestBase().getNavigationScreen(driver);
		wait = new WaitHelper(driver);

	}
	
	public void extentReportLog(String log) {
		TestBase.test.log(Status.INFO, log);
	}
}
