package stepDefinition;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User access the browser")
	public void user_access_the_browser() {
		System.setProperty("webdriver.chrome.driver", "/Users/naveenraj/Downloads/chromedriver_mac64/chromedriver");
	    driver = new ChromeDriver();
		lp=new LoginPage(driver);
	    
	}

	@When("user in login page {string}")
	public void user_in_login_page(String url) throws InterruptedException {
		driver.get(url);
	    Thread.sleep(6000);
	    
	   driver.getTitle();
	}

	
	@Then("enter username {string} and password {string}")
	public void enter_username_and_password(String email, String password) throws InterruptedException {
	    lp.setUserName(email);
	    lp.setPassword(password);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='MuiTouchRipple-root'])[2]")));
	    
	}

	@And("click the login button")
	public void click_the_login_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"MuiTypography-root MuiTypography-body1\"])[7]")));
		lp.clickLogin();
		
	}
	
	@Then("select TPM from Dropdown")
	public void selectDropdown() {
		
		
	}

	@Then("Close the browser")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}



}
