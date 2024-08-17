import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

public class Actions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		
		org.openqa.selenium.interactions.Actions a = new org.openqa.selenium.interactions.Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("[id='nav-link-accountList']"))).build().perform();
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).contextClick().build().perform();
		
	}
}
