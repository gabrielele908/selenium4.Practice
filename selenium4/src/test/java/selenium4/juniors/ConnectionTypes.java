package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ConnectionTypes {
    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        DevTools tool= ((ChromeDriver)driver).getDevTools();
        tool.createSession();
        tool.send(Network.emulateNetworkConditions(false,100,90000,90000, Optional.of(ConnectionType.WIFI)));
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_connectionTypes() throws InterruptedException {
        driver.get("https://www.ynet.co.il/");

    }
}
