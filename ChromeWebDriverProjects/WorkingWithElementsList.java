package Basic_Web;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WorkingWithElementsList {
	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@Test
	public void testListofElements() throws Exception
	{
		boolean isCheckedradio = false;
		
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type,'radio')and contains(@name,'cars')]"));
				
		int size = radioButtons.size();
		System.out.println("The number of radio buttons = "+size);
		
		for (int i = 0; i<size; i++)
		{
			isCheckedradio = radioButtons.get(i).isSelected();
			
			if (!isCheckedradio)
			{
				radioButtons.get(i).click();
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}
		List<WebElement> checkBoxes =driver.findElements(By.xpath("//input[contains(@type,'checkbox') and contains(@name,'cars')]"));
		int sizeCheck = checkBoxes.size();
		boolean isCheckedCheck = false;
		System.out.println("The number of checkboxes = "+sizeCheck);
		for (int i =0; i<sizeCheck; i++)
		{
			isCheckedCheck = checkBoxes.get(i).isSelected();
			
			if (!isCheckedCheck)
			{
				checkBoxes.get(i).click();
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}
		
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
