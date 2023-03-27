import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class countTotalLink 
{

	public static void main(String[] args)  throws InterruptedException
	{

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Count how many links are there inside page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Count how many links are there inside footer
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Inside footer: "+footerdriver.findElements(By.tagName("a")).size());
		
		//Count how many link are there inside footer table 1
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//Click on each link 
		for(int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickOnNewTabLink =  Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnNewTabLink);
			Thread.sleep(5000);
			
		}	
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
	}

}
