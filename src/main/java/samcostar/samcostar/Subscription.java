package samcostar.samcostar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Subscription extends TestBase {
	
	TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	@CacheLookup
	WebElement Dropdown;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
	@CacheLookup
	WebElement Cashplus;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement Intraplus;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement Optionplus;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/ul[1]/li[4]/a[1]")
	@CacheLookup
	WebElement StockApis;
	
	public Subscription() {
		PageFactory.initElements(driver, this);
	}
	
	public void subscription() throws Exception{
		
		Thread.sleep(3000);
		//Actions ac = new Actions(driver) ;
	  //  ac.moveToElement(Dropdown).build().perform();
	   driver.findElement(By.xpath("//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	   Thread.sleep(3000);
	   for (int i=1; i<5; i++){
		   
	    driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")).click();
		   
			   if (i==1){
				   driver.findElement(By.linkText("CashPlus")).click();
				  // Cashplus.click();
			       Thread.sleep(3000);
			   }
			   else if (i==2)
			   {
				   driver.findElement(By.linkText("IntraPlus / StockPlus")).click();
				   //Intraplus.click();
				   Thread.sleep(3000);
			   }
			   else if (i==3){
				   driver.findElement(By.linkText("OptionPlus")).click();
				  // Optionplus.click();
				   Thread.sleep(3000);
			   }
			   else if (i==4){
				   driver.findElement(By.linkText("StockNote APIs")).click();
				  // StockApis.click();
				   Thread.sleep(3000);
			   }

		    }
	    
	   
	}

}

