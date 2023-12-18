import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutClass extends PageBase{
    public LogoutClass(WebDriver driver) {
        super(driver);
    }
    private By clickonLogOut = By.cssSelector("button[class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary\"]");
    private WebElement e ;
    public void Clicking_on_LogOut() {
        e =driver.findElement(clickonLogOut);
        Clicking(e);
    }
}
