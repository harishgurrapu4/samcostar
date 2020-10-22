package samcostar.samcostar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports extends TestBase {
	
TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	@CacheLookup
	WebElement Dropdown1;
	
	public Reports() {
		PageFactory.initElements(driver, this);
	}
	
	public void Reportstest() throws Exception{
		
	   Thread.sleep(3000);

	   driver.findElement(By.xpath("//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	   Thread.sleep(3000);
	   for (int i=1; i< 6; i++){
			
			 WebElement Dropdown = driver.findElement(By.xpath("//li[@id='list_reports']"));
			  Actions ac = new Actions(driver) ;
			  ac.moveToElement(Dropdown).build().perform();
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			   if (i==1)
			   {
				   driver.findElement(By.linkText("PROFIT & LOSS - Equity")).click();
			       Thread.sleep(3000);
			   }
			   else if (i==2)
			   {
				   WebElement PF = driver.findElement(By.linkText("PROFIT & LOSS - Derivatives"));
					jse.executeScript("arguments[0].click()", PF);
				    Thread.sleep(3000);
			   }
			   else if (i==3)
			   {
				WebElement TB =   driver.findElement(By.linkText("TRADE BOOK"));
				jse.executeScript("arguments[0].click()", TB);
			    Thread.sleep(3000);
			   }
			   else if (i==4)
			   {
				   WebElement TBS =  driver.findElement(By.linkText("TRADE BOOK SUMMARY"));
					jse.executeScript("arguments[0].click()", TBS);
				    Thread.sleep(3000);
			   }
			   else if (i==5)
			   {
				   WebElement CN = driver.findElement(By.linkText("CONTRACT NOTE"));
					jse.executeScript("arguments[0].click()", CN);
				    Thread.sleep(3000);
			   }

		    }
	       
	 }
}

