package pageObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
  WebDriver Localdriver;
  
  public loginPage(WebDriver RemoteDriver)
  {
	  this.Localdriver=RemoteDriver;
	  
	  PageFactory.initElements(RemoteDriver,this);
  }

  
  @FindBy(id="Email")
  WebElement Email_inbox;
  
  @FindBy(id="Password")
  WebElement pwd_inbox;
  
  
  @FindBy(xpath="//button[contains(@type,'submit')]")
  WebElement login_btn;
  
  public void enterEmail(String EmailId)
  {
	  Email_inbox.clear();
	  Email_inbox.sendKeys(EmailId);
  }
  
  public void enterPassword(String Password)
  {
	  pwd_inbox.clear();
	  pwd_inbox.sendKeys(Password);
  }
  
  public void clickLoginButton() {
	  login_btn.click();
  }
}

