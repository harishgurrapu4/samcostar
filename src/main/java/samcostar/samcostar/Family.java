package samcostar.samcostar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Family extends TestBase {
TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	@CacheLookup
	WebElement Dropdown1;
	
	public Family() {
		PageFactory.initElements(driver, this);
	}
	
	public void Familytest() throws Exception{
		
	   Thread.sleep(3000);

	   driver.findElement(By.xpath("//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	   Thread.sleep(3000);
	   for (int i=1; i< 3; i++){
			
			 WebElement Dropdown = driver.findElement(By.xpath("//li[@id='list_family']"));
			  Actions ac = new Actions(driver) ;
			  ac.moveToElement(Dropdown).build().perform();
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			   if (i==1)
			   {
				   WebElement FA = driver.findElement(By.linkText("Family Admin"));
				   jse.executeScript("arguments[0].click()", FA);
			       Thread.sleep(3000);
			   }
			   else if (i==2)
			   {
				   WebElement FM = driver.findElement(By.linkText("Family Membership"));
					jse.executeScript("arguments[0].click()", FM);
				    Thread.sleep(3000);
			   }

		    }
	       
	 }
}


