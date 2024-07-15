package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.emulation.Emulation;
import org.openqa.selenium.devtools.log.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class EmulateGeoLocation {
    private WebDriver driver;
    private DevTools tool;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        tool = ((ChromeDriver) driver).getDevTools();
        tool.createSession();

    }


    @AfterClass
    public void closeWindow() {
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void fun_emulateGeoLocation() throws InterruptedException {
        tool.send(Emulation.setGeolocationOverride(Optional.of(19.075984),Optional.of(72.877656),Optional.of(100)));
        driver.get("https://www.google.com/");
        WebElement searchGoogle= driver.findElement(By.name("q"));
        searchGoogle.sendKeys("university");
        searchGoogle.submit();
    }
}