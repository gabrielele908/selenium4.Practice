package selenium4.juniors;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class OfflineMode {
    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        DevTools tool= ((ChromeDriver)driver).getDevTools();
        tool.createSession();
        tool.send(Network.emulateNetworkConditions(true,100,100,100,Optional.of(ConnectionType.OTHER)));
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_offlineMode() throws InterruptedException {
        driver.get("https://www.google.com/");

    }
}
