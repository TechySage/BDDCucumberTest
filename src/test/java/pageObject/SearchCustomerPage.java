package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver Localdriver;

	public SearchCustomerPage(WebDriver RemoteDriver) {
		this.Localdriver = RemoteDriver;

		PageFactory.initElements(RemoteDriver, this);
	}

	@FindBy(xpath = "//input[contains(@ name,'SearchEmail')]")
	WebElement Email_SearchBox;

	@FindBy(xpath = "//button[contains(@id,'search-customers')]")
	WebElement SearchButton;

	@FindBy(xpath = "//input[contains(@id,'SearchFirstName')]")
	WebElement FirstName;
	
	
	@FindBy(xpath = "//input[contains(@id,'SearchLastName')]")
	WebElement lastName;


	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement Customer_Search_Result_Table;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")

	List<WebElement> TableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr/td[2]")

	List<WebElement> TableColumns;

	public static String[][] getWebTableData1(WebDriver driver, String tableXpath) {
		String tempCellText;
		WebElement table = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rowsList = table.findElements(By.tagName("tr"));
		int numRows = rowsList.size();
		int numCols = rowsList.get(0).findElements(By.tagName("td")).size();

		System.out.println("Total number of rows= " + numRows);
		System.out.println("Total number of cols=" + numCols);

		String[][] arrTabledata = new String[numRows][numCols];
		List<WebElement> columnsList = null;

		for (int i = 0; i < numRows; i++) {
			System.out.println();
			columnsList = rowsList.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < numCols; j++) {

				System.out.print(columnsList.get(j).getText().toString() + ",");
				tempCellText = columnsList.get(j).getText();
				arrTabledata[i][j] = tempCellText.toString();
			}
			System.out.println("Next Row");
		}
		return arrTabledata;
	}

	public boolean SerchCustomerByEmail(String ExpectedEmail) {

		boolean found = false;

		int total_rows = TableRows.size();

		int total_columns = TableColumns.size();
		
		System.out.println("Number of Rows"+total_rows);

		System.out.println("Number of Columns"+total_columns);

		for (int i = 1; i <= total_rows; i++) {
			WebElement email = Localdriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr[" + i + "]/td[2]"));
			String actualEmail = email.getText();

			if (actualEmail.equalsIgnoreCase(ExpectedEmail)) {
				found = true;
			}
		}
		return found;
	}

	public void enterEmail(String email) {
		Email_SearchBox.sendKeys(email);
	}

	public boolean searchByName(String CustomerName) {
		boolean found = false;

		int total_rows = TableRows.size();

		

		for (int i = 1; i <= total_rows; i++) {
			WebElement webElement_name = Localdriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr[" + i + "]/td[3]"));
			String actualName = webElement_name.getText();

			if (actualName.equalsIgnoreCase(CustomerName)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public void enterLastName(String lastName) {
		FirstName.sendKeys(lastName);
	}
	
	public void enterFirstName(String firstName) {
		FirstName.sendKeys(firstName);
	}
	
	public void searchByLastName(String lastName) {
		FirstName.sendKeys(lastName);
	}


	public void clickOnSearchButton() {
		SearchButton.click();
	}

}
