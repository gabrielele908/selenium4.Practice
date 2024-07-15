package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.Headers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ElementOrientation {
    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nopcommerce.com/");
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_elementOrientation() throws InterruptedException {
        WebElement search= driver.findElement(By.cssSelector(".get-started-link"));
        System.out.println("width of elemnet: "+ search.getRect().getWidth());
        System.out.println("Height of elemnet: "+ search.getRect().getHeight());
        System.out.println("X of elemnet: "+ search.getRect().getX());
        System.out.println("Y of elemnet: "+ search.getRect().getY());

    }
}
