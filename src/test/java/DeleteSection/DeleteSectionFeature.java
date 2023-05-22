package DeleteSection;

import Driver.Driver;
import Login.LoginFeature;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteSectionFeature {
	WebDriver driver = null;
	@Given("user berada pada halaman section")
	public void user_berada_pada_halaman_section() {
		Driver.getInstance().manage().window().maximize();
		LoginFeature initialstep = new LoginFeature();
		initialstep.user_berada_di_home_page("Annakrnt", "Annakrnt25");
		
		System.out.println("mulai click link button");
		// Mengarahkan ke halaman manage chapter
		WebElement button = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-2 menu-item-2\"]/div[2]/div"));
		button.click();
	}
	
	@When("user menekan tombol delete pada section dengan nama {word}")
	public void user_menekan_tombol_delete_pada_section_dengan_nama(String keyword) {
//		// Find the div element containing the sectionName text
//		WebElement divElement = Driver.getInstance().findElement(By.xpath("//div[contains(text(), '" + sectionName + "')]"));
//
		WebElement button = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-1\"]"));
		button.click();
		button.sendKeys(keyword);
		
		// Find the delete button within the parent div element
		WebElement deleteButton = button.findElement(By.xpath("//*[@id=\"v-step-chapter-2\"]/div/table/tr/td[4]/div/button/span"));
		
		// Click the delete button
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("arguments[0].click();", deleteButton);
	}
}
