package samcostar.samcostar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
    Reports R = new Reports();
	TestUtil testUtil;
	
	public ReportsTest() {
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
		R.Reportstest();
	    //Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}