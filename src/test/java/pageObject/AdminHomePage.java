package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	
	WebDriver Localdriver;
	  
	  public AdminHomePage(WebDriver RemoteDriver)
	  {
		  this.Localdriver=RemoteDriver;
		  
		  PageFactory.initElements(RemoteDriver,this);
	  }
	  
	  
      
	 
	  @FindBy(xpath ="//*[@id='navbarText']/ul/li[3]/a")
	  WebElement logout_button;
	  
	  public void ClickLogOutButton()
	  {
		  logout_button.click();
	  }
	
	  

}
