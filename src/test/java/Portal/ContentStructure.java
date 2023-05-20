package Portal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContentStructure {
	private List<String> headings = new ArrayList();
	private List<String> headingsDataTag = new ArrayList();
	private List<String> headingsData = new ArrayList();
	WebDriver driver = null;
	
	@Given("browser opened")
	public void browser_opened() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver_win32\\chromedriverRftya113.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	 
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@When("portal docms")
	public void portal_docms() {
		driver.navigate().to("http://103.172.204.236:8080");
	}
	
	@And("fullscreen tampilan")
	public void fullscreen_tampilan() {
		driver.manage().window().maximize();
	}

	@Then("periksa keberadaan content structure")
	public void periksa_keberadaan_content_structure() {
		WebElement contentstructure = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/aside/div[1]"));
	    if (contentstructure.isDisplayed()) {
	        System.out.println("Content structure berhasil ditampilkan");
	    } else {
	        System.out.println("Content structure gagal ditampilkan");
	    }
	}
	
	
	@Then ("cari judul dan subjudul pada sidebar")
	public void cari_judul_subjudul() {
	    WebElement titleElement = driver.findElement(By.xpath("//*[@id='app']/div/div[1]/aside/div[1]/div[2]/div[1]"));
	    WebElement subtitleElement = driver.findElement(By.xpath("//*[@id='app']/div/div[1]/aside/div[1]/div[2]/div[2]"));

	    if (titleElement.isDisplayed() && subtitleElement.isDisplayed()) {
	        System.out.println("Judul dan Sub Judul ditemukan");
	    } else {
	        System.out.println("Judul dan Sub Judul gagal ditemukan");
	    }

	}

 
}
