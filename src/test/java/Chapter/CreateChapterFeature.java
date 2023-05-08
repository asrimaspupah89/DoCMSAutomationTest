package Chapter;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import Driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class CreateChapterFeature {
	@And("klik tombol add new")
	public void klik_tombol_add_new() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-0\"]/span")).click();
	}
	
	@And("user menginputkan judul chapter {word} dan memilih versi {word}")
	public void input_judul_dan_versi(String judul, String versi) {
		if(judul.equals("[blank]")) {
			judul = "";
		}
		
		Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[2]/div[1]/div/div[1]/div/input")).sendKeys(judul);
		
		if(versi.equals("[blank]") == false) {
			Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/form/div/div[2]/div[2]/div/div[1]/div[1]")).click();
			Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[4]/div/div[2]/div/div")).click();
		}
	}
	
	@And("klik tombol save")
	public void klik_save() {
		Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[3]/button")).click();
	}

	@Then("sistem dinavigasikan ke halaman manage chapter")
	public void navigasi_ke_halaman_manage_chapter() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-0\"]")).isDisplayed();
	}
	
	@Then("user tetap berada di form pengisian")
	public void user_di_form_pengisian() {
		Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[3]/button")).isDisplayed();
	}
	
	@Then("tombol save disabled")
	public void save_disabeld() {
		WebElement saveButton = Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/form/div/div[3]/button"));
		boolean isButtonDisabled = !saveButton.isEnabled();
		System.out.println("Is button disabled? " + isButtonDisabled);
	}
	
}
