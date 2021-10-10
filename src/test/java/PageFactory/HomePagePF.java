package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePF {

	@FindBy(xpath="(//ul[contains(@class,\"product-list\")]/li)[2]")
	private WebElement searchResults;

	@FindBy(xpath="//div[contains(text(),\"ARA\")]")
	private WebElement btnSearch;

	@FindBy(xpath="//input[1]")
	private WebElement searchBox;

	@FindBy(xpath="//button[contains(text(),'Alýþveriþe devam et')]")
	private WebElement btnContinueShopping;

	@FindBy(id="shoppingCart")
	private WebElement btnGoToCart;

	private WebDriver driver;
	
	public HomePagePF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(WebElement searchResults) {
		this.searchResults = searchResults;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(WebElement btnSearch) {
		this.btnSearch = btnSearch;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public void setSearchBox(WebElement searchBox) {
		this.searchBox = searchBox;
	}
	public WebElement getBtnContinueShopping() {
		return btnContinueShopping;
	}
	public void setBtnContinueShopping(WebElement btnContinueShopping) {
		this.btnContinueShopping = btnContinueShopping;
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

	public void clickSearchBox() {
		this.searchBox.click();
	}

	public void enterSearchText(String text) {
		this.searchBox.sendKeys(text);
	}

}
