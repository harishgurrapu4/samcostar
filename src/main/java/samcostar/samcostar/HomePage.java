package samcostar.samcostar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import samcostar.samcostar.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'MOHD FAHIM S...')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(tagName = "a")
	@CacheLookup
	List<WebElement> Links;
	
	
	@FindBy(xpath = "//body/div[@id='small2']/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")
	@CacheLookup
	WebElement Modal;
	
	@FindBy(xpath = "//a[@id='profile_image']")
	@CacheLookup
	WebElement Dropdown;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement MyProfile;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement AccountSettings;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[4]/a[1]")
	@CacheLookup
	WebElement Logout;

	@FindBy(xpath = "//span[contains(text(),'REFERRAL CENTRE')]")
	WebElement Referalcentre;
	
	@FindBy(xpath = "//span[contains(text(),'SUBSCRIPTION')]")
	WebElement Subscription;
	

	@FindBy(xpath = "//li[@id='list_funds']")
	WebElement Funds;

	@FindBy(xpath = "//li[@id='list_portfolio']")
	WebElement Portfolio;
	
	@FindBy(xpath = "//li[@id='list_stock_basket']")
	WebElement StockBasket;
	
	@FindBy(xpath = "//li[@id='list_profile']")
	WebElement Profile;
	
	@FindBy(xpath = "//li[@id='list_ledger']")
	WebElement Ledger;
	
	@FindBy(xpath = "//li[@id='list_reports']")
	WebElement Reports;
	
	@FindBy(xpath = "//li[@id='list_corporate_action']")
	WebElement CorporateAction;
	
	@FindBy(xpath = "//li[@id='list_resources']")
	WebElement Samcoresources;
	
	@FindBy(xpath = "//li[@id='list_family']")
	WebElement Family;
	
	@FindBy(xpath = "//li[@id='list_story']")
	WebElement SavingJourney;
	
	@FindBy(xpath = "//li[@id='feedback']")
	WebElement Feedback;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public Profile clickOnMyProfile(){
//		int s = DropDown.size();
//	      // Iterating through the list selecting the desired option
//	      for( int j = 0; j< s;j++){
//	         // if the option is By Subject click that option
//	         if( DropDown.get(j).getText().equals(" My Profile ")){
//	        	 DropDown.get(j).click();
//	            break;
//	             }
//	      }
	    Actions ac = new Actions(driver) ;
	    ac.moveToElement(Dropdown).build().perform();
	    MyProfile.click();
	      return new Profile();
	}
	
	public Modification clickOnAccountSettings(){
//		int s = DropDown.size();
//	      // Iterating through the list selecting the desired option
//	      for( int j = 0; j< s;j++){
//	         // if the option is By Subject click that option
//	         if( DropDown.get(j).getText().equals(" Account Settings")){
//	        	 DropDown.get(j).click();
//	            break;
//	             }
//	      }
		 Actions ac = new Actions(driver) ;
		    ac.moveToElement(Dropdown).build().perform();
		    AccountSettings.click();
	      return new Modification();
	}

	public void clickOnLogout(){
//		int s = DropDown.size();
//	      // Iterating through the list selecting the desired option
//	      for( int j = 0; j< s;j++){
//	         // if the option is By Subject click that option
//	         if( DropDown.get(j).getText().equals(" Log Out ")){
//	        	 DropDown.get(j).click();
//	            break;
//	             }
//	      }
		Actions ac = new Actions(driver) ;
	    ac.moveToElement(Dropdown).build().perform();
	    Logout.click();
	    
	      
	}
	
	public void BrokenLinks(){
		
		String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;

        Iterator<WebElement> it = Links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
            System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
	}
	
}
	
