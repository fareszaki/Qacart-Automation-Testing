import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase{
    private LoginPage l ;
    private HomePage h ;
    private LogoutClass o ;
    @DataProvider(name ="data")
    public Object[][] data() {
        return new Object[][]{
                {"fazaki1234@gmail.com", "$FaresMahmoud246810"}
        };
    }
        @Test(dataProvider = "data")
        public void TestLogoutModule(String username , String password) throws InterruptedException {
            h= new HomePage(driver);
            h.Navigate_to_Login_Page();
            l= new LoginPage(driver);
            l.Entre_Email(username);
            l.Entre_Password(password);
            l.Click_Login();
            Thread.sleep(4000);
            o= new LogoutClass(driver);
            o.Clicking_on_LogOut();
        }
    }

