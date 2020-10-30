package samcostar.samcostar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReferalCentreTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
    ReferalCentre RC = new ReferalCentre();
	TestUtil testUtil;
	

	
	public ReferalCentreTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	String sheetName = "contacts";

	

//	@Test(priority=1)
//	public void ReferalcentreTest() throws Exception{
//		testUtil.waitForLoad(driver);
//		//Thread.sleep(3000);
//		RC.Referalcentre();
//	    //Thread.sleep(3000);
//	}
	
	@DataProvider
	public Object[][] referaldata(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	} 	
	
	@Test(priority=1, dataProvider="referaldata")
	public void validatereferalentry(String Name, String Email, String Mob) throws Exception{
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		RC.Referalcentre(Name, Email, Mob);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
