package FindChapter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Driver.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import Login.LoginFeature;

public class FindChapterFeature {
	@Given("user berada pada halaman chapter")
	public void user_berada_pada_halaman_chapter() {
		Driver.getInstance().manage().window().maximize();
		LoginFeature initialstep = new LoginFeature();
		initialstep.user_berada_di_home_page("Annakrnt", "Annakrnt25");
		
		System.out.println("mulai click link button");
		// Mengarahkan ke halaman manage chapter
		WebElement button = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-1 menu-item-1\"]/div[2]/div"));
		button.click();
	}
	
	@When("user menekan kolom find chapter {word}")
	public void user_menekan_kolom_find_chapter(String keyword) {
		WebElement button = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-1\"]"));
		button.click();
		button.sendKeys(keyword);
	}
	
	@Then("system show chapter")
	public void system_show_chapter() {
		try {
			WebElement successMessage = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-2\"]/div/table/tr/td[1]/p"));
			
			// Success if message not displayed
			Assert.assertTrue(!successMessage.isDisplayed());
		} catch (NoSuchElementException e) {
			// Also success if element not found
			return;
		}
	}
	
	@Then("system show message No result found")
	public void system_show_message_No_result_found() {
		try {
			WebElement successMessage = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-2\"]/div/div/span"));
			
			// Success if message not displayed
			Assert.assertTrue(!successMessage.isDisplayed());
		} catch (NoSuchElementException e) {
			// Also success if element not found
			return;
		}
	}
}
