package Tutorial1;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass2;

@Test(groups = { "HomePage", "EndToEndTesting" }, dependsOnGroups = { "LoginPage" })
	public class HomePageTest extends BaseClass2 {

		@Test(priority = 1)
		public void validateHomePageTitle() {
			String actualTitle = driver.getTitle();

			Assert.assertEquals(actualTitle, "OrangeHRM");
		}

		@Test(priority = 2, groups = { "HomePage", "EndToEndTesting" })
		public void validateHomePageUrl() {
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl.contains("hrm"), true);

		}

}
