import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class OpenNewTabAndWindowInChromeUsingSelenium4 {

    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println("Page title -> "+driver.getTitle());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://simplytechnified.com/find-elements-with-relative-locator-strategy-using-selenium-4-and-java/");
        System.out.println("Page title of new tab -> "+driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://simplytechnified.com/read-server-client-logcat-logs-using-appium-and-java/");
        System.out.println("Page title of new window -> "+driver.getTitle());

        driver.quit();
    }
}
