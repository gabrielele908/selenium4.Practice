package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ElementScreenShot {

    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().setPosition(new Point(0,0));
        // driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.imdb.com/");
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_takeScreenShot() throws InterruptedException, IOException {
        WebElement logo= driver.findElement(By.id("home_img"));
        File source=logo.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(source, new File("C:/Users/Gavriel/Pictures/logo.png"));
        FileUtils.copyFile(source, new File("./images/logo.png"));
    }
















}
