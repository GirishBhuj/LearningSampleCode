package GBSoft.Learning;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class SearchResult {
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
	        
	        try {
	        	//Wait till page loads completlly
		        new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedCondition<Boolean>) wd -> ((org.openqa.selenium.JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

				WebElement searchText = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
				searchText.sendKeys("bhavara");
				searchText.sendKeys(Keys.ENTER);
				wait = new WebDriverWait(driver, Duration.ofSeconds(2));
				
				String mainWindow = driver.getWindowHandle();

				WebElement mainDiv = driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']"));
				List<WebElement> searchResult = mainDiv.findElements(By.tagName("a"));
				
				for(WebElement el:searchResult)
				{
					WebElement el1 = el.findElement(By.xpath("..")); // Get the parent element
					if (el1.getAttribute("class").equalsIgnoreCase("a-size-mini a-spacing-none a-color-base s-line-clamp-4")){
						el.click();
					}
				}
		
				Set<String> mWindowHandles = driver.getWindowHandles();
				for (String wh:mWindowHandles){
					if (wh.equalsIgnoreCase(mainWindow)) {
						driver.switchTo().window(wh);
						break; }			
				}
		        
	        }
		    catch (TimeoutException e){
		        	System.out.println("Page load time out exception");}
	        finally { 
	        	//driver.quit();
	        }
			//driver.close();

			/* Code to visit all the pages in the search result
			 * 
			WebElement nextButton = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
			wait  = new WebDriverWait(driver, Duration.ofSeconds(2));
			
			while(true) {
				try {
					if (nextButton.getTagName().equals("a")) {
						wait.until(ExpectedConditions.elementToBeClickable(nextButton));
						nextButton.click();
					}
					else {
						System.out.println("done");
						break;
					}
				}
				catch (StaleElementReferenceException e) { 
						try {
							nextButton = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
						}
						catch (NoSuchElementException NoShch) {
							break;
						}
					}
			}
			*/

			/*
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(By.name("q")).sendKeys(Keys.PAGE_DOWN);

			
			((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			List<WebElement> searchResults = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));

			for(WebElement ele:searchResults) {
				System.out.println(ele.getText());
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				Actions actions = new Actions(driver);
	            actions.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).perform();
			}

			Set<String> tabs = driver.getWindowHandles();
			for (String wh:tabs) {
			driver.switchTo().window(wh);
			}
			 */
			
			//driver.get(driver.findElement(By.cssSelector("h3 > a")).getAttribute("href"));
			
			/* List<WebElement> searchResults = driver.findElements(By.cssSelector("div.r > a"));
	        // Check if there are search resultśsś
	        if (!searchResults.isEmpty()) {
	            // Click on the first search result
	            WebElement firstResult = searchResults.get(0);

	            // Open the link in a new tab using Actions class
	            Actions actions = new Actions(driver);
	            actions.keyDown(Keys.CONTROL).click(firstResult).keyUp(Keys.CONTROL).perform();
	            ((ChromeDriver) driver).executeScript("window.open()");
	        } else {
	            System.out.println("No search results found.");
	        } */
		}
	}