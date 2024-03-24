package pages;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class CartPage extends Utilities {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	private List<WebElement> productsTitle;

	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	public Boolean verifyProduct(String productName) {
		Boolean match = productsTitle.stream().anyMatch(m -> m.getText().equals(productName));
		return match;
	}

	public CheckoutPage goTocheckout() {
		checkOut.click();
		return new CheckoutPage(driver);
	}
}
