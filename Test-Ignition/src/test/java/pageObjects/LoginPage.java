package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@type='email']")
	@CacheLookup
	WebElement textEmail;
	
	@FindBy(xpath="//*[@type='password']")
	@CacheLookup
	WebElement textPass;
	
	@FindBy(xpath="(//*[@class=\"MuiTypography-root MuiTypography-body1\"])[7]")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="(//*[@class='MuiGrid-root'])[3]")
	@CacheLookup
	WebElement Dropdown;
	
	public void setUserName(String uname) {
		textEmail.clear();
		textEmail.sendKeys(uname);
	}
	public void setPassword(String pass) {
		textPass.clear();
		textPass.sendKeys(pass);
	}
	
	public void dropDown(String Triomics) {
		Dropdown.click();
	}
	public void clickLogin() {
		loginButton.click();
	}
	
	
	
	
}
