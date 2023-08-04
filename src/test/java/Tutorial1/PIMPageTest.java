package Tutorial1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass2;

@Test(groups = { "PIMPage", "EndToEndTesting" }, dependsOnGroups = { "HomePage" })
	public class PIMPageTest extends BaseClass2 {

		@Test(priority = 1)
		public void validateUserIsOnPIMPage() {
			driver.findElement(By.xpath("//span[text()='PIM']")).click();

			String actualUrl = driver.getCurrentUrl();

			Assert.assertEquals(actualUrl.contains("pim"), true);
		}

		@Parameters({ "fname", "mname", "lname" })
		@Test(priority = 2)
		public void validateNewUser(String fname, String mname, String lname) throws InterruptedException {
			driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

			driver.findElement(By.name("firstName")).sendKeys(fname);
			driver.findElement(By.name("middleName")).sendKeys(mname);
			driver.findElement(By.name("lastName")).sendKeys(lname);

			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	
		}

		@Parameters({ "country" })
		@Test(priority = 3)
		public void validateAddMoreDetailsFunctionality(String country) throws InterruptedException {
			driver.findElement(By.xpath("//label[text()='Nationality']/following::div[5]")).click();
			
			Thread.sleep(10000);
			List<WebElement> ls = driver.findElements(By.xpath("//div[@role='listbox']//div/span"));

		
			for ( WebElement abc1 : ls) {
				String countrylist = abc1.getText();

				if (countrylist.equals(country)) {
					abc1.click();
					break;
				}
			}

			Thread.sleep(10000);
			
		}

}
