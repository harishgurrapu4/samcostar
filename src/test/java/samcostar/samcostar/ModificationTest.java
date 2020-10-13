package samcostar.samcostar;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModificationTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Modification modification = new Modification();
	TestUtil testUtil;
	
	public ModificationTest() {
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
	public void clickOnAccountSettingsTest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
		modification.clickOnAccountSettings();
	    //Thread.sleep(3000);
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
