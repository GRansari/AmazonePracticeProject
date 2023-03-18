package vit.automation.pageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPageObject {
	
	WebDriver driver;
	
	public LandingPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
    By searchbox=By.xpath("//input[@type='text']");
    By SuggetionList= By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']");
    By SignInBTN = By.xpath("//span[text()='Account & Lists']");
    public void SerchProduct(String ProductName) {
    	
    	driver.findElement(searchbox).sendKeys(ProductName);
    }
	public void SuggestionList() {
		WebElement ShoesForWomenTag = driver.findElement(By.xpath("//div[@aria-label='shoes for women']"));
		List<WebElement> suggestedOptions = driver.findElements(SuggetionList);
		for (int i = 0; i < suggestedOptions.size(); i++) {
			if (suggestedOptions.get(i).equals(ShoesForWomenTag)) {
				suggestedOptions.get(i).click();
				Assert.assertTrue(true);
			}	}}

	public void HoverOnSighInBTN() {
		WebElement BTN =driver.findElement(SignInBTN);
		Actions action = new Actions(driver);
		action.moveToElement(BTN).build().perform();
	}
	public void MainOption(int number) {
		List<WebElement> Options = driver.findElements(By.xpath("//div[@class='nav-title']"));
		Assert.assertEquals(number, Options.size());
	}
}
/*	
		WebElement SignInBTN = driver.findElement(By.xpath());
		
		}*/