import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OpenChromeHeadlessUsingSelenium4 {

    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Test");
        driver.quit();
    }
}
