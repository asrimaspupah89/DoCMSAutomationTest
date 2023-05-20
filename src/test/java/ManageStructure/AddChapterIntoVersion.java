package ManageStructure;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;	
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import Driver.Driver;

public class AddChapterIntoVersion {
WebDriver driver = null;
	
	@Given("User has opened the browser")
	public void User_has_opened_the_browser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Documents\\GitHub\\DoCMSAutomationTest\\src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	
	@And("User has navigated on the login page")
	public void User_has_navigated_on_the_login_page() {
		
		driver.navigate().to("http://103.172.204.236:8080/login");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ryrie"); 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ryrie1234");
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"v-step-metadata-0\"]")).isDisplayed();
	}
	
	@When ("The user clicks on manage content bar")
	public void The_user_clicks_on_manage_content_bar() {
		driver.findElement(By.xpath("//*[@id=\"v-step-3 menu-item-3\"]/div[2]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"v-step-88d83ff6\"]/div[2]/button[1]")).click();
		
		
	}
	
	@And ("The user clicks on manage structure bar")
	public void The_user_clicks_on_manage_structure_bar() {
		driver.findElement(By.xpath("//*[@id=\"v-step-manage-3\"]")).click();
		
		
	}
	
	@And("The user clicks add chapters")
	public void theUserClicksAddChapters() throws InterruptedException {
	    // Scroll to the add chapters button
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement addChaptersButton = driver.findElement(By.id("v-step-manage-7"));
	    //js.executeScript("arguments[0].scrollIntoView();", addChaptersButton);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", addChaptersButton);

	    // Wait for the add chapters button to be clickable and click it
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(addChaptersButton));
//	    addChaptersButton.click();
//
//	    // Wait for the page to load
//	    Thread.sleep(5000);
	}
//	public void user_menekan_tombol_create_version() {
//		WebElement button = Driver.getInstance().findElement(By.id("v-step-manage-2"));
//		
//		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		js.executeScript("arguments[0].click();", button);
//	}
	

	
	@And ("The user clicks one chapter")
	public void The_user_clicks_one_chapter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> chapterList = driver.findElements(By.cssSelector("[role='checkbox']"));
		js.executeScript("arguments[0].click();", chapterList.get(0));
		js.executeScript("arguments[0].click();", chapterList.get(1));
		js.executeScript("arguments[0].click();", chapterList.get(2));
	}
	@Then ("The user clicks add")
	public void The_user_clicks_add() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement addChapterModalBtn = driver.findElement(By.cssSelector("button.v-btn--is-elevated:nth-child(3)"));
		js.executeScript("arguments[0].click();", addChapterModalBtn);
//	    WebElement addChaptersButton2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]/span"));
//	    //js.executeScript("arguments[0].scrollIntoView();", addChaptersButton2);
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		js.executeScript("arguments[0].click();", addChaptersButton2);
		
		
	}
}