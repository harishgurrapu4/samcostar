package samcostar.samcostar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SamcoResourcesTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	SamcoResources SR = new SamcoResources();
	TestUtil testUtil;
	
	public SamcoResourcesTest() {
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
	public void SamcoresourcesTest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
		SR.SamcoResourcestest();
	    //Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
