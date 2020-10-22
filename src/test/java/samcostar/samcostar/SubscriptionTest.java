package samcostar.samcostar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubscriptionTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	Modification modification = new Modification();
	Subscription Subs = new Subscription();
	TestUtil testUtil;
	
	public SubscriptionTest() {
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
	public void subscriptionTest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
		Subs.subscription();
	    //Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
