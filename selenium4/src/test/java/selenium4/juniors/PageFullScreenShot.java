package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageFullScreenShot {

    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.firefoxdriver().setup();
       // System.setProperty("webdriver.gecko.driver","C://selenium//geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.manage().window().setPosition(new Point(0,0));
        // driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.lametayel.co.il/");
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_pageScreenShot() throws InterruptedException, IOException {

        File screen=((FirefoxDriver)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(source, new File("C:/Users/Gavriel/Pictures/logo.png"));
        FileUtils.copyFile(screen, new File("./images/screen.png"));

        File fullScreen=((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fullScreen, new File("./images/fullScreen.png"));
    }

















}
