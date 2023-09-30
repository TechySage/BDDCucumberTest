package pageObject;

import java.util.List;

import org.apache.tools.ant.types.resources.Last;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.qos.logback.core.util.Duration;

//https://automationscript.com/selenium-java/handle-checkbox-in-selenium/
public class AddNewCustomerPage {

	WebDriver Localdriver;

	public AddNewCustomerPage(WebDriver RemoteDriver) {
		this.Localdriver = RemoteDriver;

		PageFactory.initElements(RemoteDriver, this);
	}


	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement linkCustomerMenu;
	
	

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement linkCustomer_MenuItem;

	

	@FindBy(xpath = "(//a[normalize-space()='Add new'])[1]")
	WebElement AddNew_button;

	@FindBy(xpath = "//input[contains(@type,'email')]")
	WebElement email_inputBox;

	@FindBy(xpath = "//input[contains(@type,'password')]")
	WebElement password_inputBox;

	@FindBy(xpath = "//input[contains(@id,'FirstName')]")
	WebElement firstName_inputBox;

	@FindBy(xpath = "//input[contains(@id,'LastName')]")
	WebElement LastName_inputBox;

	@FindBy(xpath = "//label[contains(@for,'Gender_Male')]")
	WebElement Male;

	@FindBy(xpath = "//label[contains(@for,'Gender_Female')]")
	WebElement Female;

	@FindBy(xpath = "//input[contains(@id,'DateOfBirth')]")
	WebElement DOB;

	@FindBy(xpath = "//input[contains(@id,'Company')]")
	WebElement company;

	@FindBy(xpath = "//input[contains(@id,'IsTaxExempt')]")
	WebElement Tax_exempt_chkBox;

	@FindBy(xpath = "(//div[@role='listbox'])[1]")
	WebElement NewsLetter;

	@FindBy(xpath = "//div[@id='customer-info']/div[2]/div[10]/div[2]/div/div[1]")
	WebElement CustomerRoles;

	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement Manger_Vendor;

	@FindBy(xpath = "//input[@id='Active']")
	WebElement Active_CheckBox;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement Admin_Comment;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement Save_button;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement succes_msg;
	
	
	
	

	// ------ Method--------------
	public String getTitleOfPage() {
		return Localdriver.getTitle();

	}

	public void clickOnCustomerMenu() {
		linkCustomerMenu.click();
	}

	public void clickOncustomerItem() {
		
		 // locate and click on first suggestion button
		//WebDriverWait wait = new WebDriverWait(Localdriver,java.time.Duration.ofSeconds(5));
		
		JavascriptExecutor j = (JavascriptExecutor) Localdriver;
		j.executeScript("arguments[0].click();", linkCustomer_MenuItem);

		//linkCustomer_MenuItem.click();
	}

	public void clickonAddNew() {
		AddNew_button.click();
	}

	public void enterEmailId(String email) {
		email_inputBox.sendKeys(email);
	}

	public void enterPassword(String password) {
		password_inputBox.sendKeys(password);
	}

	public void enterFirstname(String firstName) {
		firstName_inputBox.sendKeys(firstName);
	}

	public void enterLastName(String Lastname) {
		LastName_inputBox.sendKeys(Lastname);
	}

	public void clickGender(String gender) {
		if (gender.equalsIgnoreCase("Male")) {
			Male.click();
		} else if (gender.equalsIgnoreCase("Female")) {
			Female.click();
		} else {
			Male.click();
		}
	}

	public void enterDateofBirth(String dob) {
		DOB.sendKeys(dob);
	}

	public void enterCompanyName(String comp_Name) {
		company.sendKeys(comp_Name);
	}

	public void clickonTaxExemptCheckBox() {
		Tax_exempt_chkBox.click();
	}

	public void select_The_NewsLetter(String valueToSelect) {

		List<WebElement> allOptions = NewsLetter.findElements(By.tagName("div"));
		for (WebElement option : allOptions) {
			System.out.println("Option value " + option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}
	
	
	public void enter_customer_Roles(String value)
	{
		CustomerRoles.sendKeys(value);
		
	}

	public void Select_The_CustomerRoles(String valueToSelect) {

		List<WebElement> allOptions = CustomerRoles.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			System.out.println("Option value " + option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}
	
	
	public void select_Manger_Vendor(String strValueToSelect) {
		
		Select dr=new Select(Manger_Vendor);
		dr.selectByVisibleText(strValueToSelect);
	
	}
	
	/*public void selectMangerVendor(String strValueToSelect) {
	    try {
	        Select dropdown = new Select(Manger_Vendor);
	        if (dropdown.getOptions().toString().contains(strValueToSelect) == true) {
	            dropdown.selectByVisibleText(strValueToSelect);
	        } else {
	            dropdown.selectByValue(strValueToSelect);
	        }

	    } catch (Exception e) {

	    }

	}*/
	
	
	public void clickonActiveCheckBox() {
		Active_CheckBox.click();
	}
	
	public void enterAdminComment(String comments)
	{
		Admin_Comment.sendKeys(comments);
	}
	
	public void clickOnSave() {
		 Save_button.click();
	}
	
	public String getsuccessMessage() {
		 return succes_msg.getText();
	}



	// =================

	// a[contains(@class,'nav-link active')]

}
