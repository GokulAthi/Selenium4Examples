import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class OpenNewTabAndWindowInChromeUsingSelenium4 {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println("Page title -> "+driver.getTitle());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://crazyautomator.com/how-to-invoke-chrome-browser-in-headless-mode-using-selenium-and-java/");
        System.out.println("Page title of new tab -> "+driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://crazyautomator.com/how-to-perform-scroll-in-android-app-using-appium-and-java/");
        System.out.println("Page title of new window -> "+driver.getTitle());

        driver.quit();
    }
}
