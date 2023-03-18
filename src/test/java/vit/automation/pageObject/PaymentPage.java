package vit.automation.pageObject;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

	WebDriver driver;
	
	public PaymentPage(WebDriver driver){
		this.driver = driver;
	}
	
	String PageTitle="Amazon.in Shopping Cart";
	
	public void paymentPage() {
		Assert.assertEquals(PageTitle, driver.getTitle());
	}
	
	
}
