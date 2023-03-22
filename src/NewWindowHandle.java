import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowHandle 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();   //[ParentId, ChildId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
		String emailId = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailId);
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(emailId);
		

	}

}
