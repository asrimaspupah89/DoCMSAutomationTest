package Chapter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class EditChapterFeature {
	@And("klik edit pada chapter chapt_test")
	public void klik_edit_pada_chapter_chapt_test() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-2\"]/div[3]/table/tr/td[4]/div/button[1]")).click();
	}
	
	@And("mengganti judul menjadi {word}")
	public void mengganti_judul(String judul) {
		if(judul.equals("[blank]")) {
			judul = "";
		}
		WebElement textField = Driver.getInstance().findElement(By.xpath("/html/body/div/div/div[3]/div/div/div[2]/div/div[1]/div/input"));
		textField.click();
//		textField.clear();
		textField.sendKeys(Keys.CONTROL + "a");
		textField.sendKeys(Keys.DELETE);
		textField.sendKeys(judul);
	}
	
	@And("klik tombol update")
	public void klik_tombol_update() {
//		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/button")).click();
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/button"));
		Actions actions = new Actions(Driver.getInstance());
		actions.moveToElement(element).click().build().perform();
	}
	
	@And("user tetap berada di form edit")
	public void tetap_di_form_edit() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/button")).isDisplayed();
	}
	
	@Then("tombol update disabled")
	public void tombol_update_disabled() {
		WebElement updateButton = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/button"));
		boolean isButtonDisabled = !updateButton.isEnabled();
		System.out.println("Is button disabled? " + isButtonDisabled);
	}
}
