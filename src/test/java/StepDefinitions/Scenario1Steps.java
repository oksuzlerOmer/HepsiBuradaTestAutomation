package StepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import Factory.DriverFactory.DriverType;
import PageFactory.AnyProductPagePF;
import PageFactory.HomePagePF;
import PageFactory.LoginPagePF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario1Steps {

	WebElement randomElement=null;
	LoginPagePF login;
	private boolean passwordExists=true;
	static final String HOMEPAGEURL="https://hepsiburada.com/";
	private String tempUN=null, tempPW=null;
	private ChromeDriver chromeDriver=null;
	private HomePagePF homePage=null;
	private AnyProductPagePF anyProductPage=null;

	@Given("the user has opened hepsiburada.com homepage on their browser")
	public void the_user_opens_browser() {
		chromeDriver=(ChromeDriver) DriverFactory.createDriver(DriverType.CHROME);
		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to(HOMEPAGEURL);
		login=new LoginPagePF(chromeDriver);
	}

	@And("the user hovers over {string} text")
	public void the_user_hovers_over_text(String string) {
		chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement randomElement=chromeDriver.findElement(By.xpath("//div[@id='myAccount']"));
		randomElement.click();
	}

	@Then("the user clicks {string} text in the dropdown menu")
	public void the_user_clicks_text_in_the_dropdown_menu(String string) {
		chromeDriver.findElement(By.id("login")).click();
	}

	@Then("check password input is existent")
	public boolean password_input_should_be_existent() {
		try {
			login.getPassword().clear();
		} catch (NoSuchElementException e) {
			passwordExists=false;
			return passwordExists;
		}
		return passwordExists;
	}


	@When("^if existent enters (.*) and (.*)$")
	public void if_existent_enters(String username, String password) {
		this.tempUN=username;
		this.tempPW=password;
		System.err.println(this.tempPW);
		if(passwordExists) {
			login.enterUsername(this.tempUN);
			login.enterPassword(this.tempPW);
		}
		else {
			login.enterUsername(this.tempUN);
		}
		login.clickLoginBtn();
	}

	@And("user enters password as above")
	public void user_enters() {
		if(!passwordExists) {
			try {
				login.enterPassword(this.tempPW);	
			} catch (NoSuchElementException e) {
				assertFalse(true);
				chromeDriver.close();
			}
			
		}
	}

	@Then("the user clicks {string} button")
	public void the_user_clicks_button(String string) {
		if(!passwordExists) {
			login.clickLoginBtn();
		}
	}

	@And("the user should be redirected to the homepage")
	public void the_user_should_be_redirected_to_the_homepage() {
		try {
			randomElement=chromeDriver.findElement(By.xpath("//span[contains(text(),'Hesabým')]"));
		} catch (NoSuchElementException e) {
			chromeDriver.close();
			assertTrue(false);
		}
		assertTrue(true);
	}
	
	@Then("the user clicks the search box")
	public void the_user_clicks_the_search_box() {
		homePage=new HomePagePF(chromeDriver);
		homePage.clickSearchBox();
	}

	@Then("^enters (.*) and hits enter$")
	public void enters_and_hits_enter(String searchText) {
		homePage.enterSearchText(searchText);
		homePage.getSearchBox().sendKeys(Keys.ENTER);
	}

	@Then("the second product in the results is clicked")
	public void click_second_product() throws InterruptedException {
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		homePage.getSearchResults().click();
	}
	
	@Given("the user had opened any product page")
	public void the_user_had_opened_any_product_page() {
		chromeDriver.navigate().to("https://www.hepsiburada.com/abc-bebek-camasir-sivi-deterjan-1500-lt-p-HBCV000003C95M");
		chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Then("the user clicks {string} from the first vendor")
	public void the_user_clicks_from_the_first_vendor(String string) {
		anyProductPage=new AnyProductPagePF(chromeDriver);
		anyProductPage.getAddToCartBtns().get(0).click();
	}

	@Then("the user closes the modal")
	public void the_user_closes_the_modal() throws InterruptedException {
		//sometimes the implicit and explicit waits do not work. there is an active bug knwon within the community.
		//have to use sleep sometimes. I know that it is not efficient or the right way.
		Thread.sleep(5000);
		anyProductPage.getBtnCloseModal().click();
	}

	@Given("the cart counter is {int}")
	public void the_cart_counter_is(Integer int1) {
		assertTrue(anyProductPage.getCartCounter().getText().equals("1"));
	}

	@Then("the user clicks {string} from the second vendor")
	public void the_user_clicks_from_the_second_vendor(String string) throws InterruptedException {
		anyProductPage.getAddToCartBtns().get(1).click();
		the_user_closes_the_modal();
	}
	
	@Given("the cart counter is incremented")
	public void the_cart_counter_is_incremented() {
		assertTrue(anyProductPage.getCartCounter().getText().equals("2"));
	}
}
