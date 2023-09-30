package Steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Utilities.DriverFactorty;
import Utilities.ReadConfig;
import ch.qos.logback.core.net.SyslogOutputStream;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewCustomerPage;
import pageObject.AdminHomePage;
import pageObject.SearchCustomerPage;
import pageObject.loginPage;
import Utilities.DriverFactorty;

public class CustomerStep extends BaseSteps {

	@Before
	public void setUp1() throws IOException {
		log = org.apache.logging.log4j.LogManager.getLogger("CustomerStep");
		// DriverFactorty df=new DriverFactorty();
		// df.openBrowser();

		// openBrowser();
		rd = new ReadConfig();
		String browser = rd.getBrowser();

		switch (browser) {

		case "chrome":

			System.out.println("setUp method executed for Chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("setup executed");
			break;
		case "firefox":
			System.out.println("setUp method executed for FireFox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("setup executed");
			break;
		case "msedge":
			System.out.println("setUp method executed for IF");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("setup executed");
			break;
		}

		// log=LogManager.getLogger("CustomerStep");

	}

	/*
	 * @Before public void setUp() {
	 * 
	 * System.out.println("setUp method executed for Firefox");
	 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); }
	 */

	@Given("User lunch Chrome browser")
	public void user_lunch_chrome_browser() {

		lp = new loginPage(driver);
		ap = new AdminHomePage(driver);
		acp = new AddNewCustomerPage(driver);
		scp = new SearchCustomerPage(driver);

		log.info("User lunch chrome browser");

	}

	@When("User open the application URL\"https:\\/\\/admin-demo.nopcommerce.com\\/login\"")
	public void user_open_the_application_url_https_admin_demo_nopcommerce_com_login() {
		// driver.manage().deleteAllCookies();

		driver.get("https://admin-demo.nopcommerce.com/login");

		driver.manage().window().maximize();
		log.info("URL opened");

	}

	/*
	 * @When("User Enters emailId as\"admin@yourstore.com\" and password as\"admin\""
	 * ) public void
	 * user_enters_email_id_as_admin_yourstore_com_and_password_as_admin() {
	 * 
	 * 
	 * lp.enterEmail("admin@yourstore.com"); lp.enterPassword("admin");
	 * 
	 * 
	 * }
	 */

	@When("User Enters emailId as{string} and password as{string}")
	public void user_enters_email_id_as_admin_yourstore_com_and_password_as_admin(String email, String password) {

		lp.enterEmail(email);
		lp.enterPassword(password);

		log.info("User enter email and password");
	}

	@When("Click on login button")
	public void click_on_login_button() {

		lp.clickLoginButton();

		log.info("User click on the login button");

	}

	@Then("User can view dasboard")
	public void user_can_view_dasboard() {

		String actualTitle = acp.getTitleOfPage();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		log.info("User vrified the title");

	}

	@When("User click on the customer menu")
	public void user_click_on_the_customer_menu() {

		acp.clickOnCustomerMenu();

		log.info("User click on the Customer menu");

	}

	@When("Click on the customer menu item")
	public void click_on_the_customer_menu_item() throws InterruptedException {

		Thread.sleep(5);

		acp.clickOncustomerItem();

		log.info("User click on the customer menu item");

	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {

		acp.clickonAddNew();

		log.info("User click the addnew button");

	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {

		System.out.println(driver.getTitle());

		String actualTitle = driver.getTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		log.info("User has verified the title");
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		acp.enterEmailId(generateEmailId() + "@gmail.com");
		acp.enterPassword("KBC123&&uy0t");
		acp.enterFirstname("RadheShyam");
		acp.enterLastName("Nayak");
		acp.clickGender("Male");
		acp.enterDateofBirth("6/12/2008");
		acp.enterCompanyName("TestDesk1230");
		acp.clickonTaxExemptCheckBox();
		acp.select_The_NewsLetter("Test store 2");
		acp.select_Manger_Vendor("Vendor 1");
		// acp.enter_customer_Roles("testing with BDD");
		// acp.Select_The_CustomerRoles("Vendors");
		acp.clickonActiveCheckBox();
		acp.enterAdminComment("Excellent");

		log.info("User has entered the information");

	}

	@When("Click on save button")
	public void click_on_save_button() {
		acp.clickOnSave();

		log.info("User has clicked on the save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedTitle) {

		String actualTitle = driver.getTitle();

		System.out.println(actualTitle);

		log.info("get title of the current page");

		/*
		 * expectedTitle="The new customer has been added successfully";
		 * if(actualTitle.equalsIgnoreCase(expectedTitle)) { Assert.assertTrue(true);
		 * }else { Assert.assertTrue(false); }
		 */

	}

	/*
	 * @Then("Close browser") public void close_browser() {
	 * 
	 * driver.close(); // driver.quit();
	 * 
	 * log.info("close the browser window page");
	 * 
	 * }
	 */

	@Then("print message successful")
	public void print_message_successful() {

		System.out.println("Test complete");
		log.info("print the message");

	}

//--- Search Customer by email

	@When("click on the customer menu item")
	public void click_on_the_customer_menu_item1() {

	}

	@When("Enter customer Email")
	public void enter_customer_email() throws InterruptedException {

		Thread.sleep(5);
		scp.enterEmail("teamwe1l7022@gmail.com");
		log.info("User enter the email");
	}

	@When("click on the search button")
	public void click_on_the_search_button() {
		scp.clickOnSearchButton();
		log.info("Search button clicked");

	}

	@Then("user should found the email in the search table")
	public void user_should_found_the_email_in_the_search_table() {

		/*
		 * String expectedEmail="teamwe1l7022@gmail.com";
		 * //Assert.assertTrue(scp.SerchCustomerByEmail(expectedEmail));
		 * if(scp.SerchCustomerByEmail(expectedEmail)==true) { Assert.assertTrue(true);
		 * }else { Assert.assertTrue(false); } }
		 */

	}

	@When("Enter customer first Name")
	public void enter_customer_first_name() {
		scp.enterFirstName("Gopi");

		log.info("first name entered");

	}

	@When("Enter customer last name")
	public void enter_customer_last_name() {

		scp.enterLastName("Nath");
		log.info("last name entered");

	}

	@Then("user should found the name in the search table")
	public void user_should_found_the_name_in_the_search_table() {

	}

	@After
	public void tearDown1(io.cucumber.java.Scenario sc)  {
		/*System.out.println("Teardown method executed method-1");

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
        sc.attach(screenshot,"image/png", sc.getName());*/
	}

	/*
	 * @After(order = 1) public void tearDown2() {
	 * System.out.println("Teardown method executed method-2"); //driver.close();
	 * driver.quit();
	 * 
	 * }
	 */
}
