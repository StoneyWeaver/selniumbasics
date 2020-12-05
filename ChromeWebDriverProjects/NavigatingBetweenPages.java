package Basic_Web;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatingBetweenPages {
	WebDriver driver;
	String baseURL;
	
	
	@Before
	public void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		//baseURL = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		baseURL = "https://letskodeit.teachable.com";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	

	@Test
	public void test() {
		driver.get(baseURL);
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);
		//Getting the current URL of the webpage the test is currently on and setting it to the String currentURL
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + currentURL);
		//Navigating in browser to a specified URL
		String URLtoNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		driver.navigate().to(URLtoNavigate);
		currentURL = driver.getCurrentUrl();
		//Displaying for verification that the currentURL is now the URLtoNavigate
		System.out.println("The current URL is: " + currentURL);
				
		//In browser navigating back and setting the String currentURL to the pages' URL then printing out for verification		
		driver.navigate().back();
		currentURL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + currentURL);
		
		//In browser navigating forward and setting the String currentURL to the pages' URL then printing out for verification		
		driver.navigate().forward();
		currentURL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + currentURL);
		
		//In browser refreshing the web page by the refresh button and by re-entering the currentURL which was set to the last visted page
		driver.navigate().refresh();
		System.out.println("Refresh");
		driver.get(currentURL);
		System.out.println("Refresh");
		
		driver.navigate().back();
		currentURL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + currentURL);
		
		driver.navigate().refresh();
		System.out.println("Refresh");
		driver.get(currentURL);
		System.out.println("Refresh");
		
		//Setting the String pageSource to the current web pages' page source
		String pageSource = driver.getPageSource();
		
		System.out.println(pageSource);
		
		fail("Not yet implemented");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test Complete, closing");
		driver.quit();
	}
}
