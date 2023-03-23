package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait wait;
	
	@Given("User access the browser")
	public void user_access_the_browser() {
		System.setProperty("webdriver.chrome.driver", "/Users/naveenraj/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		lp=new LoginPage(driver);
	    wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("user in login page {string}")
	public void user_in_login_page(String url) throws InterruptedException {
		driver.get(url);
	    Thread.sleep(6000);
	    
	   driver.getTitle();
	}

	
	@Then("enter username {string} and password {string}")
	public void enter_username_and_password(String email, String password) throws InterruptedException, IOException {
	    lp.setUserName(email);
	    lp.setPassword(password);
	    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='MuiTouchRipple-root'])[2]")));
		File ss = new File("//Users//naveenraj//Documents//SS");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File as = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, as);
		Thread.sleep(3000); 
	}

	@And("click the login button")
	public void click_the_login_button() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1\"])[7]")));
		lp.clickLogin();
		 
		
	}
	
	
	@And ("select from Dropdown")
		public void select_from_dropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='button']")));
			lp.select();
				
		}

	@Then("Click Get Started")
	public void close_the_browser() throws InterruptedException  {
		Thread.sleep(3000);
		lp.dropdown();
		lp.Get();
		
	}

	@And("Search for the Site")
	public void search_Site() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@type='button'])[3]")));
		lp.start();
		
	}
	

}
