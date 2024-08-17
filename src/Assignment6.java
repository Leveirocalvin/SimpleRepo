import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]/input")).click();
		
		String option = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		
		System.out.println(option);
		
		WebElement op = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(op);
		s.selectByVisibleText(option);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(option);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String text = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		System.out.println(text);
				
	}
}
