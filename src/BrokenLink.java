import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink 
{

	public static void main(String[] args) throws MalformedURLException, IOException 
	{

		//Tide up all the URL a
		//Java Method will call the URL and get the status code
		//if status code is 200 thn working
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links =  driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			//Get WebPage Responce code without opening the page  
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode < 400, "Broken links is "+ link.getText()+ " and response code is "+ respCode);
//			if(respCode > 400)
//			{
//				System.out.println("Broken links is "+ link.getText()+ " and response code is "+ respCode);
//				Assert.assertTrue(false);
//				
//			}
		}
		a.assertAll(); //to return all response
		
			}

}
