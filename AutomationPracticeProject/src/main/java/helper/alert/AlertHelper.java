package helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import helper.logger.LoggerHelper;

public class AlertHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver) {
		this.driver=driver;	
		log.info("Alert object is initialized");
	}

	/**
	 * This method will allow switching to Alert
	 * @return
	 */
	public Alert getAlert() {
		log.info("Switching to Alert " +driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert() {
		getAlert().accept();
		log.info("Accept alert is done");
	}
	
	public void dismissAlert() {
		getAlert().dismiss();
		log.info("Dismiss alert is done");
	}
	
	public String getAlertText() {
		String text = getAlert().getText();
		log.info("Getting alert text: "+text);
		return text;
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		}catch(NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent() {
		if(isAlertPresent()) {
			acceptAlert();
		}
		else {
			log.info("Alert is not present");
		}
	}
	
	public void dismissAlertIfPresent() {
		if(isAlertPresent()) {
			dismissAlert();
		}
		else {
			log.info("Alert is not present");
		}
	}
	
	public void acceptPrompt(String text) {
		if(isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert is present and text has been written: "+text);
		}
	}
}
