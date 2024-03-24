package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class HomePage extends Utilities {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productBy = By.cssSelector(".mb-3");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElement(productBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		waitForElementToApper(driver.findElement(By.cssSelector(".mb-3")));
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addTocart).click();
		waitForElement(toastMsg);
		waitForElementtoDisappear(spinner);
	}

}
