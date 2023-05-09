package DeleteSection;

import Driver.Driver;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import CreateVersion.CreateVersionFeature;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteSectionFeature {
	@And("terdapat section kosong dengan nama {word}")
	public void terdapat_section_kosong_dengan_nama(String sectionName) {
		CreateVersionFeature initialstep = new CreateVersionFeature();
		initialstep.user_menekan_tombol_create_version();
		initialstep.menginputkan_nama_versi(sectionName);
		initialstep.menekan_tombol_create();
		initialstep.pesan_berhasil_membuat_versi_baru_tampil();
	}
	
	@When("user menekan tombol delete pada version dengan nama {word}")
	public void user_menekan_tombol_delete_pada_version_dengan_nama(String versionName) {
		// Find the div element containing the versionName text
		WebElement divElement = Driver.getInstance().findElement(By.xpath("//div[contains(text(), '" + versionName + "')]"));

		// Find the delete button within the parent div element
		WebElement deleteButton = divElement.findElement(By.xpath("./following-sibling::div/button[contains(@class, 'delete-btn')]"));

		// Click the delete button
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("arguments[0].click();", deleteButton);
	}
	
	@Then("pesan berhasil menghapus versi tampil")
	public void pesan_berhasil_menghapus_versi_tampil() {
		WebElement snackbar = Driver.getInstance().findElement(By.className("v-snack--active"));
		Assert.assertTrue(snackbar.isDisplayed());
		
		WebElement successMessage = Driver.getInstance().findElement(By.xpath("//*[contains(text(), 'Version successfully deleted success ')]"));
		Assert.assertTrue(successMessage.isDisplayed());
	}
}
