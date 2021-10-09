package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Scenario3PF2 {

	@FindBy(id="txtUserName")
	private WebElement username;

	@FindBy(id="txtPassword")
	private WebElement password;

	@FindBy(xpath="//button[@id=\"addToCart\"]")
	private WebElement btnAddToCart;
	
	@FindBy(xpath="//button[contains(@class,\"icon-plus\")]")
	private WebElement btnPlus;
	
	@FindBy(id="shoppingCart")
	private WebElement btnGoToCart;
	
	@FindBy(id="continue_step_btn")
	private WebElement btnCompletePurchase;
	
	@FindBy(id="shipping")
	private WebElement divShipmentAddress;

	@FindBy(xpath="//div[@id=\"shippingAddressContainer\"]/div[not(contains(@id,\"selectedAddressBox\"))]")
	private WebElement unselectedAddress;
	
	@FindBys(value = { @FindBy(xpath="//div[contains(@class,\"price_2Ur69\") and (text())]") })
	private List<WebElement> extraShippingFees;
	
	@FindBy(xpath="//div[@id=\"basket_payedPrice\"]/div[1]")
	private WebElement divCurrentCartTotal;

	private WebDriver driver;
	public Scenario3PF2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getBtnAddToCart() {
		return btnAddToCart;
	}
	public void setBtnAddToCart(WebElement btnAddToCart) {
		this.btnAddToCart = btnAddToCart;
	}
	public WebElement getBtnPlus() {
		return btnPlus;
	}
	public void setBtnPlus(WebElement btnPlus) {
		this.btnPlus = btnPlus;
	}
	public WebElement getBtnGoToCart() {
		return btnGoToCart;
	}
	public void setBtnGoToCart(WebElement btnGoToCart) {
		this.btnGoToCart = btnGoToCart;
	}
	public WebElement getBtnCompletePurchase() {
		return btnCompletePurchase;
	}
	public void setBtnCompletePurchase(WebElement btnCompletePurchase) {
		this.btnCompletePurchase = btnCompletePurchase;
	}
	public WebElement getDivShipmentAddress() {
		return divShipmentAddress;
	}
	public void setDivShipmentAddress(WebElement divShipmentAddress) {
		this.divShipmentAddress = divShipmentAddress;
	}
	public WebElement getUnselectedAddress() {
		return unselectedAddress;
	}
	public void setUnselectedAddress(WebElement unselectedAddress) {
		this.unselectedAddress = unselectedAddress;
	}
	public List<WebElement> getExtraShippingFees() {
		return extraShippingFees;
	}
	public void setExtraShippingFees(List<WebElement> extraShippingFees) {
		this.extraShippingFees = extraShippingFees;
	}
	public WebElement getDivCurrentCartTotal() {
		return divCurrentCartTotal;
	}
	public void setDivCurrentCartTotal(WebElement divCurrentCartTotal) {
		this.divCurrentCartTotal = divCurrentCartTotal;
	}
	
	
	
}
