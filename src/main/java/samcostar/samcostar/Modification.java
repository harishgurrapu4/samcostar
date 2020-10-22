package samcostar.samcostar;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Modification extends TestBase {
	
	TestUtil testUtil;
	
	@FindBy(tagName = "img")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//a[@id='profile_image']")
	@CacheLookup
	WebElement Dropdown;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement AccountSettings;
	
	@FindBy(xpath = "//a[@id='modify']")
	@CacheLookup
	WebElement Modifynow;
	
//	@FindBy(xpath = "//input[@id='bank_name1']")
//	@CacheLookup
//	WebElement BankName;
//	
//	@FindBy(xpath = "//input[@id='bank_acc_no1']")
//	@CacheLookup
//	WebElement BankAccNo;
//	
////	@FindBy(xpath = "//select[@id='bank_acc_type1']")
////	@CacheLookup
////	WebElement AccType;
//	
//	@FindBy(xpath = "//input[@id='bank_micr1']")
//	@CacheLookup
//	WebElement MicrCode;
//	
//	@FindBy(xpath = "//input[@id='bank_ifsc1']")
//	@CacheLookup
//	WebElement IfscCode;
//	
//	@FindBy(xpath = "//input[@id='bank_branch1']")
//	@CacheLookup
//	WebElement BankBrnch;
//	
//	@FindBy(xpath = "//input[@id='bank_address1']")
//	@CacheLookup
//	WebElement BankAddrs;
//	
//	@FindBy(xpath = "//input[@id='bank_proof']")
//	@CacheLookup
//	WebElement ProofUpload;
//	
//	@FindBy(xpath = "//button[@id='submit']")
//	@CacheLookup
//	WebElement Submit;
	
	public Modification() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAccountSettings() throws Exception{
		
		//  Modal.click();
		   // Actions ac = new Actions(driver) ;
		   // ac.moveToElement(Dropdown).build().perform();
		for(int i = 1; i < 8 ; i++){
			Thread.sleep(3000);
		    ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[3]/a[1]")));
		    Thread.sleep(3000);
		  // AccountSettings.click();
		    ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[@id='modify']")));
		    Thread.sleep(3000);
		    Select dropdown = new Select(driver.findElement(By.id("type_of_modification")));			
			//List<WebElement> values = dropdown.getAllSelectedOptions();
			dropdown.selectByIndex(i);
			System.out.println(i);
			Thread.sleep(3000);
			if(i==5){
				driver.findElement(By.xpath("//button[@id='sub']")).click();
				Thread.sleep(3000);
			}
			else{
			driver.findElement(By.xpath("//input[@id='aadhar']")).sendKeys("707468134106");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='sub']")).click();
			Thread.sleep(3000);
			}
			switch (i) {
			  case 1:
				  NewBnkAddtn();
			    break;
			  case 2:
				  ExistBnkModify();
			    break;
			  case 3:
				  //SegmentAddtn();
				  System.out.println("Segment is deleted");
			    break;
			  case 4:
				  AddrsChng();
			    break;
			  case 5:
				  System.out.println("Name and Email change");
			    break;
			  case 6:
				  NameChng();
			    break;
			  case 7:
				  DobChng();;
			    break;
			}
			//driver.navigate().to("https://star.samco.in/dashboard");
		   }
		    
	}
	
	
	
	public void NewBnkAddtn() throws Exception {
		driver.findElement(By.xpath("//input[@id='bank_name1']")).sendKeys("HDFC");
		driver.findElement(By.xpath("//input[@id='bank_acc_no1']")).sendKeys("50505050550");
		Select Acctype = new Select(driver.findElement(By.xpath("//select[@id='bank_acc_type1']")));
		Acctype.selectByVisibleText("Saving");
		driver.findElement(By.xpath("//input[@id='bank_micr1']")).sendKeys("505056505");
		driver.findElement(By.xpath("//input[@id='bank_ifsc1']")).sendKeys("HDFC0000815");
		driver.findElement(By.xpath("//input[@id='bank_branch1']")).sendKeys("Churchgate");
		driver.findElement(By.xpath("//input[@id='bank_address1']")).sendKeys("HDFC House H T Parekh Marg Backbay Reclamation Churchgate Mumbai 400020");
		Select Prooftype = new Select(driver.findElement(By.xpath("//select[@id='bank_acc_type2']")));
		Prooftype.selectByVisibleText("Passbook");
		driver.findElement(By.xpath("//input[@id='bank_proof']")).sendKeys("C:\\Users\\samco\\Pictures\\Capture.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
		//driver.navigate().to("https://star.samco.in/modification");
		//driver.findElement(By.xpath("//body/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[1]/label[1]/div[1]")).click();
		//driver.findElement(By.xpath("//button[@id='payment_submit']")).click();
	}
	
	public void ExistBnkModify() throws Exception {
		driver.findElement(By.xpath("//input[@id='bank_name1']")).clear();
		driver.findElement(By.xpath("//input[@id='bank_name1']")).sendKeys("HDFC");
		driver.findElement(By.xpath("//input[@id='bank_acc_no1']")).clear();
		driver.findElement(By.xpath("//input[@id='bank_acc_no1']")).sendKeys("50505050550");
		Select Acctype = new Select(driver.findElement(By.xpath("//select[@id='bank_acc_type1']")));
		Acctype.selectByVisibleText("Saving");
		driver.findElement(By.xpath("//input[@id='bank_micr1']")).clear();
		driver.findElement(By.xpath("//input[@id='bank_micr1']")).sendKeys("505056505");
		driver.findElement(By.xpath("//input[@id='bank_ifsc1']")).clear();
		driver.findElement(By.xpath("//input[@id='bank_ifsc1']")).sendKeys("HDFC0000815");
		driver.findElement(By.xpath("//input[@id='bank_branch1']")).clear();
		driver.findElement(By.xpath("//input[@id='bank_branch1']")).sendKeys("Churchgate");
		driver.findElement(By.xpath("//input[@id='bank_address1']")).clear();
		driver.findElement(By.xpath("//input[@id='bank_address1']")).sendKeys("HDFC House H T Parekh Marg Backbay Reclamation Churchgate Mumbai 400020");
		Select Prooftype = new Select(driver.findElement(By.xpath("//select[@id='bank_acc_type2']")));
		Prooftype.selectByVisibleText("Passbook");
		driver.findElement(By.xpath("//input[@id='bank_proof']")).sendKeys("C:\\Users\\samco\\Pictures\\Capture.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
		
	}
	
	public void SegmentAddtn() throws Exception {
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]")).click();
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		
		Alert al = driver.switchTo().alert();
		
		Select Acctype = new Select(driver.findElement(By.xpath("//select[@id='sel-income-proof']")));
		Acctype.selectByVisibleText("Salary Slip");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[3]/div[1]/div[6]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[3]/div[1]")).click();
		driver.findElement(By.xpath("//input[@id='upload-doc']")).sendKeys("C:\\Users\\samco\\Pictures\\Capture.png");
		al.accept();
		Thread.sleep(3000);
	//	driver.navigate().to("https://star.samco.in/modification");
	}
	
	public void AddrsChng() throws Exception {
		
		Select Addrstype = new Select(driver.findElement(By.xpath("//select[@id='address_type']")));
		Addrstype.selectByVisibleText("Correspondence");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='addresss_line1']")).clear();
		driver.findElement(By.xpath("//input[@id='addresss_line1']")).sendKeys("ROOM NO 154 50 12 DHARAVI");
		driver.findElement(By.xpath("//input[@id='addresss_line2']")).clear();
		driver.findElement(By.xpath("//input[@id='addresss_line2']")).sendKeys("HAYAT COMPOUND PLOT NO 22 NEAR VAIBHAV APARTMENT");
		driver.findElement(By.xpath("//input[@id='addresss_line3']")).clear();
		driver.findElement(By.xpath("//input[@id='addresss_line3']")).sendKeys("MUMBAI");
		driver.findElement(By.xpath("//input[@id='state']")).clear();
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("MAHARASHTRA");
		driver.findElement(By.xpath("//input[@id='pincode']")).clear();
		driver.findElement(By.xpath("//input[@id='pincode']")).sendKeys("400017");
		Select Prooftype = new Select(driver.findElement(By.xpath("//select[@id='address_proof_type']")));
		Prooftype.selectByVisibleText("Aadhaar card");
		driver.findElement(By.xpath("//input[@id='address_proof']")).sendKeys("C:\\Users\\samco\\Pictures\\Capture.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
	//	driver.navigate().to("https://star.samco.in/modification");

	}
	
   public void MobEmailChng() throws Exception {
		
	   
		//driver.navigate().to("https://star.samco.in/modification/account_setting");

	}
   public void NameChng() throws Exception {
		
		driver.findElement(By.xpath("//input[@id='newname']")).sendKeys("Harry");
		driver.findElement(By.xpath("//input[@id='reason']")).sendKeys("HAYAT COMPOUND");
		driver.findElement(By.xpath("//input[@id='name_proof1']")).sendKeys("C:\\Users\\samco\\Pictures\\Capture.png");
		driver.findElement(By.xpath("//input[@id='name_proof2']")).sendKeys("C:\\Users\\samco\\Pictures\\Capture.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
	//	driver.navigate().to("https://star.samco.in/modification");

	}
	
   public void DobChng() throws Exception {
		
		driver.findElement(By.xpath("//input[@id='newdob']")).click();
	   WebElement dateWidget = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
	   List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

	   for (WebElement cell: columns){
	      //Select 13th Date 
	      if (cell.getText().equals("13")){
	         cell.findElement(By.linkText("13")).click();
	         break;
	    }
	   }
		driver.findElement(By.xpath("//input[@id='dob_proof1']")).sendKeys("C:\\Users\\samco\\Pictures\\Capture.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
		//driver.navigate().to("https://star.samco.in/modification");

	}
	
	
}
