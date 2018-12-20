package helper.switchWindow;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import helper.logger.LoggerHelper;

public class WindowHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	/**
	 * This is a constructor
	 * @param driver
	 */
	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used for switching back to parent window
	 */
	public void switchToParentWindow() {
		log.info("Switching back to parent window");
		driver.switchTo().defaultContent();
	}

	/**
	 * This method iwll switch window based on windows based on index
	 * 
	 * @param index
	 */
	public void switchToParentWindow(int index) {
		log.info("Switching back to parent window");
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				log.info("Switching back to child window" +index);
				driver.switchTo().window(window);
			} else {
				i++;
			}
		}
	}

	/**
	 * This method is used for closing all tabs and return to main window
	 */
	public void closeAllWindowsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for (String window : windows) {
			log.info("Checking if current window is equal to parent window and then closing it");
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}
	
	/**
	 * This method is used for navigating previous page
	 */
	public void navigateBack() {
		log.info("Navigating to previous page");
		driver.navigate().back();
	}
	
	/**
	 * This method is used for navigating next page
	 */
	public void navigateForward() {
		log.info("Navigating to next page");
		driver.navigate().forward();
	}

}
