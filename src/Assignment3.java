import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		
		driver.findElement(By.cssSelector("input[value='user']")).click();
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        
        driver.findElement(By.id("okayBtn")).click();
		
		WebElement dropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
	    Select s = new Select(dropdown);
	    s.selectByVisibleText("Consultant");
	    
	    driver.findElement(By.id("terms")).click();
	    driver.findElement(By.id("signInBtn")).click();
		
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
	    
	    
	    List<WebElement> p = driver.findElements(By.cssSelector("button.btn-info"));	    
	    
	    for(int i=0; i<p.size();i++) {
	    	p.get(i).click();
	    }
	    
	    driver.findElement(By.partialLinkText("Checkout")).click();
	    
	    driver.close();
	}
}
