import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;

public class SingUP_Page extends PageBase {
    public SingUP_Page(WebDriver driver) {
        super(driver);
    }

    private By Fill_FirstName = By.cssSelector("input[data-testid=\"first-name\"]");
    private WebElement element;

    public void Fill_First_Name(String FirstName) {
        element = driver.findElement(Fill_FirstName);
        Fill_Feilds(element, FirstName);
    }

    By Fill_LastName = By.cssSelector("input[data-testid=\"last-name\"]");
    private WebElement ELE;

    public void Entre_Last_Name(String lastName) {
        ELE = driver.findElement(Fill_LastName);
        Fill_Feilds(ELE, lastName);

    }

    By Fill_Email = By.cssSelector("input[data-testid=\"email\"]");
    private WebElement e;

    public void Entre_Email(String Email) {
        e = driver.findElement(Fill_Email);
        e.clear();
        Fill_Feilds(e, Email);

    }

    By Fill_password = By.cssSelector("input[data-testid=\"password\"]");
    private WebElement password;

    public void Entre_Password(String pass) {
        password = driver.findElement(Fill_password);
        password.clear();
        Fill_Feilds(password, pass);

    }


    By Fill_RE_password = By.cssSelector("input[data-testid=\"confirm-password\"]");
    private WebElement Re_password;

    public void Entre_RePassword(String Repass) {
       Re_password = driver.findElement(Fill_RE_password);
        Fill_Feilds(Re_password, Repass);

    }
    public void Click_On_Regester(){

    WebElement e = driver.findElement(By.cssSelector("button[data-testid=\"submit\"]"));
    Clicking(e);
}

    }
