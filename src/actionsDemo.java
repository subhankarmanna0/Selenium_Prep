import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo 
{

	public static void main(String[] args) 
	{
		 System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		Actions a = new Actions(driver);
		
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
		//move specific element
		a.moveToElement(move).contextClick().build().perform();

	}

}
