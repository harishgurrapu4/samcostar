package samcostar.samcostar;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import samcostar.samcostar.TestBase;
import samcostar.samcostar.HomePage;
import samcostar.samcostar.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Samco Back Office login","Title not matched");
	}
	
	@Test(priority=2)
	public void validateSamcoImageTest(){
		boolean flag = loginPage.validateSamcoImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void validateStarImageTest(){
		boolean flag = loginPage.validateStarImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void WrongPasswloginTest() throws Exception{
		loginPage.WrongPasswlogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=5)
	public void BlankLoginTest() throws Exception{
		loginPage.BlankLogin();
	}
	
	@Test(priority=6)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
