package samcostar.samcostar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FundsTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	Funds F = new Funds();
	TestUtil testUtil;
	
	public FundsTest() {
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
	public void Fundstest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
		F.Fundstest();
	    //Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

