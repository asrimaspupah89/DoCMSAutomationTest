package ManageStructure;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddSection {
WebDriver driver = null;
	
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:\\semester 6\\DoCMSAutomationTest\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.manage().window().maximize(); 
	}
	
	
	public void user_is_on_login_page() {
		
		driver.navigate().to("http://103.172.204.236:8080/login/");
	
	}
	
	
	public void user_enters_username_and_password(String username, String password) {
		if(username.equals("<blank>")){
			username = "";
		} 
		if(password.equals("<blank>")){
			password = "";
		} 
		driver.findElement(By.xpath("//*[@id=\"input-9\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"input-12\"]")).sendKeys(password);

	}

	public void user_clicks_on_login_button() {
		
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
	
	}
	
	
	public void user_is_navigated_to_the_home_page() {
		
		driver.findElement(By.xpath("//*[@id=\"v-step-0 menu-item-0\"]/div[2]")).isDisplayed();
	}
	
	@Given("browser is on meta page")
	public void browser_is_on_meta_page() {
		this.browser_is_open();
		this.user_is_on_login_page();
		this.user_enters_username_and_password("Hasanahhz", "Cicak123");
		this.user_clicks_on_login_button();
		this.user_is_navigated_to_the_home_page();
	}
	
	@And("user clicks on manage content button")
	public void user_clicks_on_manage_content_button() {
		driver.findElement(By.xpath("//*[@id=\"v-step-3 menu-item-3\"]")).click();
	} 
	
	@And("user click skip Manage Version tour")
	public void user_click_Manage_Version_tour(){
		driver.findElement(By.xpath("//*[@id=\"v-step-88d83ff6\"]/div[2]/button[1]")).click();
	}

	@And("user clicks on manage stucture button")
	public void user_clicks_on_manage_stucture_button() {
		driver.findElement(By.xpath("//*[@id=\"v-step-manage-3\"]")).click();
	}
	
	@And("user clicks on add section button")
	public void user_clicks_on_add_section_button() {
		driver.findElement(By.xpath("//*[@id=\"v-step-manage-6\"]/div[1]/div/div[2]/button[1]")).click();
	}
	
	
	@And("user clicks on section into chapter button")
	public void user_clicks_on_section_into_chapter_button() {
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"input-401\"]"));
		if (checkbox != null) {
		   checkbox.click();
		} else {
		   System.out.println("Element not found");
		}
////	    WebElement popup = driver.findElement(By.xpath("//*[@id=\"app\"]/div[9]/div"));
////	    WebElement checkbox = popup.findElement(By.id("input-401"));
//		 WebElement checkbox = findElement(By.id("input-401"));
//	    checkbox.click();
	}

//	public void user_clicks_on_section_in_to_chapter_button() {
//		 driver.findElement(By.id("//*[@id=\"input-401\"]"));
//
//	        WebElement checkbox = null;
//			// Mengklik checkbox
//	        checkbox.click();
//	}
	
	private WebElement findElement(By id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Then("user clicks on add button")
	public void user_clicks_on_add_button() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[9]/div/div/div[2]/button[2]")).click();
	}
	
//	@Then("user clicks on save changes button")
//	public void user_clicks_on_save_changes_button () {
//    	Assert.assertTrue(true);
////    	driver.close();
//  	//driver.findElement(By.xpath("//*[@id=\"form-submit\"]/span")).click();
//    }
}
