package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.AnyProductPagePF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCartSteps {

	WebElement randomElement=null;
	AnyProductPagePF anyProductPage=null;


	@Given("the user had opened any product page")
	public void the_user_had_opened_any_product_page() {
		System.setProperty("webdriver.chrome.driver","C:/Users/omarr/eclipse-workspace/HepsiBuradaTest06102021/src/test/resources/drivers/chromedriver.exe");
		LoginSteps.driver=new ChromeDriver();
		LoginSteps.driver.manage().window().maximize();
		LoginSteps.driver.navigate().to("https://www.hepsiburada.com/abc-bebek-camasir-sivi-deterjan-1500-lt-p-HBCV000003C95M");
		LoginSteps.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		anyProductPage=new AnyProductPagePF(LoginSteps.driver);
	}

	@Then("the user clicks {string} from the first vendor")
	public void the_user_clicks_from_the_first_vendor(String string) {
		anyProductPage=new AnyProductPagePF(LoginSteps.driver);
		anyProductPage.getAddToCartBtns().get(0).click();
	}

	@Then("the user closes the modal")
	public void the_user_closes_the_modal() throws InterruptedException {
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
		LoginSteps.driver.close();
	}
	
	
}
