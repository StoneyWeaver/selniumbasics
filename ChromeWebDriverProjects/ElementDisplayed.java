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

public class ElementDisplayed {

	WebDriver driver;
	String baseURL1;
	String baseURL2;
	
	@Before
	public void setUp() throws Exception 
	{
		driver =new ChromeDriver();
		baseURL1 = "http://letskodeit.teachable.com/pages/practice";
		baseURL2 = "http://expedia.com";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testLetsKodeIt() throws InterruptedException 
	{
		driver.get(baseURL1);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text Box is Displayed: " + textBox.isDisplayed());
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked on hide button");
		System.out.println("Text Box is Displayed: " + textBox.isDisplayed());
		
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked on show button");
		System.out.println("Text Box is Displayed: " + textBox.isDisplayed());
	}
	
//	@Test
//	public void testExpedia() throws InterruptedException 
//	{
//		driver.get(baseURL2);
//		
//	}
	@After
	public void tearDown() throws Exception 
	{
	Thread.sleep(2000);
	driver.quit();
	}
	
	

}
