package Basic_Web;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementState 
{
	WebDriver driver;
	String baseURL;
	
		
	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		baseURL = "https://google.com";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@Test
	public void test() 
	{
		WebElement element = driver.findElement(By.xpath("//form[@id='tsf']//div[@class='A8SBwf']//div[@class='a4bIc']/input[@role='combobox']"));
		//Checking if the element is enable with boolean out put, and also if the element is displayed
		System.out.println("element is Enabled? " + element.isEnabled());
		System.out.println("element is Displayed? " + element.isDisplayed());
		try
			{
			if(element.isDisplayed())
				{
				System.out.println("The element is displayed!");
				element.getSize();
				System.out.println("The size of the element is: " + element.getSize());
				System.out.println("The location of the element is: " + element.getLocation());
				
				
				}			}
			catch(Exception e)
				{
				System.out.println("The element is not displayed!");
				}
		
		element.sendKeys("Hello World! Love, Selenium");
		WebElement search = driver.findElement(By.xpath("/html//form[@id='tsf']//div[@class='A8SBwf']/div[@class='FPdoLc tfB0Bf']/center/input[@name='btnK']"));
		search.click();
		System.out.println("Here are your search results!");
				
		
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception 
	{
		
	}

	

}
