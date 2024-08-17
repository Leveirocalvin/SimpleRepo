import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");

		driver.findElement(By.linkText("Click Here")).click();
		
		Set s = driver.getWindowHandles();
		
	    Iterator<String> i = s.iterator();
	    
	    String ParentId = i.next();
	    String ChildId = i.next();
		
		driver.switchTo().window(ChildId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(ParentId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.close();
	}

}
