package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import PageFactory.Scenario2PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario2Steps {
	Scenario2PF scenario2PF=null;
	Actions actions=null;
	@Given("the user clicks on {string} text")
	public void the_user_clicks_on_text(String string) {
		scenario2PF=new Scenario2PF(LoginSteps.driver);
		actions= new Actions(LoginSteps.driver);
		scenario2PF.getWantedTopCategory().click();
	}

	@When("the user clicks {string}")
	public void the_user_clicks(String string) {
		LoginSteps.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		scenario2PF.getRCCategory().click();
	}

	@Given("the user should be redirected to {string}")
	public void the_user_should_be_redirected_to(String string) {

	}

	@Then("the user moves the cursor over the third product")
	public void the_user_moves_the_cursor_over_the_third_product() throws InterruptedException {
		Thread.sleep(3000);
		actions.moveToElement(scenario2PF.getThirdProduct()).perform();
	}

	@Given("{string} button becomes visible")
	public void button_becomes_visible(String string) {

	}

	@And("the user clicks {string} button \\(sc2)")
	public void the_user_clicks_addToCart_button(String string) {
		scenario2PF.getBtnAddToCart().click();
	}

	@Then("a green {string} button should be displayed")
	public void a_green_button_should_be_displayed(String string) throws InterruptedException {
		Thread.sleep(200);
		System.out.println(scenario2PF.getBtnAddedToCart().isDisplayed());
		assertTrue(scenario2PF.getBtnAddedToCart().isDisplayed());

	}

	@Then("the user, from left, under {string}, clicks {string}")
	public void the_user_from_left_under_clicks(String string, String string2) throws InterruptedException {
		actions.moveToElement(scenario2PF.getDivDroneYedekParcalari()).perform();
		WebDriver tmpDriver=LoginSteps.driver;
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
