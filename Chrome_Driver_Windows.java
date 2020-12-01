package Basic_Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Driver_Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/AutomationFiles/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseURL ="https://www.letskodeit.com";
		driver.get(baseURL);
		
	}

}
