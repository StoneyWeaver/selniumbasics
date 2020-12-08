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

public class RadioButtonsAndCheckBoxes {
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
	public void test() throws InterruptedException
	{
		WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
		WebElement benzRadioButton = driver.findElement(By.id("benzradio"));
		WebElement hondaRadioButton = driver.findElement(By.id("hondaradio"));
		WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
		WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
		WebElement hondaCheckBox = driver.findElement(By.id("hondacheck"));
			
		bmwRadioButton.click();
		
		TimeUnit.MILLISECONDS.sleep(1000);
				
		benzRadioButton.click();
			
		TimeUnit.MILLISECONDS.sleep(1000);
				
		hondaRadioButton.click();
			
		TimeUnit.MILLISECONDS.sleep(1000);
			
		benzRadioButton.click();
		
		TimeUnit.MILLISECONDS.sleep(1000);
		
		bmwRadioButton.click();
		
		TimeUnit.MILLISECONDS.sleep(1000);
		
		bmwCheckBox.click();
		
		TimeUnit.MILLISECONDS.sleep(1000);
		
		benzCheckBox.click();
		
		TimeUnit.MILLISECONDS.sleep(1000);
		
		hondaCheckBox.click();
		
		TimeUnit.MILLISECONDS.sleep(1000);
		
		//This is better than \n because it will work regardless of the OS it is ran on
		String newLine = System.lineSeparator();
		System.out.println("BMW Raio Button is selected: "+bmwRadioButton.isSelected()+newLine+"Benz Radio Button is selected: "+benzRadioButton.isSelected()+newLine+"Honda Radio Button is selected: "+hondaRadioButton.isSelected()+newLine+"BMW checkbox is selected: "+bmwCheckBox.isSelected()+newLine+"Benz checkbox is selected: "+benzCheckBox.isSelected()+newLine+"Honda checkbox is selected: "+hondaCheckBox.isSelected());
		
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("Test Complete");
		TimeUnit.MILLISECONDS.sleep(1000);
		driver.quit();
	}

}
