package vit.automation.pageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDiscPage {

	WebDriver driver;
	
	public ProductDiscPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By SelectedProduct = By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]");
	By CartBTN = (By.name("submit.add-to-cart"));
	public void selectedProd() {
		
		driver.findElement(SelectedProduct).click();
	Set<String> handle = driver.getWindowHandles();
	Iterator<String> it = handle.iterator();
	String parentWindow=it.next();
	String child1 = it.next();
	driver.switchTo().window(child1);
	}
	
	public void AddingIntoCart() {
		driver.findElement(CartBTN).click();
	}
	
	
	
	
	
	
	
	
	
}
