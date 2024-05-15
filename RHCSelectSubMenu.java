package GBSoft.Learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RHCSelectSubMenu {

	public static WebDriver browser;
	public static WebDriverWait wait;
	public static WebElement w1;
	public static List<WebElement> l1;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	public static Point p1;
	public static JavascriptExecutor j1;
	public Alert mAlert;

	
	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
		WebDriver browser = WebDriverManager.chromedriver().capabilities(options).create();


		browser.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		
		        // Locate the dropdown element
		        WebElement dropdown = browser.findElement(By.id("country"));

		        // Click on the dropdown to reveal the options
		        //dropdown.click();

		        // Find all the options within the dropdown
		        List<WebElement> options1 = dropdown.findElements(By.xpath("//option"));

		        // Iterate through the options and select the desired one
		        String desiredOptionText = "Peru";
		        for (WebElement option : options1) {
		            if (option.getText().equals(desiredOptionText)) {
		                option.click();
			            break; // Exit the loop after selecting the desired option
		            }
		        }
		        
		        // Mouse hover
				//w1 = browser.findElement(By.xpath("//*[@id=\"header-navigation\"]/div/ul/li[3]/a"));
				//act = new Actions(browser);
				//act.moveToElement(w1).build().perform();
		        
		        // RHC
		        Actions actions = new Actions(browser);
		        actions.contextClick().perform();
		        

		        // Close the browser
		        //browser.quit();

		
		/*
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //5 seconds wait will be applicable for all setps
		//http://deluxe-menu.com/popup-mode-sample.html
		browser.get("http://deluxe-menu.com/popup-mode-sample.html");
		browser.manage().window().maximize();

		WebElement mDraggable = browser.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement mTargetElement = browser.findElement(By.xpath("//*[@id=\"droppable\"]"));
		Actions mActions = new Actions(browser);
		mActions.dragAndDrop(mDraggable,mTargetElement).perform();
		
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //5 seconds wait will be applicable for all setps
		browser.navigate().refresh();
		WebElement mDraggable1 = browser.findElement(By.xpath("//*[@id=\"draggable\"]"));		
		mActions.dragAndDropBy(mDraggable1,350,400).perform();
		*/
	}
}