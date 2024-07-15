package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class InstallUninstallFPlugins {
    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.manage().window().setPosition(new Point(0,0));
        // driver.manage().window().setSize(new Dimension(1920, 1080));

    }


    @AfterClass
    public void closeWindow(){

        driver.quit();
    }
    @Test
    public void fun_InstallUninstallFPlugins() throws InterruptedException {
        Path path= Paths.get("D:/projects/plugins/selenium_ide-3.17.0-fx.xpi");
        //install plugin
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
        String extID= ((FirefoxDriver)driver).installExtension(path);

        //unistall plugin ->all intall return id so we define an extID string.
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
        ((FirefoxDriver)driver).uninstallExtension(extID);
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
        }
    }

