import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static java.time.Duration.ofMinutes;

public class SingUpTest extends TestBase {
    private HomePage h;
    private SingUP_Page s;

    @Test(priority = 0)
    public void test_singup_with_invalid_Credentials() throws InterruptedException {
        h = new HomePage(driver);
        h.Navigate_to_SingUp_Page();
        // Sleep 2 seconds Before Execute test
        Thread.sleep(2000);
        s = new SingUP_Page(driver);
        s.Fill_First_Name("");
        s.Entre_Last_Name("");
        s.Entre_Email("");
        s.Entre_Password("");
        s.Entre_RePassword("");
        s.Click_On_Regester();
        // Assert compare Actual url and Expected url
        String Actual_URL = driver.getCurrentUrl();
        String Expected_URL = "https://todo.qacart.com/signup";
        // Assert using Dynamic Assert
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Actual_URL, Expected_URL);
        WebElement e = driver.findElement(By.cssSelector("p[class=\"MuiFormHelperText-root MuiFormHelperText-contained Mui-error Mui-required\"]"));
        String text = e.getText();
        soft.assertTrue(text.contains("is required, and it should be more than 3 characters"));
        soft.assertAll();
    }

    @DataProvider(name = "ValidCredentials")
    public Object[][] ValidCredentials() {
        return new Object[][]{
                {"mohamed", "ali ", "fazaki1234@gmail.com", "$FaresMahmoud246810", "$FaresMahmoud246810"}
        };
    }

    @Test(dataProvider = "ValidCredentials" , priority = 1)
    public void test_singup_with_valid_credentials(String fName, String Lname, String email, String PASS, String repass) throws InterruptedException {
        h = new HomePage(driver);
        h.Navigate_to_SingUp_Page();
        s = new SingUP_Page(driver);
        s.Fill_First_Name(fName);
        s.Entre_Last_Name(Lname);
        s.Entre_Email(email);
        s.Entre_Password(PASS);
        s.Entre_RePassword(repass);
        s.Click_On_Regester();
        Thread.sleep(5000);
    }

    @DataProvider(name = "inValidCredentials")
    public Object[][] inValidCredentials() {
        return new Object[][]{
                {"mohamed", "ali ", "fazaki1234@gmail.com", "$FaresMahmoud246810", "$FaresMahmoud246810"}
        };
    }

    @Test(dataProvider = "inValidCredentials" , priority = 2)
    public void test_singup_with_Exist_email(String fName, String Lname, String email, String PASS, String repass) throws InterruptedException {
        h = new HomePage(driver);
        h.Navigate_to_SingUp_Page();
        s = new SingUP_Page(driver);
        s.Fill_First_Name(fName);
        s.Entre_Last_Name(Lname);
        s.Entre_Email(email);
        s.Entre_Password(PASS);
        s.Entre_RePassword(repass);
        s.Click_On_Regester();
        Thread.sleep(5000);
        String Actual = driver.getCurrentUrl();
        String Expect = "https://todo.qacart.com/signup";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Actual, Expect);
        //ERROE MEG Say Email Already Existed
        WebElement e = driver.findElement(By.cssSelector("div[data-testid=\"error\"]"));
        String Error_Text = e.getText();
        soft.assertTrue(Error_Text.contains("Email is already exists in the Database"));
        // Background Color is black
        String c = e.getCssValue("background-color");
        soft.assertEquals(Color.fromString(c).asHex(), "#030e18");
        soft.assertAll();
    }

    @DataProvider(name = "wrongCriteria")
    public Object[][] wrongCriteria() {
        return new Object[][]{
                {"fa", "la", "fares.com", "gasdcfa", "jhsgduyf"}
        };
    }

    @Test(dataProvider = "wrongCriteria" , priority = 3)
    public void Test_Sinup_using_wrong_Criteria_For_FirstName_LastName(String m, String d, String l, String y, String z) throws InterruptedException {
        h = new HomePage(driver);
        h.Navigate_to_SingUp_Page();
        s = new SingUP_Page(driver);
        s.Fill_First_Name(m);
        s.Entre_Last_Name(d);
        s.Entre_Email(l);
        s.Entre_Password(y);
        s.Entre_RePassword(z);
        s.Click_On_Regester();
        Thread.sleep(5000);
        SoftAssert soft = new SoftAssert();
        WebElement e = driver.findElement(By.cssSelector("p[class=\"MuiFormHelperText-root MuiFormHelperText-contained Mui-error Mui-required\"]"));
        String text = e.getText();
        soft.assertTrue(text.contains("is required, and it should be more than 3 characters"));
        soft.assertAll();
    }

    @DataProvider(name = "invalid")
    public Object[][] invalid() {
        return new Object[][]{
                {"fares", "mahmoud", "faresmahmoud1712.mail.com", "gfadsf", "hgyugasdyuf"}

        };
    }
     @Test(dataProvider = "invalid" , priority = 4)
    public void Test_Sinup_with_invalid_Criteria_For_email_Not_match_AcceptanceCriteria(String m, String d, String l, String y, String z) throws InterruptedException {
        h = new HomePage(driver);
        h.Navigate_to_SingUp_Page();
        s = new SingUP_Page(driver);
        s.Fill_First_Name(m);
        s.Entre_Last_Name(d);
        s.Entre_Email(l);
        s.Entre_Password(y);
        s.Entre_RePassword(z);
        s.Click_On_Regester();
        SoftAssert soft = new SoftAssert();
        Thread.sleep(200000);
        WebElement e = driver.findElement(By.cssSelector("p[class=\"MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required\"]"));
        String ax = e.getText();
        soft.assertTrue(ax.contains("Please Insert a correct Email format"));
    }

    @DataProvider(name = "invalidaf")
    public Object[][] invalidaf() {
        return new Object[][]{
                {"fares", "mahmoud", "faresmahmoud1712@mail.com", "gfadsf", "hgyugasdyuf"}
        };
    }
    @Test(dataProvider = "invalidaf" , priority = 5)
    public void verify_we_cannot_singup_if_password_not_match_AcceptanceCriteria(String m, String d, String l, String y, String z) throws InterruptedException {
        h = new HomePage(driver);
        h.Navigate_to_SingUp_Page();
        s = new SingUP_Page(driver);
        s.Fill_First_Name(m);
        s.Entre_Last_Name(d);
        s.Entre_Email(l);
        s.Entre_Password(y);
        s.Entre_RePassword(z);
        s.Click_On_Regester();
        Thread.sleep(5000);
        SoftAssert soft = new SoftAssert();
        WebElement e = driver.findElement(By.cssSelector("p[class=\"MuiFormHelperText-root MuiFormHelperText-contained Mui-error Mui-required\"]"));
        String Actual = e.getText();
        String Expected = "Password must be Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character" ;
        soft.assertEquals(Actual , Expected);
        soft.assertAll();
    }
    @DataProvider(name = "invalidafd")
    public Object[][] invalidafd() {
        return new Object[][]{
                {"fares", "mahmoud", "faresmahmoud1712@mail.com", "gfad555sf@", "hgyugasdyuf"}
        };
    }
    @Test(dataProvider = "invalidafd" , priority = 6)
    public void verify_we_cannot_singup_if_password_not_match_Repass(String m, String d, String l, String y, String z) throws InterruptedException {
        h = new HomePage(driver);
        h.Navigate_to_SingUp_Page();
        s = new SingUP_Page(driver);
        s.Fill_First_Name(m);
        s.Entre_Last_Name(d);
        s.Entre_Email(l);
        s.Entre_Password(y);
        s.Entre_RePassword(z);
        s.Click_On_Regester();
        Thread.sleep(500000);
       SoftAssert soft = new SoftAssert();
         WebElement e =driver.findElement(By.cssSelector("p[class=\"MuiFormHelperText-root MuiFormHelperText-contained Mui-error Mui-required\"]"));
       String x =  e.getText();
       soft.assertTrue(x.contains("Second password does not match the first Password"));
        soft.assertAll();
    }
}