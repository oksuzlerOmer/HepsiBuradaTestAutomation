package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AnyProductPagePF {

	@FindBys(value = @FindBy(xpath="(//*[contains(@class,'add-to-basket') or @class=\"addToCartButton\"])"))
	private List<WebElement> addToCartBtns;
	
	@FindBy(xpath="//a[contains(@class,\"Modal\")]")
	private WebElement btnCloseModal;
	
	@FindBy(id="cartItemCount")
	private WebElement cartCounter;

	private WebDriver driver;
	public AnyProductPagePF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAddToCartBtns() {
		return addToCartBtns;
	}

	public void setAddToCartBtns(List<WebElement> addToCartBtns) {
		this.addToCartBtns = addToCartBtns;
	}

	public WebElement getBtnCloseModal() {
		return btnCloseModal;
	}

	public void setBtnCloseModal(WebElement btnCloseModal) {
		this.btnCloseModal = btnCloseModal;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCartCounter() {
		return cartCounter;
	}

	public void setCartCounter(WebElement cartCounter) {
		this.cartCounter = cartCounter;
	}
	
	

}
