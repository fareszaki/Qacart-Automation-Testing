import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By Click_ON_Home = By.xpath("//a[text()=\"Home\"]");
    private WebElement HomeElement ;
    public void Navigate_to_Home_Page(){
        HomeElement = driver.findElement(Click_ON_Home);
        Clicking(HomeElement);
    }
    private By Click_ON_Login = By.cssSelector("a[href=\"/login\"]");
    private WebElement LoginElement ;
    public void Navigate_to_Login_Page(){
        LoginElement = driver.findElement(Click_ON_Login);
        Clicking(LoginElement);
    }
    private By Click_ON_SingUp = By.xpath("//a[text()=\"Signup\"]");
    private WebElement RegisterElement ;
    public void Navigate_to_SingUp_Page(){
        RegisterElement = driver.findElement(Click_ON_SingUp);
        Clicking(RegisterElement);

    }
}