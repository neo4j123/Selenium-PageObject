package rough;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Rough {

	@Test
	public void check() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\akash\\eclipse\\workspace\\AutomationPracticeProject\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/product/android-quick-start-guide/");
		
		driver.findElement(By.xpath("//li[@class='post-169 product type-product status-publish product_cat-android product_tag-android has-post-title no-post-date has-post-category has-post-tag has-post-comment has-post-author first instock sale downloadable taxable shipping-taxable purchasable product-type-simple']//span[@class='onsale'][contains(text(),'Sale!')]")).click();
		
		if(driver.findElement(By.xpath("//del//span[@class='woocommerce-Price-amount amount']")).isDisplayed()) {
			System.out.println("Elements are present");
		}else {
			System.out.println("Elements are not present");
		}
		
		
		List<WebElement> element = driver.findElements(By.xpath("//del//span[@class='woocommerce-Price-amount amount']"));
		if(element.size()!=0) {
			System.out.println("Element is present on the screen");
		}else {
			System.out.println("Element is not present on the screen");
		}
		
		List<WebElement> element2 = driver.findElements(By.xpath("//ins//span[@class='woocommerce-Price-amount amount']"));
		if(element2.size()!=0) {
			System.out.println("Element is present");
		}else {
			System.out.println("Element is not present");
		}
	}

}
