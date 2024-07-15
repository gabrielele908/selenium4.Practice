package selenium4.juniors;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.internal.http2.Header;
import org.openqa.selenium.WebDriver;
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

public class ManagingHeaders {

    //check why not working
    private WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        DevTools tool= ((ChromeDriver)driver).getDevTools();
        tool.createSession();
        tool.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        HashMap<String, Object> header=new HashMap<String, Object>();
        header.put("Gabriel Elemberg" , "Class A+");
        Headers data= new Headers(header);
        tool.send(Network.setExtraHTTPHeaders(data));
    }


    @AfterClass
    public void closeWindow(){
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void fun_headers() throws InterruptedException {
        driver.get("http://xhaus.com/headers");
    }

}

