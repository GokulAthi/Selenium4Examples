import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;

import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class ChangeNetworkTo4GOnlineUsingSelenium4 {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DevTools devTools = driver.getDevTools();
        //Create chrome dev tools session
        devTools.createSession();

        //Enable the Network
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Set the network to online and add connection type to cellular 4G
        devTools.send(Network.emulateNetworkConditions(false,100,300000,150000, Optional.of(ConnectionType.CELLULAR4G)));

        driver.get("https://www.google.com");

        driver.quit();
    }
}
