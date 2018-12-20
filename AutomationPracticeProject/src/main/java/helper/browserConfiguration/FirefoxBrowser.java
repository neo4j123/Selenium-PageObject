package helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import helper.resource.ResourceHelper;

public class FirefoxBrowser {

	public FirefoxOptions getFirefoxOptions() {

		DesiredCapabilities firefox = new DesiredCapabilities();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);

		FirefoxOptions firefoxOptions = new FirefoxOptions();
		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			firefoxOptions.addArguments("--headless", "windows-size=1024,768", "--no-sandbox");
		}
		return firefoxOptions;

	}

	public WebDriver getFirefoxDriver(FirefoxOptions cap) {
		if (System.getProperty("os.name").contains("mac")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("\\src\\main\\resources\\drivers\\geckodriver"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("\\src\\main\\resources\\drivers\\geckodriver.exe"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("\\src\\main\\resources\\drivers\\geckodriver.exe"));
			return new FirefoxDriver(cap);
		}
		return null;
	}
}
