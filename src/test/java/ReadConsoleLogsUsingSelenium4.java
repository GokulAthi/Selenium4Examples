import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.log.Log;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReadConsoleLogsUsingSelenium4 {

    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        DevTools devTools = driver.getDevTools();
        //Create chrome dev tools session
        devTools.createSession();

        //Enable the logs
        devTools.send(Log.enable());

        //Listen to console
        devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.getText()));

        driver.get("https://nhnb.github.io/console-log/console-log/demo.html");

        driver.quit();
    }
}
