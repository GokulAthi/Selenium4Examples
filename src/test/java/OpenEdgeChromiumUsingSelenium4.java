import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class OpenEdgeChromiumUsingSelenium4 {

    public static void main(String[] args){
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Test");
        driver.quit();
    }
}
