package samcostar.samcostar;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import samcostar.samcostar.TestBase;
import samcostar.samcostar.HomePage;
import samcostar.samcostar.LoginPage;
import samcostar.samcostar.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;


	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
//		driver.switchTo().alert().dismiss();
		testUtil.waitForLoad(driver);
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Samco Back Office","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.waitForLoad(driver);
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void clickOnMyProfileTest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
	    homePage.clickOnMyProfile();
	    Thread.sleep(3000);
		
	}
	
	@Test(priority=4)
	public void clickOnAccountSettingsTest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
	    homePage.clickOnAccountSettings();
	    Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void clickOnLogoutTest() throws Exception{
		testUtil.waitForLoad(driver);
		//Thread.sleep(3000);
	    homePage.clickOnLogout();
	    Thread.sleep(3000);
		
	}
	
	@Test(priority=6)
	public void AssetsTest() throws Exception{
		testUtil.waitForLoad(driver);
		homePage.Assets();
		
	}
	
	@Test(priority=7)
	public void ViewHoldingsTest() throws Exception{
		testUtil.waitForLoad(driver);
		homePage.ViewHoldings();
	}
	
	@Test(priority=8)
	public void ViewPositionsTest() throws Exception{
		testUtil.waitForLoad(driver);
		homePage.ViewPositions();

	}

	@Test(priority=9)
	public void ViewMarginsTest() throws Exception{
		testUtil.waitForLoad(driver);
		homePage.ViewMargins();
	}
	
	@Test(priority=10)
	public void ViewContractNotesTest() throws Exception{
		testUtil.waitForLoad(driver);
		homePage.ViewContractNotes();
	}	
	
	@Test(priority=11)
	public void BrokenLinksTest(){
		homePage.BrokenLinks();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
