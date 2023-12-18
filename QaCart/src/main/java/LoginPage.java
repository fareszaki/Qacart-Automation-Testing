import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private   By Fill_Email = By.cssSelector("input[data-testid=\"email\"]");
    private WebElement el ;
    public void Entre_Email(String email){
        el= driver.findElement(Fill_Email);
        Fill_Feilds(el , email);
    }

    private   By Fill_Password = By.cssSelector("input[data-testid=\"password\"]");
    private WebElement ele ;
    public void Entre_Password(String password) {
        ele = driver.findElement(Fill_Password);
        Fill_Feilds(ele, password);
    }
    public void Click_Login(){
        WebElement e = driver.findElement(By.cssSelector("button[data-testid=\"submit\"]"));
        Clicking(e);
    }
    }
