package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Factory.DriverFactory;
import Factory.DriverFactory.DriverType;
import PageFactory.LoginPagePF;
import PageFactory.Scenario2PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario2Steps {
	Scenario2PF scenario2PF=null;
	Actions actions=null;
	private ChromeDriver chromeDriver=null;
	
	@Given("the user goes to homepage")
	public void the_user_opens_browser_sc2() {
		chromeDriver=(ChromeDriver) DriverFactory.createDriver(DriverType.CHROME);
		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to(Scenario1Steps.HOMEPAGEURL);
		scenario2PF=new Scenario2PF(chromeDriver);
	}
	
	@And("the user clicks on {string} text")
	public void the_user_clicks_on_text(String string) {
		actions= new Actions(chromeDriver);
		scenario2PF.getWantedTopCategory().click();
	}
	
	@Given("a dropdown menu opens \\(sc2)")
	public void a_dropdown_menu_opens_sc2() throws InterruptedException {
		Thread.sleep(3000);
		WebElement tmpEl=null;
		
		try {
			tmpEl=chromeDriver.findElement(By.xpath("//div[contains(@class,\"sf-MenuItems-2lSSo\")]"));
			assertTrue(true);
		} catch (NoSuchElementException e) {
			assertTrue(false);
		}
	}


	@When("the user clicks {string}")
	public void the_user_clicks(String string) {
		chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		scenario2PF.getRCCategory().click();
	}

	@Given("the user should be redirected to {string}")
	public void the_user_should_be_redirected_to(String string) {
		assertTrue(chromeDriver.getCurrentUrl().contains(string));
	}

	@Then("the user moves the cursor over the third product")
	public void the_user_moves_the_cursor_over_the_third_product() throws InterruptedException {
		Thread.sleep(3000);
		actions.moveToElement(scenario2PF.getThirdProduct()).perform();
	}

	@Given("{string} button becomes visible")
	public void button_becomes_visible(String string) {
		try {
			assertTrue(scenario2PF.getBtnAddToCart().isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(false);
		}
	}

	@And("the user clicks {string} button \\(sc2)")
	public void the_user_clicks_addToCart_button(String string) {
		scenario2PF.getBtnAddToCart().click();
	}

	@Then("a green {string} button should be displayed")
	public void a_green_button_should_be_displayed(String string) throws InterruptedException {
		Thread.sleep(200);
		assertTrue(scenario2PF.getBtnAddedToCart().isDisplayed());

	}

	@Then("the user, from left, under {string}, clicks {string}")
	public void the_user_from_left_under_clicks(String string, String string2) throws InterruptedException {
		actions.moveToElement(scenario2PF.getDivDroneYedekParcalari()).perform();
		WebDriver tmpDriver=chromeDriver;
		JavascriptExecutor js= (JavascriptExecutor) tmpDriver;
		js.executeScript("arguments[0].scrollIntoView()",scenario2PF.getDivDroneYedekParcalari());
		Thread.sleep(200);
		js.executeScript("arguments[0].scrollIntoView()",tmpDriver.findElement(By.tagName("html")));
		scenario2PF.getDivDroneYedekParcalari().click();
		tmpDriver=null;
	}

	@Then("the user moves the cursor over a sixth product in the list")
	public void the_user_moves_the_cursor_over_a_sixth_product_in_the_list() throws InterruptedException {
		Thread.sleep(3000);
		actions.moveToElement(scenario2PF.getSixthProduct()).perform();
	}

}
