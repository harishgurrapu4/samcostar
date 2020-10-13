package samcostar.samcostar;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase {
	
	public static long IMPLICIT_WAIT = 20;

		
		public void waitForLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        wait.until(pageLoadCondition);
	         }
		
		
		private static WebDriver driver = null;
		
		public void TakeScreenShot(WebDriver driver)
		{
			this.driver=driver;

		}
		public String getScreenShot(String imageName) throws IOException{
			WebDriver driver = null;
			if(imageName.equals("")){
				imageName = "blank";
			}
			File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//String imagelocation = System.getProperty("user.dir")+"/myapp-aof-partner/src/test/resources/data/";
			String imagelocation="C:\\Users\\samco\\Desktop\\Screen\\";
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String actualImageName = imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
			File destFile = new File(actualImageName);
			FileHelper.copyFile(image, destFile);
			return actualImageName;
		}

		public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}
		
}
