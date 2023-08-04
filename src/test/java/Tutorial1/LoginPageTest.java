package Tutorial1;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass2;

public class LoginPageTest extends BaseClass2 {

	@BeforeTest(groups = { "LoginPage", "EndToEndTesting" })
	public void setUp() {
		BaseClass2.initialization();
	}

	@Parameters({ "username", "password" })
	@Test(priority = 1, groups = { "LoginPage", "EndToEndTesting" })
	public void loginFunctionality(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	@AfterTest(groups = { "LoginPage", "EndToEndTesting" })
	public void tearDown() {
		// driver.close();

	}
}