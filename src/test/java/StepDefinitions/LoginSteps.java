package StepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.LoginPagePF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	static WebDriver driver=null;
	WebElement randomElement=null;
	LoginPagePF login;
	private boolean passwordExists=true;
	static final String HOMEPAGEURL="https://hepsiburada.com/";
	private String tempUN=null, tempPW=null;

	@Given("the user has opened hepsiburada.com homepage on their browser")
	public void the_user_opens_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\omarr\\eclipse-workspace\\HepsiBuradaBDDTest06102021\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(HOMEPAGEURL);
		login=new LoginPagePF(driver);
	}

	@And("the user hovers over {string} text")
	public void the_user_hovers_over_text(String string) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement randomElement=driver.findElement(By.xpath("//span[@title='Giriþ Yap']"));
		randomElement.click();
	}

	@Given("a dropdown menu opens")
	public void a_dropdown_menu_opens() {

	}

	@Then("the user clicks {string} text in the dropdown menu")
	public void the_user_clicks_text_in_the_dropdown_menu(String string) {
		driver.findElement(By.id("login")).click();
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
				driver.close();
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
			randomElement=driver.findElement(By.xpath("//span[contains(text(),'Hesabým')]"));
		} catch (NoSuchElementException e) {
			driver.close();
			assertTrue(false);
		}
		assertTrue(true);
	}
}
