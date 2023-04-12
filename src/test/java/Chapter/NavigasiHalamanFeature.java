package Chapter;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigasiHalamanFeature {

	@When("membuka sidebar")
	public void membuka_sidebar() {
		
		String classList = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/aside")).getAttribute("class");
		Boolean isClosed = classList.contains("v-navigation-drawer--close");
		if(isClosed) {
			Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/header/div/button")).click();
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-navigation-drawer--open")));
		}
	}
	@Then("sidebar terbuka")
	public void sidebar_terbuka() {
		String classList = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/aside")).getAttribute("class");
		Boolean isOpened = classList.contains("v-navigation-drawer--open");
		Assert.assertTrue(isOpened);
	}
	
	// next navigation page
	
	@When("klik tombol chapter")
	public void klik_tombol_chapter() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-1\"]")).click();
	}

	@When("klik tombol next page")
	public void klik_tombol_next_page() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li[last()]/button/i"));

		js.executeScript("arguments[0].click();", element);
	}

	@Then("sistem menampilkan halaman dua dari chapter")
	public void sistem_menampilkan_halaman_dua_dari_chapter() {
		List<WebElement> list = Driver.getInstance().findElements(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li"));
		for(WebElement el: list) {
			el = el.findElement(By.xpath("./button"));
			if(el.getText().equals("2")) {
				Assert.assertEquals("true", el.getAttribute("aria-current"));
				return;
			}
		}
		Assert.fail("Element not found");
	}
}
