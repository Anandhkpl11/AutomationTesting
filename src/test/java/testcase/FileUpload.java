package testcase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	
	@Test
	public void FileUploadDocument() throws InterruptedException, IOException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.dealsdray.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		driver.findElement(By.xpath("//*[@class='sidenavHoverShow collapseIcon']")).click();
		
		driver.findElement(By.xpath("(//*[@name='child'])[2]")).click();
		
		driver.findElement(By.xpath("//*[@align='right']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\Users\\HAPPY\\Downloads\\demo-data.xlsx");
		
		driver.findElement(By.xpath("(//*[@type='button'])[7]")).click();
		
		driver.findElement(By.xpath("(//*[@type='button'])[7]")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		
		File socurces = screenshot.getScreenshotAs(OutputType.FILE);
		
		File des=new File("fileuploadscreenshot.png");
		
		FileUtils.copyFile(socurces, des);
		
		driver.quit();
		
		
		
		
	}

}
