import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calendar 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		
		a.scrollByAmount(0, 1000).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='form_fields[travel_comp_date]']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@name='form_fields[travel_comp_date]']")).click();
		//driver.findElement(By.xpath("//input[@name='form_fields[travel_comp_date]']"))
		List<WebElement> dates = driver.findElements(By.tagName("span"));
		int count = driver.findElements(By.tagName("span")).size();
		System.out.println(count);
		//Select 25
		
		for(int i = 0; i < count; i++)
		{
			String text = driver.findElements(By.tagName("span")).get(i).getText();
			if(text.equalsIgnoreCase("25"))
			{
				driver.findElements(By.tagName("span")).get(i).click();
				System.out.println("In Side loop");
				break;
			}
		}

	}

}
