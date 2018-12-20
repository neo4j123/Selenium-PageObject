package helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class VerificationHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to check whether element is displayed *
	 * 
	 * @param element
	 * @return
	 */
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is present" +element.getText());			
			return true;
		} catch (Exception e) {
			log.error("Element is not displayed", e.getCause());
			return false;
		}
	}

	/**
	 * This method is used to verify that element is not displayed *
	 * 
	 * @param element
	 * @return
	 */
	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is not present");
			;
			return false;
		} catch (Exception e) {
			log.error("Element is not displayed", e.getCause());
			return true;
		}
	}

	/**
	 * This method will get the text of an Webelement
	 * 
	 * @param element
	 * @return
	 */
	public String getTextFromElement(WebElement element) {
		if (null == element) {
			log.info("Webelement is NULL");
			return null;
		}
		boolean status = isDisplayed(element);
		if (status) {
			log.info("Element's text is " + element.getText());
			return element.getText();
		} else {
			log.info("Element text is not found");
			return null;
		}
	}

	/**
	 * This metthod returns the webpage title
	 * 
	 * @return
	 */
	public String getTitle() {
		log.info("Getting the webpage title");
		return driver.getTitle();

	}

}
