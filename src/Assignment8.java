import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("united");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.className("ui-menu-item"));
		
		Thread.sleep(2000);
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("United States (USA)")){
				option.click();
				break;
			}
		}
	}
}
