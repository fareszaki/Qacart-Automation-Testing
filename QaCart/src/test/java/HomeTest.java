import org.testng.annotations.Test;

public class HomeTest extends TestBase{
    private HomePage home ;
    @Test(priority = 0)
    public void Verify_that_we_can_navigate_to_SingupPage(){
        home = new HomePage(driver);
        home.Navigate_to_SingUp_Page();
    }
    @Test(priority = 1)
    public  void Verify_that_we_can_navigate_to_LoginPage(){
        home = new HomePage(driver);
        home.Navigate_to_Login_Page();
    }
    @Test(priority = 2)
     public void Verify_that_we_can_navigate_to_HomePage(){
        home = new HomePage(driver);
        home.Navigate_to_Home_Page();
    }

}
