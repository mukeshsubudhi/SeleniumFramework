package ms.SeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.OrderPage;
import testComponents.BaseTest;

public class E2E extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws IOException {

		HomePage hp = lp.loginApplication(input.get("email"), input.get("psw"));

		List<WebElement> products = hp.getProductList();
		hp.addProductToCart(input.get("product"));
		CartPage cp = hp.goToCartPage();

		cp.verifyProduct(input.get("product"));

		CheckoutPage chp = cp.goTocheckout();
		chp.selectCountry("indi");

		ConfirmationPage cfp = chp.submitOrder();
		String msg = cfp.getConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {

		HomePage hp = lp.loginApplication("mukesh123@gmail.com", "Omm@12345");
		OrderPage op = hp.goToOrderPage();
		Assert.assertTrue(op.verifyProductDisplay(productName));
	}
	

	@DataProvider
	public Object[][] getData() throws IOException {

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "mukesh123@gmail.com");
//		map.put("psw", "Omm@12345");
//		map.put("product", "ZARA COAT 3");

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//product.json");
		return new Object[][] { { data.get(0) } };
	}

//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] { { "mukesh123@gmail.com", "Omm@12345", "ZARA COAT 3" }, {} };
//	}

}
