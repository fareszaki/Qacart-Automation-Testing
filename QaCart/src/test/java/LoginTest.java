import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    private LoginPage l;
    private HomePage h;


    @Test(priority = 0)
    public void test_we_can_navigate_to_loginPage_correctly() {
        h = new HomePage(driver);
        h.Navigate_to_Login_Page();
        String Actual_URl = driver.getCurrentUrl();
        String Expeted_URL = "https://todo.qacart.com/login";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Actual_URl, Expeted_URL);
        soft.assertAll();
    }


    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {"fazaki1234@gmail.com", "$FaresMahmoud246810"}
        };
    }

    @Test(dataProvider = "data" , priority = 1)
    public void verify_that_we_can_login_succesfully(String email, String password) {
        h = new HomePage(driver);
        h.Navigate_to_Login_Page();
        l = new LoginPage(driver);
        l.Entre_Email(email);
        l.Entre_Password(password);
        l.Click_Login();
        // first Asssert is Log of Site is displayed
        WebElement e = driver.findElement(By.cssSelector("img[src=\"/static/media/logo.be20a33a.png\"]"));
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(e.isDisplayed());
        // second Assert is Compare URL
        String Actual_URl = driver.getCurrentUrl();
        String Expeted_URL = "https://todo.qacart.com/todo";
        soft.assertEquals(Actual_URl, Expeted_URL);
        WebElement e1 = driver.findElement(By.cssSelector("h2[data-testid=\"welcome\"]"));
        String x = e1.getText();
        soft.assertTrue(x.contains("good morning"));
        // assert logout button is displayed
        WebElement elemt= driver.findElement(By.cssSelector("button[class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary\"]"));
        soft.assertTrue(e.isDisplayed());
        soft.assertAll();
    }

    @DataProvider(name = "invalid" )
    public Object[][] invalid() {
        return new Object[][]{
                {"faresmahmoud1712@gmail.com", "FaresNAHMOUF14578@"}
        };

    }
     @Test(dataProvider = "invalid" , priority = 2)
    public void verify_that_we_cannot_login_if_user_not_registerd(String email, String password) {
        h = new HomePage(driver);
        h.Navigate_to_Login_Page();
        l = new LoginPage(driver);
        l.Entre_Email(email);
        l.Entre_Password(password);
        l.Click_Login();
        SoftAssert soft = new SoftAssert();
        WebElement e1 = driver.findElement(By.cssSelector("div[class=\"MuiAlert-message\"]"));
        String x = e1.getText();
        soft.assertTrue(x.contains("We could not find the email in the database"));
        soft.assertAll();
    }
    @DataProvider(name = "data1")
    public Object[][] data1() {
        return new Object[][]{
                {"fazaki1234@gmail.com", "$FaresMahmou"}
        };

    }
    @Test(dataProvider = "data1" , priority = 3)
    public void test_if_login_using_correct_email_and_not_correct_pass(String email, String password) {
        h = new HomePage(driver);
        h.Navigate_to_Login_Page();
        l = new LoginPage(driver);
        l.Entre_Email(email);
        l.Entre_Password(password);
        l.Click_Login();
        SoftAssert soft = new SoftAssert();
        WebElement e1 = driver.findElement(By.cssSelector("div[class=\"MuiAlert-message\"]"));
        String x = e1.getText();
        soft.assertTrue(x.contains("The email and password combination is not correct, please fill a correct email and password"));
        soft.assertAll();
}
}