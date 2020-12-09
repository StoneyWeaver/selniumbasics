package Basic_Web;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



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
	public void testListofElements() throws Exception,NoAlertPresentException,InterruptedException
	{
		Actions actions = new Actions(driver);
		
		//Radio Buttons
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
		//Dropdowns
		List<WebElement> dropBox = driver.findElements(By.xpath(".//*[@id='carselect']//option"));
		int dropSize = dropBox.size();
		boolean isBoxSelect = false;
		System.out.println("The number of drop boxes = "+dropSize);
		for (int k=0; k<dropSize; k++)
		{
			isBoxSelect = dropBox.get(k).isSelected();
			if (!isBoxSelect)
			{
				dropBox.get(k).click();
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}
		//MultiSelect
		List<WebElement> multiSelect = driver.findElements(By.xpath("//select[@id='multiple-select-example']//option"));
		int multiSize = multiSelect.size();
		boolean isMultiSelect = false;
		System.out.println("The number of multi select options ="+multiSize);
		for (int l=0; l<multiSize; l++)
		{
			isMultiSelect = multiSelect.get(l).isSelected();
			if (!isMultiSelect)
			{
				multiSelect.get(l).click();
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}
		//Checkboxes
		List<WebElement> checkBoxes =driver.findElements(By.xpath("//input[contains(@type,'checkbox') and contains(@name,'cars')]"));
		int sizeCheck = checkBoxes.size();
		boolean isCheckedCheck = false;
		System.out.println("The number of checkboxes = "+sizeCheck);
		for (int j =0; j<sizeCheck; j++)
		{
			isCheckedCheck = checkBoxes.get(j).isSelected();
			if (!isCheckedCheck)
			{
				checkBoxes.get(j).click();
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}
		//Open new window then close
		WebElement SwitchWindow = driver.findElement(By.xpath("/html//div[@id='blocks']/div/div[@class='container']//legend[.='Switch Window Example']"));
		actions.doubleClick(SwitchWindow).perform();
		TimeUnit.MILLISECONDS.sleep(1000);
		String winHandleBefore = driver.getWindowHandle();
		
		SwitchWindow = driver.findElement(By.xpath("/html//button[@id='openwindow']"));
		SwitchWindow.click();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		
		//Open new tab then close
		WebElement SwitchTab =driver.findElement(By.xpath("/html//div[@id='blocks']/div/div[@class='container']//legend[.='Switch Tab Example']"));
		actions.doubleClick(SwitchTab).perform();
		TimeUnit.MILLISECONDS.sleep(1000);
		WebElement Switchtab = driver.findElement(By.xpath("/html//a[@id='opentab']"));
		Switchtab.click();
		/*for (String winHandle : driver.getWindowHandles()) 
		 * {
		    driver.switchTo().window(winHandle);
			}
		*/
		driver.switchTo().window(winHandleBefore);
		
		
		//Send Keys to text entry box
		WebElement sendKeys = driver.findElement(By.xpath("/html//input[@id='name']"));
		sendKeys.sendKeys("Test Name"); 
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println("Entered Name");
		TimeUnit.MILLISECONDS.sleep(1000);
		//Click on Alert button
		driver.findElement(By.xpath("/html//input[@id='alertbtn']")).click();
		
		//Click on accept alert
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		TimeUnit.MILLISECONDS.sleep(1000);
		driver.switchTo().alert().accept();
		
		
		//Click on confirm
		sendKeys.sendKeys("Test Name");
		driver.findElement(By.xpath("/html//input[@id='confirmbtn']")).click();
		TimeUnit.MILLISECONDS.sleep(1000);
		driver.switchTo().alert().getText();
		System.out.println(alertText);
		TimeUnit.MILLISECONDS.sleep(1000);
		driver.switchTo().alert().accept();
		sendKeys.sendKeys("Test Name");
		
		//Table
		String tableText = driver.findElement(By.xpath("/html//table[@id='product']")).getText();
		System.out.println(tableText);
		//actions.doubleClick(row1col1).perform();
		
		
	fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception 
	{
		
	}

}
