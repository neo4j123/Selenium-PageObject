package helper.generic;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericDate {

	private WebDriver driver;

	/**
	 * This method is used for generating day
	 * 
	 * @param day
	 */
	public void setDay(String day) {
		List<WebElement> days = driver.findElements(By.xpath(""));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(day)) {
				System.out.println(day);
				c.click();
				break;
			}
		}
	}

	/**
	 * This method is used for generating month
	 * 
	 * @param month
	 */
	public void setMonth(String month) {
		List<WebElement> months = driver.findElements(By.xpath(""));
		Iterator<WebElement> itr = months.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(month)) {
				System.out.println(month);
				c.click();
				break;
			}
		}
	}

	/**
	 * This method is used for generating year
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		List<WebElement> years = driver.findElements(By.xpath(""));
		Iterator<WebElement> itr = years.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(year)) {
				System.out.println(year);
				c.click();
				break;
			}
		}
	}

}
