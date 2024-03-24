package ms.SeleniumFramework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import testComponents.BaseTest;
import testComponents.Retry;

public class ErrorValidations extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void LoginValidation() throws IOException {

		lp.loginApplication("mukesh1234@gmail.com", "Omm@12345");

		Assert.assertEquals("Incorrect email  password.", lp.geterrorMsg());
	}

	@Test
	public void ProductValidation() throws IOException {

		String productName = "ZARA COAT 3";

		HomePage hp = lp.loginApplication("mukesh123@gmail.com", "Omm@12345");

		List<WebElement> products = hp.getProductList();
		hp.addProductToCart(productName);
		CartPage cp = hp.goToCartPage();

		Boolean match = cp.verifyProduct("ZARA COAT 33");
		Assert.assertFalse(match);
	}

}
