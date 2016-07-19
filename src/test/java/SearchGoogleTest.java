import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by AndersonN on 7/19/2016.
 */


public class SearchGoogleTest {

    @DataProvider (name = "myTest")
    public Object [][] createData()
    {
        return new Object[][] {
                {"Cleveland Cavaliers"}, {"Pokemon Go"}, {"Cuyahoga Valley"}, {"Blue Moon"}
        };
    }

    @Test(dataProvider = "myTest")
    public void method(String mySearch){
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\Central\\drivers\\chromedriver.exe");

        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();

        // Navigate to Google home page
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys(mySearch);

        // Submit the form (WebDriver will find the form for us from the element)
        element.submit();

        // Wait for the result to be shown
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(mySearch));

        // Should see: “Cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
