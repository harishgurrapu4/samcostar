package samcostar.samcostar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferalCentre extends TestBase{


	TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]")
	@CacheLookup
	WebElement Dropdown;
	
	public ReferalCentre() {
		PageFactory.initElements(driver, this);
	}
	
	public void Referalcentre(String Name, String Email, String Mob) throws Exception{
		
		Thread.sleep(3000);
		//Actions ac = new Actions(driver) ;
	  //  ac.moveToElement(Dropdown).build().perform();
	   driver.findElement(By.xpath("//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	   Thread.sleep(3000);
	   for (int i=1; i<3; i++){
		   
	    driver.findElement(By.xpath("//li[@id='list_referrals']")).click();
		   
			   if (i==1){
				   driver.findElement(By.linkText("REFER")).click();
				  // Cashplus.click();
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//input[@id='txtName']")).sendKeys(Name);
			       driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys(Email);
			       driver.findElement(By.xpath("//input[@id='txtMobile']")).sendKeys(Mob);
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//input[@id='submit']")).click();
			       Thread.sleep(3000);
			       String msg = driver.findElement(By.xpath("//body/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]")).getText();
			       System.out.println(msg);
			   }
			   else if (i==2)
			   {
				   driver.findElement(By.linkText("WALLET")).click();
				   //Intraplus.click();
				   Thread.sleep(3000);
				   driver.findElement(By.xpath("//input[@id='claim_er']")).click();
				   Thread.sleep(3000);
			       String msg = driver.findElement(By.xpath("//div[@id='claim_error']")).getText();
			       System.out.println(msg);
			   }

		    }
	       
	 }
}
