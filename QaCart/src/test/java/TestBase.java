import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver ;
    @BeforeTest
    public void Set_up(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver() ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://todo.qacart.com/");

    }
    @AfterMethod
    public void Quit() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }




}
