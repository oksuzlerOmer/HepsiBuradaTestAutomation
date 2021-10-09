package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

	
	

}
