package samcostar.samcostar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CorporateActionTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
    CorporateAction CA = new CorporateAction();
	TestUtil testUtil;
	
	public CorporateActionTest() {
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
	
	@Test(priority=1)
	public void ReferalcentreTest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
		CA.Corporateaction();
	    //Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

