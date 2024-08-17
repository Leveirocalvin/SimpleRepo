package Selenium_4dotX_Features;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//IMPORTING MANUALLY THE LIBRARY
//******************************
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Relative_Locators {
	
	public static void main(String[] args) throws IOException {
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/angularpractice/");
	
	WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
	
	//Relative Locator
	String output = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
	System.out.println(output);
	
	//Relative Locator
	WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
	driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

	//Relative Locator
	WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
	driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

	//Relative Locator
	WebElement rdb = driver.findElement(By.id("inlineRadio1"));
	System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
	
	File f = rdb.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f, new File("locator.png"));
	
	driver.close();
	
}
}
