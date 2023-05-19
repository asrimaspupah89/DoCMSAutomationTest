package Chapter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class DeleteChapter {
WebDriver driver = null;
	
	@Given("The browser is opened")
	public void The_browser_is_opened() {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Documents\\GitHub\\DoCMSAutomationTest\\src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	
	@And("The user is on cms page")
	public void The_user_is_on_cms_page() {

		driver.navigate().to("http://103.172.204.236:8080/login");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ryrie"); 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ryrie1234");
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"v-step-metadata-0\"]")).click();
	}
	
	@When ("The user clicks on chapter page")
	public void The_user_clicks_on_chapter_page() {
		driver.findElement(By.xpath("//*[@id=\"v-step-1 menu-item-1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"v-step-2e03e813\"]/div[2]/button[1]")).click();
		
	}
	
	@And ("The user clicks on list chapter")
	public void The_user_clicks_on_list_chapter() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test026");
		
	}
	
	@Then ("user clicks delete button on chapter list")
	public void user_clicks_delete_button_on_chapter_list() {
		driver.findElement(By.xpath("//*[@id=\"v-step-chapter-2\"]/div/table/tr/td[4]/div/button[2]")).click();
	}
	
}