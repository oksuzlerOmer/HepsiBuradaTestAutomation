package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.HomePagePF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchProductSteps {


	WebElement randomElement=null;
	HomePagePF homePage;


	@Given("the user had opened the browser")
	public void the_user_had_opened_the_browser() {
		System.setProperty("webdriver.chrome.driver","C:/Users/omarr/eclipse-workspace/HepsiBuradaTest06102021/src/test/resources/drivers/chromedriver.exe");
		LoginSteps.driver=new ChromeDriver();
		LoginSteps.driver.manage().window().maximize();
	}

	@Given("the user had opened {string}")
	public void the_user_had_opened(String string) {
		LoginSteps.driver.navigate().to(LoginSteps.HOMEPAGEURL);
//		homePage=new HomePagePF(LoginSteps.driver);
	}

	@Then("the user clicks the search box")
	public void the_user_clicks_the_search_box() {
		homePage=new HomePagePF(LoginSteps.driver);
		homePage.clickSearchBox();
	}

	@Then("^enters (.*) and hits enter$")
	public void enters_and_hits_enter(String searchText) {
		homePage.enterSearchText(searchText);
		homePage.getSearchBox().sendKeys(Keys.ENTER);
	}

	@Then("the second product in the results is clicked")
	public void click_second_product() {
		LoginSteps.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.getSearchResults().click();
	}



}
