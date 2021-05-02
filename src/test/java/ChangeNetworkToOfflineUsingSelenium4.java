import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.devtools.v91.network.model.ConnectionType;


import java.util.Optional;
import java.util.concurrent.TimeUnit;



public class ChangeNetworkToOfflineUsingSelenium4 {

    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DevTools devTools = driver.getDevTools();
        //Create chrome dev tools session
        devTools.createSession();

        //Enable the Network
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Set the network to offline
        devTools.send(Network.emulateNetworkConditions(true, 100, 1000, 2000, Optional.of(ConnectionType.CELLULAR4G)));

        //devTools.addListener(loadingFailed(), loadingFailed -> System.out.println(loadingFailed.getErrorText()));

        driver.get("https://www.google.com");

        driver.quit();
    }
}
