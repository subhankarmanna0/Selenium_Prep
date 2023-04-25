import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowJava 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String perentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		
		String courseText = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		System.out.println(courseText);
		
		driver.switchTo().window(perentWindow);
		//Thread.sleep(3000);
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys(courseText);
		
		//get Screenshot
		File file = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("logo.png"));
		
		
		//get height and weight
		System.out.println("Height of name test box is: "+name.getRect().getDimension().getHeight());
		System.out.println("Weight of name text box is: "+name.getRect().getDimension().getWidth());
		
	}

}
