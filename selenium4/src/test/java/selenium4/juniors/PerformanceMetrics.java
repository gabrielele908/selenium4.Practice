package selenium4.juniors;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.emulation.Emulation;
import org.openqa.selenium.devtools.performance.Performance;
import org.openqa.selenium.devtools.performance.model.Metric;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.devtools.performance.Performance.getMetrics;

public class PerformanceMetrics {
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
        driver.quit();
    }

    @Test
    public void fun_performanceMetrics() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchGoogle= driver.findElement(By.name("q"));
        searchGoogle.sendKeys("university");
        tool.send(Performance.enable(Optional.of(Performance.EnableTimeDomain.TIMETICKS)));
        searchGoogle.submit();
        List<Metric> Metrics=tool.send(getMetrics());
        Metrics.forEach(metric -> System.out.println(metric.getName() + " " +metric.getValue()));
    }
}
