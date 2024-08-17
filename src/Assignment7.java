import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*
		 * int columns = driver.findElements(By.className(".table-display th")).size();
		 * int rows = driver.findElements(By.className(".table-display tr")).size();
		 * 
		 * System.out.println("Columns :"+columns+" Rows : "+rows);
		 * 
		 * List<WebElement> s =
		 * driver.findElements(By.className(".table-display tr:nth-child(3)"));
		 * 
		 * for(int i=0; i<s.size(); i++) { System.out.println(s.get(i).getText()); }
		 */
		
		WebElement table=driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());


	}
}
