package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.emulation.Emulation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class EmulateUserAgent {
    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        DevTools tool= ((ChromeDriver)driver).getDevTools();
        tool.createSession();
        tool.send(Emulation.setUserAgentOverride("KUKU", Optional.of(""),Optional.of(""),Optional.empty()));
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        //driver.quit();
    }
    @Test
    public void fun_emulateUserAgent() throws InterruptedException {
        driver.get("https://whatsmyua.info");

    }
}
