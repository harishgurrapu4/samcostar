package samcostar.samcostar;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorporateAction extends TestBase{
	
TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	@CacheLookup
	WebElement Dropdown1;
	
	public CorporateAction() {
		PageFactory.initElements(driver, this);
	}
	
	public void Corporateaction() throws Exception{
		
		Thread.sleep(3000);

	   driver.findElement(By.xpath("//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	   Thread.sleep(3000);
	   for (int i=1; i< 4; i++){
		   
			JavascriptExecutor jse = (JavascriptExecutor)driver;			
			//jse.executeScript("document.body.style.zoom = '0.75'");
			jse.executeScript("window.scrollBy(0,200)");
			Thread.sleep(3000);
			
			 WebElement Dropdown = driver.findElement(By.xpath("//span[contains(text(),'IPO / OFS / BUYBACK')]"));
			  Actions ac = new Actions(driver) ;
			  ac.moveToElement(Dropdown).build().perform();
		   
			   if (i==1){
				   driver.findElement(By.linkText("IPO")).click();
				  // Cashplus.click();
			       Thread.sleep(3000);
			       driver.navigate().back();
			      // Thread.sleep(3000);
			   }
			   else if (i==2)
			   {
				   driver.findElement(By.linkText("OFS")).click();
				   //Intraplus.click();
				   Thread.sleep(3000);
				   driver.findElement(By.xpath("//button[contains(text(),'Order Book')]")).click();
				   Thread.sleep(3000);
			       driver.findElement(By.xpath("//a[contains(text(),'Back')]")).click();
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//a[contains(text(),'View All OFS')]")).click();
			       Thread.sleep(3000);
			       driver.findElement(By.linkText("BSE")).click();
			       Thread.sleep(3000);
			       
			       ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			       driver.switchTo().window(tabs2.get(0)); //Tab number
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//a[contains(text(),'About OFS')]")).click();
			       Thread.sleep(3000);
			       driver.switchTo().window(tabs2.get(0));
			       
			   }
			   else if (i==3)
			   {
				  WebElement BB = driver.findElement(By.xpath("//a[contains(text(),'BUYBACK')]"));
				  jse.executeScript("arguments[0].click()", BB);
				   //Intraplus.click();
				   Thread.sleep(3000);
				   driver.findElement(By.xpath("//button[contains(text(),'Order Book')]")).click();
				   Thread.sleep(3000);
			       driver.findElement(By.xpath("//a[contains(text(),'Go back')]")).click();
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//a[contains(text(),'View all Buy Back')]")).click();
			       Thread.sleep(3000);
			      // Alert al = driver.switchTo().alert();
			      // Thread.sleep(3000);
			       driver.findElement(By.linkText("BSE")).click();
			       Thread.sleep(3000);
			       ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			       driver.switchTo().window(tabs2.get(0)); //Tab number
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//body/div[3]/div[1]/div[5]/div[2]/div[1]/div[1]/button[1]")).click();
			       Thread.sleep(3000);
			   }

		    }
	       
	 }
}

