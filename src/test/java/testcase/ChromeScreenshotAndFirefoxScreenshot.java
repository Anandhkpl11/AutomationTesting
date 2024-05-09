package testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ChromeScreenshotAndFirefoxScreenshot {
	
	
	@Test
	public void screenCapture() throws IOException {
		
		WebDriver chromrdriver=new ChromeDriver();
		
		Dimension [] desktopresolution = {new Dimension(1920,1080), new Dimension(1366,768), new Dimension(1536,864 )};
		
		Dimension [] mobileresolution = {new Dimension(360,640), new Dimension(414,896), new Dimension(375,667)};
		
		for (Dimension resolutions : desktopresolution) {
			chromrdriver.manage().window().setSize(resolutions);
			takeScreenshot(chromrdriver,"chrome",resolutions);
			
		}
		
		for (Dimension resolutions1 : mobileresolution) {
			chromrdriver.manage().window().setSize(resolutions1);
			takeScreenshot(chromrdriver,"chrome_mobile",resolutions1);
		}
		
		chromrdriver.quit();
		
		WebDriver firefoxdriver=new FirefoxDriver();
		
		for (Dimension resolutions : mobileresolution) {
			firefoxdriver.manage().window().setSize(resolutions);
			takeScreenshot(firefoxdriver, "firefox_mobile", resolutions);
			
		}
		
		for (Dimension resolutions1 : desktopresolution) {
			firefoxdriver.manage().window().setSize(resolutions1);
			takeScreenshot(firefoxdriver, "firefox", resolutions1);
		}
		
		firefoxdriver.quit();
		
	}
	
	
	public static void takeScreenshot(WebDriver driver, String screenname, Dimension resolutions) throws IOException {
		
		driver.get("https://www.getcalley.com/");
		
		String filename="screenshot"+"-"+resolutions.getWidth()+"-"+resolutions.getHeight()+"-"+screenname+".png";
		
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		File sources = screenshot.getScreenshotAs(OutputType.FILE);
		
		File des=new File(filename);
		
		FileUtils.copyFile(sources, des);
		
		
		
		
		
		
	}

}
