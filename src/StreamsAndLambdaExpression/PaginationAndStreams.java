package StreamsAndLambdaExpression;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationAndStreams {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();	
		
		List<String> price;
		
		do {
			
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s))
			.collect(Collectors.toList());
			
			price.forEach(s->System.out.println(s));
			
			//move to the next page - pagination 
			if (price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
		} while (price.size()<1);
		
	}

	private static String getVeggiePrice(WebElement s) {
		
		String price1  = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price1;
		
	}
	
}
