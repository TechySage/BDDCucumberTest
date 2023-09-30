package Steps;

import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Utilities.DriverFactorty;
import Utilities.ReadConfig;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import pageObject.AddNewCustomerPage;
import pageObject.AdminHomePage;
import pageObject.SearchCustomerPage;
import pageObject.loginPage;
import org.apache.logging.log4j.*;
public class BaseSteps extends DriverFactorty {
	
	public static WebDriver driver;
	public loginPage lp;
	public AdminHomePage ap;
	public AddNewCustomerPage acp;
	public SearchCustomerPage scp;
	public DriverFactorty df;
	public static org.apache.logging.log4j.Logger log;
	
	public ReadConfig rd;
	
	
	public void openBrowser() {
		
		df.InitializeDriver();
	}

	
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}

}
