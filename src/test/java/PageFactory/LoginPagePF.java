package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF {

	@FindBy(id="txtUserName")
	private WebElement username;

	@FindBy(id="txtPassword")
	private WebElement password;

	@FindBy(xpath="//button[contains(text(),'Giriþ yap')]")
	private WebElement btnLogin;

	public LoginPagePF(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

	public void enterUsername(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}

	public void enterPassword(String password) {
		this.username.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.btnLogin.click();
	}

}
