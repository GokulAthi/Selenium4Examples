import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class FindAnElementWithRelativeLocatorStrategyUsingSelenium4 {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement imfeelingluckybutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[role='search']>div>div>div[class]:not([style]) input[value*=' Feeling Lucky']")));

        WebElement googlesearchbuttonfoundusingrelativelocator = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(imfeelingluckybutton));
        WebElement googlesearchtextboxfoundusingrelativelocator = driver.findElement(RelativeLocator.with(By.tagName("input")).above(imfeelingluckybutton));

        googlesearchtextboxfoundusingrelativelocator.sendKeys("test");
        googlesearchbuttonfoundusingrelativelocator.click();

        driver.quit();
    }
}
