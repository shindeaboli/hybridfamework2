package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	@FindBy(id = "email")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginbutton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) 
	{
		super.sendKeys(this.username, username);
	}

	public void enterPassword(String password) {
		super.sendKeys(this.password, password);
	}

	public void clickOnLoginButton() {
		super.click(this.loginbutton);
	}

}
