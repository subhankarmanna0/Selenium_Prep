import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class base 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//Adding multiple product to chart
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Explicite Wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
		String[] itemNeeded = {"Brocolli", "Cauliflower","Beetroot"};
		
		
		addItem(driver, itemNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		

	}
	
	
	
	public static void addItem(WebDriver driver, String[] itemNeeded)
	{
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		
		for(int i = 0; i < products.size(); i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formatedName = name[0].trim();
			
			List itemNeededList = Arrays.asList(itemNeeded);
			
			System.out.println("Product name: "+formatedName);	
			System.out.println("Item Needed: "+itemNeededList);
			
			if(itemNeededList.contains(formatedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				if(j==itemNeeded.length)
				{
					break;
				}
			}
			
		}
	}
	
	

}
