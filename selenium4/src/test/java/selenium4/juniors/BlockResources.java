package selenium4.juniors;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.security.Security;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class BlockResources {

    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        DevTools tool= ((ChromeDriver)driver).getDevTools();
        tool.createSession();
        tool.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
       // tool.send((Network.setBlockedURLs(ImmutableList.of("*.css","*.jpg"))));
        tool.send((Network.setBlockedURLs(ImmutableList.of("https://besttv232-ynet-images1-prod.cdn.it.best-tv.com/picserver5/wcm_upload/2020/08/06/Sy2vKnt11v/ynet320.png"))));
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_blockResources() throws InterruptedException {
        driver.get("https://www.ynet.co.il/");

    }











}
