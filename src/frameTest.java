import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		//Count how many frame on screen 
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//Inser into frame using index
		driver.switchTo().frame(0);
		
		//Insert into frame using WebElement
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));
		String iFrame = driver.findElement(By.id("droppable")).getText();
		System.out.println(iFrame);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions a = new Actions(driver);
		
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
	}

}
