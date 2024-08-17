package StreamsAndLambdaExpression;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
	//getting all the veggie's name
	List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
	
	//scan the name column with getText() -> Rice -> print the price of Rice with a method
	List<String> FruitPrice = elements.stream().filter(s->s.getText().contains("Rice")).
	map(s->getPrice(s)).collect(Collectors.toList());
	FruitPrice.forEach(s->System.out.println(s));
	
}

private static String getPrice(WebElement s) {
	
	String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return price;
	
}
}
