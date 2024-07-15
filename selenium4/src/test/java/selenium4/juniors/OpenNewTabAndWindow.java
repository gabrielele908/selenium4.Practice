package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenNewTabAndWindow {
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
        Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_OpenNewTabAndWindow() throws InterruptedException {
        //open a new tab and switch to that tab.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");

        //open a window tab and switch to that window.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bing.com/");
    }
}
