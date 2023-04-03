import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;



public class Scroll 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement>values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i = 0; i < values.size(); i++)
		{
			int number = Integer.parseInt(values.get(i).getText());
			System.out.println(number);
			sum = number +sum;
		}
		System.out.println("Sum of table values: "+sum);
		String total = driver.findElement(By.cssSelector(".totalAmount")).getText();
		
		//Integer.parseInt(total);
		String[] TotalNum = total.split(":");
		System.out.println("Sum from screen: "+TotalNum[1].trim());
		int screenNum = Integer.parseInt(TotalNum[1].trim());
		
		Assert.assertEquals(sum, screenNum);

	}

}
