package com.testinium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BaseTest {
    public static WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(false);
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to Windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--log-level=3");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome 13");
        caps.setCapability("os", "Windows");
        caps.merge(caps);

        driver.get("https://www.kitapyurdu.com");
    }


    /*
    @After
    public void tearDown(){
        System.out.println("Test Sonlandı!");
        if(driver !=null){
             driver.close();
             driver.quit();
        }
    }*/
}