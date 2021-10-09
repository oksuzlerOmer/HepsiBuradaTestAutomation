package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.Scenario3PF2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario3Steps {
	
	static WebDriver driver=null;
	WebElement randomElement=null;
	Scenario3PF2 scenario3PF;

	@Given("the user has added random eight products to their cart.")
	public void the_user_has_added_random_eight_products_to_their_cart() throws InterruptedException {
		//fix chromedriver.exe location
		System.setProperty("webdriver.chrome.driver","C:\\Users\\omarr\\eclipse-workspace\\HepsiBuradaBDDTest06102021\\src\\test\\resources\\drivers\\chromedriver.exe");
		String[] urls= {
				"https://www.hepsiburada.com/koycegiz-bali-bahar-bali-850-g-cam-kavanoz-p-HBV0000122DZL",
				"https://www.hepsiburada.com/reeder-p13-blue-16-gb-3-gb-ram-reeder-turkiye-garantili-p-HBV00000KJI11",
				"https://www.hepsiburada.com/selcuk-sirin-okul-oncesi-kutulu-set-selcuk-sirin-derya-sirin-p-HBCV000004LR3D",
				"https://www.hepsiburada.com/altus-al-9103-md-9-kg-1000-devir-camasir-makinesi-p-HBCV000005UBZJ",
				"https://www.hepsiburada.com/bissell-powerfresh-lift-off-2-si-bir-arada-buhari-ayarlanabilir-buharli-temizlik-makinesi-p-HBV000019UU4N",
				"https://www.hepsiburada.com/bissell-crosswave-pet-pro-evcil-hayvanli-evler-icin-3-u-1-arada-yuksek-vakumlu-supurme-ve-silme-makinesi-p-HBCV00000BC2HX",
				"https://www.hepsiburada.com/spotclean-pet-pro-evcil-hayvanli-evlere-ozel-hali-koltuk-yikama-ve-leke-cikarma-makinesi-p-HBCV00000S3YX8",
				"https://www.hepsiburada.com/abc-matik-gul-tutkusu-toz-deterjan-6-kg-p-HBV00000PJBVP"
		};
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		scenario3PF=new Scenario3PF2(driver);
		for (int i = 0; i < urls.length; i++) {
			driver.navigate().to(urls[i]);
			Thread.sleep(5000);
			assertTrue(clickAddToCart(i==0?2:0));
		}

	}

	private boolean clickAddToCart(int amount) {
		try {
			for (int i = 0; i < amount; i++) {
				scenario3PF.getBtnPlus().click();
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
			}
			scenario3PF.getBtnAddToCart().click();
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Given("the user clicks went into their cart")
	public void the_user_clicks_went_into_their_cart() {
	    
	}

	@When("the user clicks {string} button \\(sc3)")
	public void the_user_clicks_button_sc3(String string) {
	  
	}

	@Then("the user is navigated to delivery options phase.")
	public void the_user_is_navigated_to_delivery_options_phase() {
	    
	}

	@Given("the user had already defined two different delivery addresses.")
	public void the_user_had_already_defined_two_different_delivery_addresses() {
	   
	}

	@Then("the number of items grouped in the delivery options should match the count in the actual cart.")
	public void the_number_of_items_grouped_in_the_delivery_options_should_match_the_count_in_the_actual_cart() {
	   
	}

	@Then("the delivery options should change according to the selected delivery address.")
	public void the_delivery_options_should_change_according_to_the_selected_delivery_address() {
	   
	}

	@Given("a delivery option with more cost than the default exists.")
	public void a_delivery_option_with_more_cost_than_the_default_exists() {
	    
	}

	@Then("the user selects the extra cost option")
	public void the_user_selects_the_extra_cost_option() {
	   
	}

	@Then("the extra cost should be added to the cart total.")
	public void the_extra_cost_should_be_added_to_the_cart_total() {
	   
	}

	@Then("the approximately calculated shipping dates should not be later than the calculated delivery dates.")
	public void the_approximately_calculated_shipping_dates_should_not_be_later_than_the_calculated_delivery_dates() {
	   
	}

	
}
