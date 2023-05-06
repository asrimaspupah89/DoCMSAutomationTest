package DeleteVersion;

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

public class DeleteVersionFeature {
	@And("terdapat versi kosong dengan nama {word}")
	public void terdapat_versi_kosong_dengan_nama(String versionName) {
		CreateVersionFeature initialstep = new CreateVersionFeature();
		initialstep.user_menekan_tombol_create_version();
		initialstep.menginputkan_nama_versi(versionName);
		initialstep.menekan_tombol_create();
		initialstep.pesan_berhasil_membuat_versi_baru_tampil();
	}
	
	@And("terdapat versi berisi satu chapter dengan nama {word}")
	public void terdapat_versi_berisi_satu_chapter_dengan_nama(String versionName) {
		terdapat_versi_kosong_dengan_nama(versionName);
		
		WebElement button = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-3\"]"));
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, 0)");
		js.executeScript("arguments[0].click();", button);
		
		WebElement select = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-4\"]"));
		js.executeScript("arguments[0].click();", select);
		
		List<WebElement> list = Driver.getInstance().findElements(By.className("v-list-item"));
		for(WebElement el: list) {
			if(el.getText().equals(versionName)) {
				js.executeScript("arguments[0].click();", el);
			}
		}
		
		WebElement addChapBtn = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-7\"]"));
		js.executeScript("arguments[0].click();", addChapBtn);
		
		List<WebElement> chapList = Driver.getInstance().findElements(By.cssSelector("[role='checkbox']"));
		js.executeScript("arguments[0].click();", chapList.get(0));
		
		WebElement addChapModalBtn = Driver.getInstance().findElement(By.cssSelector("button.v-btn--is-elevated:nth-child(3)"));
		System.out.println(addChapModalBtn.getText());
		js.executeScript("arguments[0].click();", addChapModalBtn);
		
		WebElement manageVersionBtn = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-0\"]"));
		js.executeScript("arguments[0].click();", manageVersionBtn);
	}
	
	@And("terdapat versi berisi lebih dari satu chapter dengan nama {word}")
	public void terdapat_versi_berisi_lebih_dari_satu_chapter_dengan_nama(String versionName) {
		terdapat_versi_kosong_dengan_nama(versionName);
		
		WebElement button = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-3\"]"));
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, 0)");
		js.executeScript("arguments[0].click();", button);
		
		WebElement select = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-4\"]"));
		js.executeScript("arguments[0].click();", select);
		
		List<WebElement> list = Driver.getInstance().findElements(By.className("v-list-item"));
		for(WebElement el: list) {
			if(el.getText().equals(versionName)) {
				js.executeScript("arguments[0].click();", el);
			}
		}
		
		WebElement addChapBtn = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-7\"]"));
		js.executeScript("arguments[0].click();", addChapBtn);
		
		List<WebElement> chapList = Driver.getInstance().findElements(By.cssSelector("[role='checkbox']"));
		js.executeScript("arguments[0].click();", chapList.get(0));
		js.executeScript("arguments[0].click();", chapList.get(1));
		
		
		WebElement addChapModalBtn = Driver.getInstance().findElement(By.cssSelector("button.v-btn--is-elevated:nth-child(3)"));
		js.executeScript("arguments[0].click();", addChapModalBtn);
		
		WebElement manageVersionBtn = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-0\"]"));
		js.executeScript("arguments[0].click();", manageVersionBtn);
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
