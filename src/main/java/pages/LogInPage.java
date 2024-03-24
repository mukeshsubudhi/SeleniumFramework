package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends utilities.Utilities {

	WebDriver driver;

	public LogInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMsg;

	public HomePage loginApplication(String email, String psw) {
		userEmail.sendKeys(email);
		password.sendKeys(psw);
		submit.click();
		HomePage hp = new HomePage(driver);
		return hp;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public String geterrorMsg() {
		waitForElementToApper(errorMsg);
		return errorMsg.getText();
	}

}
