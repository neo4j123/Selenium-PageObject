package rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rough2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E:\\akash\\eclipse\\workspace\\AutomationPracticeProject\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/shop/");

	}

}
