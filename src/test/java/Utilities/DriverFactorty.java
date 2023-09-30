package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactorty extends ReadConfig{
	public  WebDriver driver;
	ReadConfig rd=new ReadConfig();
	
	public void InitializeDriver()
	{
		String browser = rd.getBrowser();

		
		switch (browser) {

		case "chrome":
			System.out.println("setUp method executed for Chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;
		case "firefox":
			System.out.println("setUp method executed for FireFox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "msedge":
			System.out.println("setUp method executed for IF");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			break;
		}
	}

	
	
	
	

}
