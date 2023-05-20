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

import Driver.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Section {
	private List<String> headings = new ArrayList();
	private List<String> headingsDataTag = new ArrayList();
	private List<String> headingsData = new ArrayList();
	WebDriver driver = null;
	
	@Given("browser terbuka")
	public void browser_terbuka() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver_win32\\chromedriverRftya113.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	 
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@When("buka portal docms")
	public void buka_portal_docms() {
		driver.navigate().to("http://103.172.204.236:8080");
	}
	
	@And("maksimalkan tampilan")
	public void maksimalkan_tampilan() {
		driver.manage().window().maximize();
	}
	
	@And("pilih section {string}")
	public void pilih_section(String sections) {
	   List <WebElement> element = driver.findElements(By.xpath("//a[@class=\"section v-list-item v-list-item--dense v-list-item--link theme--dark\"]"));
	   for (WebElement e:element) {
		   WebElement divElement = e.findElement(By.cssSelector("div"));
           String script = "return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');";
           String content = (String) ((JavascriptExecutor) driver).executeScript(script, divElement);

           if (content != null && content.equals(sections)) {
               e.click();
               break;
           }
	   }
	    
	}

	
    @Then("bandingkan dengan Konten")
    public void bandingkan_dengan_heading_konten() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement sectionElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='section v-item--active v-list-item--active v-list-item v-list-item--dense v-list-item--link theme--dark']/div[@class='v-list-item__content']/div[@class='v-list-item__title section-title']")));
        String sectionText = sectionElement.getText();

        String afterContent = getTextOfAfterPseudoElement(sectionElement);
        String sectionTextWithAfter = sectionText + afterContent;
		
		sectionTextWithAfter.equals(afterContent);
    
    }
    
    private String getTextOfAfterPseudoElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content')";
        return (String) js.executeScript(script, element);
    }
 
}
