package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RelativeLocatorNew {

    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().setPosition(new Point(0,0));
       // driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


@AfterClass
    public void closeWindow(){
    Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        driver.quit();
}
@Test
    public void fun_relativeLocator() throws InterruptedException {
        By password= By.id("ap_password");
        driver.get("https://www.imdb.com/registration/signin?ref=nv_generic_lgin&u=%2F");
        driver.findElement(By.xpath("//*[@class='list-group']/a[1]")).click();
        driver.findElement(By.id("ap_email")).sendKeys("avi");
        driver.findElement(password).sendKeys("avi");
        driver.findElement(RelativeLocator.withTagName("input").below(password)).click();
}





}
