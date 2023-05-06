package Portal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TableOfContentFeature {
	
	private List<String> headings = new ArrayList<>();
	private List<String> headingsData = new ArrayList<>();
	
	@Then("buka portal dokumentasi")
	public void buka_portal_dokumentasi() {
		Driver.getInstance().navigate().to("http://103.172.204.236:8080");
	}
	
	@And("maksimalkan tampilan browser")
	public void maksimalkan_tampilan_browser() {
		Driver.getInstance().manage().window().maximize();
	}
	
	@When("pilih dokumentasi v201524011")
	public void user_berada_pada_portal_dokumentasi_v201524011() {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='v-input version-dropdown ml-auto v-input--is-label-active v-input--is-dirty v-input--dense theme--dark v-text-field v-text-field--is-booted v-text-field--enclosed v-text-field--outlined v-text-field--rounded v-select']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='v-list-item v-list-item--link theme--light' or contains(@class, 'v-list-item--active') or contains(@class, 'v-list-item--highlighted')]/div/div[text()='v201524011']"))).click();
	}
	
    @When("terdapat content dengan heading: {string}")
    public void terdapat_content_dengan_heading(String headings) {
    	for (String heading : headings.split(",")) {
    	    if (!heading.trim().equals("<empty>")) {
    	        this.headings.add(heading.trim());
    	    }
    	}
    	
    	List<WebElement> navitems = Driver.getInstance().findElements(By.xpath("//a[@class='section v-list-item v-list-item--dense v-list-item--link theme--dark' or contains(@class, 'v-list-item--active')]"));
    	Boolean found = false;
    	for(WebElement navitem : navitems) {
    		navitem.click();
    		if (checkHeadings()) {
    			found = true;
    			break;
    		}
    	}
    	assertTrue(found);
    }
    
    @Then("bandingkan dengan TOC")
    public void bandingkan_dengan_heading_TOC() {
    	List<WebElement> TOC= Driver.getInstance().findElement(By.xpath("//ul[@class='pa-0']")).findElements(By.xpath("./li"));
    	List<String> TOCData = new ArrayList<>();
    	
    	for (WebElement tocElement : TOC) {
    		TOCData.add(tocElement.getText());
    	}
    	
    	assertEquals(TOCData, headingsData);
    }
    
    private Boolean checkHeadings() {
    	WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
    	List<WebElement> headings = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content ql-editor col']"))).findElements(By.xpath("//h1 | //h2 | //h3[not(@class='white--text mb-5')] | //h4 | //h5 | //h6"));
        List<String> headingTags = new ArrayList<>();
        for (WebElement heading : headings) {
        	headingTags.add(heading.getTagName());
        	String hTagName = heading.getTagName();
        	if (hTagName.equals("h1") || hTagName.equals("h2")) headingsData.add(heading.getText());
    	}
        System.out.println(headingTags);
    	return headingTags.equals(this.headings);
    }
}
