import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemoSortTable 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\Workspace\\ChromeDriver\\chromedriver_win32(4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//1 Click on column
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		//2 capture all webelement in a list 
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));
		
		//3 capture text of all webelement into new(original) list 
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//4 sort on the original list of 3
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//5 compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		//scan the name column with getTest -> Beans -> print thr price of beans
//		List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans")).
//				map(s->getPriceVeggie(s)).collect(Collectors.toList());
//		price.forEach(a->System.out.println(a));
		
		List<String> price;
		////scan the name column with getTest -> Rice and if rice not available on the first screen -> print thr price of rice
		do

		{

		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

		price = rows.stream().filter(s -> s.getText().contains("Rice"))

		.map(s -> getPriceVeggie(s)).collect(Collectors.toList());

		price.forEach(a -> System.out.println(a));

		if(price.size()<1)

		{

		driver.findElement(By.cssSelector("[aria-label='Next']")).click();

		}

		}while(price.size()<1);

	}

	private static String getPriceVeggie(WebElement s) 
	{
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return pricevalue;
	}

}
