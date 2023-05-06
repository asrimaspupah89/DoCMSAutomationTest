package ManageContent;

import static org.junit.Assert.assertNull;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenghapusSectionFeature {
	
	private WebElement removableSection = null;
	private String removableSectionText = "";
	
	@When("klik tombol manage content")
	public void klik_tombol_manage_content() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-3\"]")).click();
	}
	
	@Then("klik tab manage structure")
	public void klik_tab_manage_structure() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-manage-3\"]")).click();
	}
		
	@And("klik dropdown versi")
	public void klik_dropdown_versi() {
		Driver.getInstance().findElement(By.xpath("//div[@class=\"v-input__slot\"]")).click();
	}
	
	@When("klik versi v201524011")
	public void klik_versi_v201524011() {
		try {
	        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='v-list-item__title' and text()='v201524011']")));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	    }
		catch (NoSuchElementException e) {
	        throw new NoSuchElementException("Versi 'v201524011' tidak ditemukan, pastikan terdapat versi tersebut");
	    }
		catch (TimeoutException e) {
	    	throw new TimeoutException("Tidak dapat menemukan versi dalam waktu tunggu yang diminta");
	    }
	}
	
	@When("list yang memiliki satu section ditemukan")
	public void list_yang_memiliki_satu_section_ditemukan() {
		List<WebElement> elements = Driver.getInstance().findElements(By.xpath("//div[@class='v-list-group__header v-list-item v-list-item--link theme--dark']"));
		for (WebElement e : elements) {
			e.click();
		    List<WebElement> childElements = e.findElements(By.xpath("//div[@class='v-list-group v-list-group--active primary--text']/div[@class='v-list-group__items']/div[@class='v-list-item theme--dark']"));
			if (childElements.size() == 1) {
				removableSection = childElements.get(0);
				removableSectionText = removableSection.getText();
				break;
			}
		}
	}
	
	@When("list yang memiliki dua section ditemukan")
	public void list_yang_memiliki_dua_section_ditemukan() {
		List<WebElement> elements = Driver.getInstance().findElements(By.xpath("//div[@class='v-list-group__header v-list-item v-list-item--link theme--dark']"));
		for (WebElement e : elements) {
			e.click(); 
		    List<WebElement> childElements = e.findElements(By.xpath("//div[@class='v-list-group v-list-group--active primary--text']/div[@class='v-list-group__items']/div[@class='v-list-item theme--dark']"));
			if (childElements.size() == 2) {
				removableSection = childElements.get(1);
				removableSectionText = removableSection.getText();
				break;
			}
		}
	}
	
	@Then("klik tombol hapus pada section")
	public void klik_tombol_hapus_pada_section() throws Exception {
		if (removableSection == null || removableSectionText.equals("")) throw new Exception("Section tidak ditemukan");
		removableSection.findElement(By.xpath("./button")).click();
	}
	
	@Then("periksa keberhasilan penghapusan section")
	public void periksa_keberhasilan_penghapusan_section() {
		assertNull(cariSection(removableSectionText));
	}
	
	private WebElement cariSection(String sectionName) {
		WebElement ele = null;
		List<WebElement> childElements = Driver.getInstance().findElements(By.xpath("//div[@class='v-list-group v-list-group--active primary--text']/div[@class='v-list-group__items']/div[@class='v-list-item theme--dark']"));
		for(WebElement e : childElements) {
			if (e.getText() == sectionName) {
				ele = e;
			}
		};
		return ele;
	}
}