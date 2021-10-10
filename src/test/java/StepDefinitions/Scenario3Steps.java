package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import Factory.DriverFactory;
import Factory.DriverFactory.DriverType;
import PageFactory.Scenario3PF2;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario3Steps {

	WebElement randomElement=null;
	Scenario3PF2 scenario3PF;
	int itemsInCart=0;
	int extraShipmentFeesCount=0;
	boolean totalAddsUp=false;
	Date tmpDate=null;
	private ChromeDriver chromeDriver=null;

	List<WebElement> extraShipmentFees=null;

	@Given("the user logged in")
	public void the_user_logged_in() throws InterruptedException {
		chromeDriver=(ChromeDriver) DriverFactory.createDriver(DriverType.CHROME);
		chromeDriver.manage().window().maximize();
		scenario3PF=new Scenario3PF2(chromeDriver);
		chromeDriver.navigate().to("https://www.hepsiburada.com/uyelik/giris");
		chromeDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		chromeDriver.findElement(By.id("txtUserName")).clear();
		chromeDriver.findElement(By.id("txtUserName")).sendKeys("testhb6102021@gmail.com");
		chromeDriver.findElement(By.id("txtUserName")).sendKeys(Keys.ENTER);
		chromeDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		chromeDriver.findElement(By.id("txtPassword")).clear();
		chromeDriver.findElement(By.id("txtPassword")).sendKeys("rs8jhYx8AZ86");
		chromeDriver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	@Given("the user has added predefined eight products to their cart.")
	public void the_user_has_added_predefined_eight_products_to_their_cart() throws InterruptedException {
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

		for (int i = 0; i < 0; i++) {
			chromeDriver.navigate().to(urls[i]);
			Thread.sleep(4000);
			assertTrue(clickAddToCart(i==0?2:0));
		}

	}

	private boolean clickAddToCart(int amount) {
		try {
			for (int i = 0; i < amount; i++) {
				scenario3PF.getBtnPlus().click();
				chromeDriver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
			}
			scenario3PF.getBtnAddToCart().click();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Given("the user opens their cart")
	public void the_user_opens_their_cart() throws InterruptedException {
		scenario3PF.getBtnGoToCart().click();
		Thread.sleep(4000);
	}

	@When("the user clicks {string} button \\(sc3)")
	public void the_user_clicks_button_sc3(String string) throws InterruptedException {
		itemsInCart=chromeDriver.findElements(By.id("selectedCheckBox")).size();
		scenario3PF.getBtnCompletePurchase().click();
		chromeDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Thread.sleep(4000);
	}

	@Then("the user is navigated to delivery options phase.")
	public void the_user_is_navigated_to_delivery_options_phase() throws InterruptedException {
		scenario3PF.getDivShipmentAddress().click();
		Thread.sleep(4000);
	}

	@Given("the user had already defined two different delivery addresses.")
	public void the_user_had_already_defined_two_different_delivery_addresses() {
		WebDriverWait wait=new WebDriverWait(chromeDriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(scenario3PF.getDivShipmentAddress()));
		scenario3PF.getDivShipmentAddress().click();
	}

	@Then("the number of items grouped in the delivery options should match the count in the actual cart.")
	public void the_number_of_items_grouped_in_the_delivery_options_should_match_the_count_in_the_actual_cart() {
		assertTrue(itemsInCart==chromeDriver.findElements(By.xpath("//div[contains(text(),\"Kargoya veriliþ tarihi\")]")).size());
	}

	@Then("the delivery options should change according to the selected delivery address.")
	public void the_delivery_options_should_change_according_to_the_selected_delivery_address() throws InterruptedException {
		WebElement el=chromeDriver.findElement(By.xpath("//div[contains(@class,\"shipping_options_container\")]"));
		String str1=el.getText();
		scenario3PF.getUnselectedAddress().click();
		Thread.sleep(2000);
		String str2=el.getText()+"";
		//I compare the html code when an address was selected and compare it to when the other address was selected.
		//They could still be the same for the 2 different addresses. This algorithm needs improvement.
		assertTrue(!str1.equals(str2));
		scenario3PF.getUnselectedAddress().click();
		Thread.sleep(1000);
	}

	@Given("a delivery option with more cost than the default exists.")
	public void a_delivery_option_with_more_cost_than_the_default_exists() {
		extraShipmentFees=scenario3PF.getExtraShippingFees();
		extraShipmentFeesCount=extraShipmentFees.size();
		assertTrue(extraShipmentFeesCount>0);
	}

	@Then("the user selects the extra cost option")
	public void the_user_selects_the_extra_cost_option() throws InterruptedException {
		float currentCartTotal=separatePriceFromText(scenario3PF.getDivCurrentCartTotal());
		float currentProductsCostTotal=separatePriceFromText(scenario3PF.getDivCurrentProductsCost());
		float currentShipmentTotal=0;
		float totalExtrafees=0;

		currentShipmentTotal=separatePriceFromText(scenario3PF.getDivCurrentShipmentTotal());
		
		//all the extra shipment cost options are selected
		for (WebElement el : extraShipmentFees) {
			el.click();
			totalExtrafees+=separatePriceFromText(el);
			Thread.sleep(200);
		}

		Thread.sleep(500);
		
		//2 wrongs can make 1 right here. This algorithm is open for improvement.
		totalAddsUp=separatePriceFromText(scenario3PF.getDivCurrentCartTotal())==(totalExtrafees-currentShipmentTotal)+currentCartTotal;
	}

	private float separatePriceFromText(WebElement el) {
		String str=el.getText().replace(".", "");
		str=str.replace(",", ".");
		return Float.parseFloat(str.split(" ")[0]);
	}

	@Then("the extra cost should be added to the cart total.")
	public void the_extra_cost_should_be_added_to_the_cart_total() {
		assertTrue(totalAddsUp);
	}

	//this step can't check if the delivery date will be in the next year.
	@Then("the approximately calculated shipping dates should not be later than the calculated delivery dates.")
	public void the_approximately_calculated_shipping_dates_should_not_be_later_than_the_calculated_delivery_dates() throws ParseException {
		List<WebElement> shipmentGroups=scenario3PF.getShipmentGroups();
		SimpleDateFormat sdf= new SimpleDateFormat("dd MMM");
		WebElement tmpEl;
		for (WebElement group : shipmentGroups) {
			tmpEl=group.findElement(By.xpath(".//div[@class=\"shipping_date_CMJ8d\"]/span[1]"));
			tmpDate=sdf.parse(tmpEl.getText());
			for(WebElement el: group.findElements(By.xpath(".//div[@class=\"delivery_date_1ZuyW\"]/span[1]"))) {
				assertTrue(tmpDate.before(sdf.parse(el.getText())));
			}

		}

		chromeDriver.quit();
	}
}
