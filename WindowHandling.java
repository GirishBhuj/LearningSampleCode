package GBSoft.Learning;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class WindowHandling {
		private static WebDriver driver;
		public static WebDriverWait wait;
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); //5 seconds wait will be applicable for all setps

			// Code to click on the all links of search result
			driver.get("https://www.amazon.in");

	        driver.manage().timeouts().pageLoadTimeout(3, java.util.concurrent.TimeUnit.SECONDS);
	        String mainWH = driver.getWindowHandle();
	        
	        try {
	        	//Wait till page loads completlly
		        new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedCondition<Boolean>) wd -> ((org.openqa.selenium.JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		        
		        //Opens a new tab and switches to new tab
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get("https://www.google.com");
				
				// Opens a new window and switches to new window
				driver.switchTo().newWindow(WindowType.WINDOW);	          
				driver.get("https://www.loksatta.com");
				
				driver.switchTo().window(mainWH);
	        }
		    catch (TimeoutException e){
		        	System.out.println("Page load time out exception");}
	        finally { 
	        	//driver.quit();
	        }
			//driver.close();
		}
	}