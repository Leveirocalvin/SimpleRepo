import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class ChromeOptions {

	public static void main(String[] args) {
		
		org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);

		// FirefoxOptions options1 = new FirefoxOptions();
		// options1.setAcceptInsecureCerts(true);
		// EdgeOptions options2 = new EdgeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}
}