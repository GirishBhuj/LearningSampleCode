//Coding challenge https://www.youtube.com/watch?v=wVLIdJNGU9c
		  /*  𝐒𝐭𝐞𝐩𝐬 𝐭𝐨 𝐀𝐮𝐭𝐨𝐦𝐚𝐭𝐞:
			 1) Navigate to: https://www.redbus.in/
			 2) Select the From and To destination as per your choice.
			 3) Select the Date as Tomorrow's date and then Search Buses.
			 4) From the result, Click on any Bus 'View Seats' buttons
			 5) The Bus Seats available chart will be displayed - print the number of available & allocated seats.
			 6) From your choice Select any Available Seat from the Chart.

https://github.com/kush1107/SeleniumCodingChallenge/blob/master/src/test/java/com/seleniumsessions/RedBus_DatePickerChallengeSolved.java
*/

package GBSoft.Learning;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class RedBus_DatePicker {
	 static WebDriver driver;
	 
	public static void main(String[] args) {

	    EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        driver.findElement(By.cssSelector(".dateText")).click();
        ArrayList<String> weekendList = getWeekEndDates("Dec 2024");
        System.out.println("Weekends dates for given Month & year are :"+weekendList);
        //driver.quit();

	}

	    public static ArrayList<String> getWeekEndDates(String month) {
	        ArrayList<String> weekendList1 = new ArrayList<>();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement monthElement = driver.findElement(By.cssSelector("div.DayNavigator__IconBlock-qj8jdz-2:nth-of-type(2)"));
	        String searchingMonth = monthElement.getText();
	        while (!searchingMonth.contains(month)) {
	             monthElement = driver.findElement(By.cssSelector("div.DayNavigator__IconBlock-qj8jdz-2:nth-of-type(2)"));
	             searchingMonth = monthElement.getText();

	            if (searchingMonth.contains(month)) {
	                List<WebElement> weekends1 = driver.findElements(By.cssSelector("span.bwoYtA"));

	                for (WebElement w : weekends1) {
	                    weekendList1.add(w.getText());
	                }
	                System.out.println(monthElement.getText());
	                break;
	            } else {
	                System.out.println(searchingMonth);
	                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.DayNavigator__IconBlock-qj8jdz-2:nth-of-type(3) > svg"))).click();
	            }
	        }
	        return weekendList1;
	    }
}