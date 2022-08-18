package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;



public class BaseTest {

    protected WebDriver driver;
    private Properties prop;

    @BeforeTest
    public void setupDriver() throws IOException {

    }


//    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}


