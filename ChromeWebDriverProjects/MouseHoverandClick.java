package Basic_Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseHoverandClick {

	public static void main(String[] args) 
{
		//Instantiate driver Class
		WebDriver driver = new ChromeDriver();
		//Instantiate baseURL as a string
		String baseURL ="https://www.letskodeit.com";
		//Go to URL
		driver.get(baseURL);
		//Maximize Window
		driver.manage().window().maximize();
		//Set implicit wait time		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		//Instantiate Action Class
		Actions actions = new Actions(driver);
		//Retrieve WebElement by id to perform mouse hover
		WebElement menuOption = driver.findElement(By.id("menu-item-1450"));
		//Mouse hover menuOption 'Music'
		actions.moveToElement(menuOption).perform();
		//Verification Message
		System.out.println("Completed mouse hover on 'Practice' from landing page");
		
		//Now Select Elements Practice by xpath from the SubMenu which is displayed after the mouse hover on the Practice Menu
		WebElement subMenu = driver.findElement(By.id("menu-item-1699"));
		//Mouse hover subMenu 'Elements Practice'
		actions.moveToElement(subMenu).perform();
		//Verification Message
		System.out.println("Completed Mouse hover on 'Elements Practice' from the submenu");
		subMenu.click();
		System.out.println("Completed Mouse Click on 'Elements Practice' from the submenu");
		/*
		actions.moveToElement
		(By.xpath("/html/body/div[1]/header/div/div/div/div/div[3]/div/nav/div/ul/li[5]/a"))
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/nav[1]/div[1]/ul[1]/li[5]/a[1]")).click();
		xpath("Practice"ul[@id='primary-menu']/li[5]/a/span[@class='menu-text']));
        */
}
}