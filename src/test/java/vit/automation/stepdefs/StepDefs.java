package vit.automation.stepdefs;


import java.util.List;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vit.automation.pageObject.LandingPageObject;
import vit.automation.pageObject.PaymentPage;
import vit.automation.pageObject.ProductDiscPage;

public class StepDefs {
    
	WebDriver driver;
	String base_url = "https://amazon.in";
	WebDriverWait wait;
	
	LandingPageObject landingPageObject;
	ProductDiscPage productDiscPage;
	PaymentPage paymentPage;
	
	Scenario scn;

	
	@Before
	public void SetUp(Scenario scn) {
		this.scn=scn;
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		
		landingPageObject = new LandingPageObject(driver);
		productDiscPage = new ProductDiscPage(driver);
		paymentPage = new PaymentPage(driver);
		
		scn.log("browser invoked successfully");
	}
	@Given("user open the application")
	public void user_open_the_application() {
		driver.get(base_url);
		scn.log("user open the application");
	}

	@And("user search for the {string}")
	public void user_search_for_the(String product) {

		landingPageObject.SerchProduct(product);
		scn.log("user search for the product => " + product);
	}

	@And("user click on the product from the list")
	public void user_click_on_the_product_from_the_list() {
		landingPageObject.SuggestionList();
		scn.log("user click on the product from the link");

	}

	@Given("Selected product open in the new tab")
	public void selected_product_open_in_the_new_tab() {
		productDiscPage.selectedProd();
		scn .log("selected product open in the new tab");

	}

	@When("user Add the product into the cart")
	public void user_add_the_product_into_the_cart() {
		productDiscPage.AddingIntoCart();
        scn.log("user add the product into the cart");
	}

	@Then("user will see the payment page")
	public void user_will_see_the_payment_page() {

		paymentPage.paymentPage();
		scn.log("user is on payment page of the application");
	}

	@When("user hover the mouse on account list BTN")
	public void user_hover_the_mouse_on_account_list_btn() {
		landingPageObject.HoverOnSighInBTN();
		 scn.log("user hover the mouse on account list BTN");
	}

	@Then("{int} main options should be visible")
	public void main_options_should_be_visible(int number) {
		landingPageObject.MainOption(number);
		 scn.log("main options should be visible");
	}

	@Then("list should be visible")
	public void list_should_be_visible(List<String> Expected) {

		List<WebElement> yourlist1 = driver
				.findElements(By.xpath("//div[@id='nav-al-wishlist']//a[@class='nav-link nav-item']"));
		for (int i = 0; i < Expected.size(); i++) {
			if (Expected.get(i).equals(yourlist1.get(i).getText())) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		}
		 scn.log("1st list is visible");
	}

	@Then("user see next list")
	public void user_see_next_list(List<String> Expected2) {
		List<WebElement> yourlist2 = driver
				.findElements(By.xpath("//div[@id='nav-al-your-account']//a[@class='nav-link nav-item']"));
		for (int i = 0; i < Expected2.size(); i++) {

			if (Expected2.get(i).equals(yourlist2.get(i).getText())) {
				Assert.assertTrue(true);
			}

			else {
				Assert.fail();
			}
		}
		scn.log("2nd list is visible");
	}

	@When("user click on All button")
	public void user_click_on_all_button() {
		driver.findElement(By.id("nav-hamburger-menu")).click();
		scn.log("user click on button succsessfully");
	}

	@Then("Diffrent options displayed")
	public void diffrent_options_displayed(List<String> data) {

		List<WebElement> AllBTNList = driver.findElements(By.xpath("//div[@id='hmenu-content']/ul/li/a"));
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(AllBTNList.get(i).getText())) {
				Assert.assertTrue(true);
				System.out.println(data.get(i) + " <=> " + AllBTNList.get(i).getText());
			} else {
				//Assert.fail();
			}
		}
		scn.log("diffrent options displayed");
	}

	@After
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		scn.log("user close the browser");
	}

}
