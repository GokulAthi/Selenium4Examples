import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GetSizeAndLocationOfElementUsingSelenium4 {

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hplogo")));

        Rectangle logoSizeAndLocations = logo.getRect();
        System.out.println("Height = "+logoSizeAndLocations.height);
        System.out.println("Width = "+logoSizeAndLocations.width);
        System.out.println("X coordinate = "+logoSizeAndLocations.x);
        System.out.println("Y coordinate = "+logoSizeAndLocations.y);

        driver.quit();
    }
}
