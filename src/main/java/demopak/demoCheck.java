package demopak;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoCheck {
	
	public static void main(String[] args) {
		
		WebDriver dr=new ChromeDriver();
		dr.get("https://admin-demo.nopcommerce.com/login");
		
		//https://admin-demo.nopcommerce.com/admin/
		
		//dr.get("https://admin-demo.nopcommerce.com/admin/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String title=dr.getTitle();
		
		System.out.println(title);
		
		WebElement Email_box=dr.findElement(By.id("Email"));
		Email_box.clear();
		Email_box.sendKeys("admin@yourstore.com");
		
        WebElement Passwprd_box=dr.findElement(By.id("Password"));
		Passwprd_box.clear();
		Passwprd_box.sendKeys("admin");
		
		
		WebElement Login_btn=dr.findElement(By.xpath("//button[contains(@type,'submit')]"));
			
	     Login_btn.click();
			
	     String title2=dr.getTitle();
			
			System.out.println(title2);
		
		
	}

}
