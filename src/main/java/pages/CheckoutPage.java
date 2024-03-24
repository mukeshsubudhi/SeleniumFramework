package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class CheckoutPage extends Utilities {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement scountry;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	@FindBy(css = ".action__submit")
	WebElement checkout;

	By results = By.cssSelector(".ta-result");

	public void selectCountry(String country) {
		scountry.sendKeys(country);
		waitForResult();
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		checkout.click();
		return new ConfirmationPage(driver);
	}

}
