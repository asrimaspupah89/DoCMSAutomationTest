package CreateVersion;

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

public class CreateVersionFeature {
	@Given("user berada pada halaman manage content")
	public void user_berada_pada_halaman_manage_content() {
		Driver.getInstance().manage().window().maximize();
		LoginFeature initialstep = new LoginFeature();
		initialstep.user_berada_di_home_page("mfauzirh", "fauzicakepgituloh");
		
		System.out.println("mulai click link button");
		// Mengarahkan ke halaman manage content
		WebElement button = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-3 menu-item-3\"]"));
		button.click();
	}
	
	@When("user menekan tombol create version")
	public void user_menekan_tombol_create_version() {
		WebElement button = Driver.getInstance().findElement(By.id("v-step-manage-2"));
		
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", button);
	}
	
	@And("menginputkan nama versi {word}")
	public void menginputkan_nama_versi(String versionName) {
		WebElement versionNameInput = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/form/div/div[1]/div/div/div[1]/div/input"));
		versionNameInput.sendKeys(versionName);
	}
	
	@And("menekan tombol create")
	public void menekan_tombol_create() {
		WebElement createButton = Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[2]/button[2]"));
		createButton.click();
	}
	
	@And("user menekan tombol cancel")
	public void void_user_menekan_tombol_cancel() {
		WebElement cancelButton = Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[2]/button[1]"));
		cancelButton.click();
	}
	
	@Then("pesan berhasil membuat versi baru tampil")
	public void pesan_berhasil_membuat_versi_baru_tampil() {
		WebElement snackbar = Driver.getInstance().findElement(By.className("v-snack--active"));
		Assert.assertTrue(snackbar.isDisplayed());
		
		WebElement successMessage = Driver.getInstance().findElement(By.xpath("//*[contains(text(), 'Section successfully created success')]"));
		Assert.assertTrue(successMessage.isDisplayed());
	}
	
	@Then("user tidak dapat menekan tombol create")
	public void user_tidak_dapat_menekan_tombol_create() {
		WebElement createButton = Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[2]/button[2]"));
		Assert.assertTrue(!createButton.isEnabled());
	}
	
	@Then("pesan berhasil membuat versi baru tidak tampil")
	public void pesan_berhasil_membuat_versi_baru_tidak_tampil() {
		try {
			WebElement successMessage = Driver.getInstance().findElement(By.xpath("//*[contains(text(), 'Section successfully created success')]"));
			
			// Success if message not displayed
			Assert.assertTrue(!successMessage.isDisplayed());
		} catch (NoSuchElementException e) {
			// Also success if element not found
			return;
		}
	}
}
