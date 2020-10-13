package samcostar.samcostar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import samcostar.samcostar.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="uname")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="login_btn")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/img[1]")
	WebElement samcoLogo;
	
	@FindBy(xpath="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/img[2]")
	WebElement starLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSamcoImage(){
		return samcoLogo.isDisplayed();
	}
	
	public boolean validateStarImage(){
		return starLogo.isDisplayed();
	}
	
	public void BlankLogin() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
    	Alert alert = driver.switchTo().alert();
	    String alertMessage =	driver.switchTo().alert().getText();
	    System.out.println(alertMessage);	
        Thread.sleep(3000);       				
        alert.accept();
    	
	}
	
	public void WrongPasswlogin(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd+"t");
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		   String errormsg = 	driver.findElement(By.xpath("//span[contains(text(),'Wrong Password.')]")).getText();
		   System.out.println(errormsg);
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}