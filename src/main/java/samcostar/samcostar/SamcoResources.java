package samcostar.samcostar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamcoResources extends TestBase {
	
TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	@CacheLookup
	WebElement Dropdown1;
	
	public SamcoResources() {
		PageFactory.initElements(driver, this);
	}
	
	public void SamcoResourcestest() throws Exception{
		
	   Thread.sleep(3000);

	   driver.findElement(By.xpath("//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	   Thread.sleep(3000);
	   for (int i=1; i< 4; i++){
			
			 WebElement Dropdown = driver.findElement(By.xpath("//li[@id='list_resources']"));
			  Actions ac = new Actions(driver) ;
			  ac.moveToElement(Dropdown).build().perform();
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			   if (i==1)
			   {
				   WebElement SPM = driver.findElement(By.linkText("SAMCO PLEDGE MONITOR"));
				   jse.executeScript("arguments[0].click()", SPM);
			       Thread.sleep(3000);
			   }
			   else if (i==2)
			   {
				   WebElement SRA = driver.findElement(By.linkText("SAMCO RISK ADVISER"));
					jse.executeScript("arguments[0].click()", SRA);
				    Thread.sleep(3000);
			   }
			   else if (i==3)
			   {
				WebElement SDB =   driver.findElement(By.linkText("SAMCO DATA BANK"));
				jse.executeScript("arguments[0].click()", SDB);
			    Thread.sleep(3000);
			   }

		    }
	       
	 }
}

