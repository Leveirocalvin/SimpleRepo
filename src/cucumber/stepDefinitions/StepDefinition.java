package cucumber.stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	public WebDriver driver;
	
	@Given("Open the browser and hit the URL")
	public void Open_the_browser_and_hit_the_URL()
	{	
		//ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("headless");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	
	//since it's regex used we need to start with ^ and end with $
	@Given("^Login with username (.+) and password (.+)$")
	public void login_with_usernamePassword(String username, String password) throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
	}
	
	@When("^I Add (.+) to cart$")
	public void add_product_to_cart(String productname) throws InterruptedException
	{
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(2000);
	}
	
	@And("View cart if item displayed")
	public void viewCart() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".cartSection h3")).getText());
		driver.findElement(By.cssSelector(".totalRow button")).click();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void confirmationPage(String string) throws InterruptedException
	{
		Thread.sleep(2000);
		//driver.findElement(By.className(string));
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')] [2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		System.out.println(driver.findElement(By.cssSelector("h1")).getText());
		driver.close();
	}
}
