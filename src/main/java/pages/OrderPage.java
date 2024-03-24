package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class OrderPage extends Utilities {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr//td[2]")
	private List<WebElement> productsTitle;

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = productsTitle.stream().anyMatch(m -> m.getText().equals(productName));
		return match;
	}
}
