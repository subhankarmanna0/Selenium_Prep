import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SLLCertificate 
{

	public static void main(String[] args) 
	{
		//directly open SSL blocked website
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//Block location pop up box.... (Ticket booking website)
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//Download in partucular folder
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		

	}

}
