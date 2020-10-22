package samcostar.samcostar;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Portfolio extends TestBase {
	
TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	@CacheLookup
	WebElement Dropdown1;
	
	public Portfolio() {
		PageFactory.initElements(driver, this);
	}
	
	public void Portfoliotest() throws Exception{
		
	   Thread.sleep(3000);

	   driver.findElement(By.xpath("//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	   Thread.sleep(3000);
	   for (int i=1; i< 4; i++){
			
			 WebElement Dropdown = driver.findElement(By.xpath("//li[@id='list_portfolio']"));
			  Actions ac = new Actions(driver) ;
			  ac.moveToElement(Dropdown).build().perform();
		   
			   if (i==1){
				   driver.findElement(By.linkText("OPEN POSITIONS")).click();
			       Thread.sleep(3000);
			   }
			   else if (i==2)
			   {
				   driver.findElement(By.linkText("BTPT POSITIONS")).click();
				   //Intraplus.click();
				   Thread.sleep(3000);
			   }
			   else if (i==3)
			   {
				   driver.findElement(By.linkText("HOLDINGS")).click();
			       Thread.sleep(3000);
			   }

		    }
	       
	 }
}

