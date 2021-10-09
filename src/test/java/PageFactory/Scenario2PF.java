package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Scenario2PF {

	@FindBy(xpath="//span[contains(text(),\"Kitap, Müzik, Film, Hobi\")]")
	private WebElement wantedTopCategory;

	@FindBy(xpath="//span[contains(text(),\"Uzaktan Kumandalý Araçlar\")]")
	private WebElement RCCategory;

	@FindBy(xpath="//li[contains(@class,\"productListContainer-item\")][4]")
	private WebElement thirdProduct;
	
	@FindBy(xpath="//li[contains(@class,\"productListContainer-item\")][7]")
	private WebElement sixthProduct;

	@FindBy(xpath="//div[contains(text(),\"Sepete ekle\")]")
	private WebElement btnAddToCart;

	@FindBy(id="shoppingCart")
	private WebElement btnGoToCart;
	
	@FindBy(xpath="//button[contains(@class,\"moria-ProductCard\")]")
	private WebElement btnAddedToCart;
	
	@FindBy(xpath="//div[contains(text(),\"Drone Yedek Parçalarý\")]")
	private WebElement divDroneYedekParcalari;
	
	private WebDriver driver;
	public Scenario2PF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getWantedTopCategory() {
		return wantedTopCategory;
	}
	public void setWantedTopCategory(WebElement wantedTopCategory) {
		this.wantedTopCategory = wantedTopCategory;
	}
	public WebElement getRCCategory() {
		return RCCategory;
	}
	public void setRCCategory(WebElement rCCategory) {
		RCCategory = rCCategory;
	}
	public WebElement getThirdProduct() {
		return thirdProduct;
	}
	public void setThirdProduct(WebElement thirdProduct) {
		this.thirdProduct = thirdProduct;
	}
	public WebElement getBtnAddToCart() {
		return btnAddToCart;
	}
	public void setBtnAddToCart(WebElement btnAddToCart) {
		this.btnAddToCart = btnAddToCart;
	}
	public WebElement getBtnGoToCart() {
		return btnGoToCart;
	}
	public void setBtnGoToCart(WebElement btnGoToCart) {
		this.btnGoToCart = btnGoToCart;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getBtnAddedToCart() {
		return btnAddedToCart;
	}
	public void setBtnAddedToCart(WebElement btnAddedToCart) {
		this.btnAddedToCart = btnAddedToCart;
	}
	public WebElement getDivDroneYedekParcalari() {
		return divDroneYedekParcalari;
	}
	public void setDivDroneYedekParcalari(WebElement divDroneYedekParcalari) {
		this.divDroneYedekParcalari = divDroneYedekParcalari;
	}
	public WebElement getSixthProduct() {
		return sixthProduct;
	}
	public void setSixthProduct(WebElement sixthProduct) {
		this.sixthProduct = sixthProduct;
	}
	
	
	
}
