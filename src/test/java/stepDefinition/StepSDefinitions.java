package stepDefinition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.LogInPage;
import testComponents.BaseTest;

public class StepSDefinitions extends BaseTest {

	public LogInPage lp;
	public HomePage hp;
	public CheckoutPage chp;
	public ConfirmationPage cfp;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecom_Page() {
		lp = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in(String username, String password) {
		hp = lp.loginApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void add_product_toCart(String productname) {
		List<WebElement> products = hp.getProductList();
		hp.addProductToCart(productname);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productname) {
		CartPage cp = hp.goToCartPage();
		cp.verifyProduct(productname);

		chp = cp.goTocheckout();
		chp.selectCountry("indi");

		cfp = chp.submitOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void confirmation_message(String string) {
		String msg = cfp.getConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase(string));
	}
}
