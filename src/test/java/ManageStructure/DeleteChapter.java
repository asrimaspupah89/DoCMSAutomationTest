package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteChapter {
	WebDriver driver = null;

	@Given("browser is opened")
	public void browser_is_opened() {

		System.setProperty("webdriver.chrome.driver","D:\\AUTOMATION-TESTING\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	 
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	@And("user is on cms page")
	public void user_is_on_cms_page() {

		driver.navigate().to("http://103.172.204.236:8080/login");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mfauzirh"); 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("fauzicakepgituloh");
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"v-step-metadata-0\"]")).isDisplayed();
	}
	
	@When ("user clicks on manage content")
	public void user_clicks_on_manage_content() {
		driver.findElement(By.xpath("//*[@id=\"v-step-3 menu-item-3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"v-step-88d83ff6\"]/div[2]/button[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"v-step-88d83ff6\"]/div[2]/button[1]")).click();
		
	}
	
	@And ("user clicks on manage structure bar")
	public void user_clicks_on_manage_structure_bar() {
		driver.findElement(By.xpath("//*[@id=\"v-step-manage-3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"list-item-327-17\"]")).click();
	}
	
	@Then ("user clicks delete button on chapter list")
	public void user_clicks_delete_button_on_chapter_list() {
		driver.findElement(By.xpath("//*[@id=\"v-step-manage-6\"]/div[1]/div/div[2]/button[2]/span")).click();
	}
}
	
