import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ToDoTest extends TestBase {
    private HomePage h;
    private LoginPage l;
    private ToDoClass t;

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {"fazaki1234@gmail.com", "$FaresMahmoud246810", " fares"}
        };
    }

    @Test(dataProvider = "data" , priority = 0)
    public void verify_that_we_can_create_Todo_Task(String username, String Pass, String ToDoName) {
        h = new HomePage(driver);
        h.Navigate_to_Login_Page();
        l = new LoginPage(driver);
        l.Entre_Email(username);
        l.Entre_Password(Pass);
        l.Click_Login();
        t = new ToDoClass(driver);
        t.ADD_New_ToDo();
        t.Entre_TodoName(ToDoName);
        t.ClickOnCreateTodo();
        //Creating Assertion using SoftAssert
        SoftAssert soft = new SoftAssert();
        WebElement elemet = driver.findElement(By.cssSelector("div[data-testid=\"todo-item\"]"));
        String TodoName = elemet.getText();
        soft.assertTrue(TodoName.contains("fares"));
        // verify that todo is Appeared in UI
        soft.assertTrue(elemet.isDisplayed());
        soft.assertAll();
    }

    @DataProvider(name = "data1")
    public Object[][] data1() {
        return new Object[][]{
                {"fazaki1234@gmail.com", "$FaresMahmoud246810", " fares", "mohamed", "alid"}
        };
    }
        @Test(dataProvider = "data1" , priority = 1)
        public void verify_that_we_can_Delete_TodoTask(String username, String Pass, String ToDoName , String x , String u) throws InterruptedException {
            h = new HomePage(driver);
            h.Navigate_to_Login_Page();
            l = new LoginPage(driver);
            l.Entre_Email(username);
            l.Entre_Password(Pass);
            l.Click_Login();
            t = new ToDoClass(driver);
            t.ADD_New_ToDo();
            t.Entre_TodoName(ToDoName);
            t.ClickOnCreateTodo();
            t.ADD_New_ToDo();
            t.Entre_TodoName(x);
            t.ClickOnCreateTodo();
            t.ADD_New_ToDo();
            t.Entre_TodoName(u);
            t.ClickOnCreateTodo();
            t.DeletingElE();
            Thread.sleep(3000);
            t.DeletingElE();
        }

    @DataProvider(name = "data2")
    public Object[][] data2() {
        return new Object[][]{
                {"fazaki1234@gmail.com", "$FaresMahmoud246810", " fares", "mohamed", "alid" , "xss" ,"fareas" }
        };
    }
    @Test(dataProvider = "data2" , priority=2)
   public void test_we_can_Add_Five_Task_in_page(String username, String Pass, String ToDoName , String x , String u , String a , String m){
        h = new HomePage(driver);
        h.Navigate_to_Login_Page();
        l = new LoginPage(driver);
        l.Entre_Email(username);
        l.Entre_Password(Pass);
        l.Click_Login();
        t = new ToDoClass(driver);
        t.ADD_New_ToDo();
        t.Entre_TodoName(ToDoName);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(x);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(u);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(a);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(m);
        t.ClickOnCreateTodo();

    }

    @DataProvider(name = "data3")
    public Object[][] data3() {
        return new Object[][]{
                {"fazaki1234@gmail.com", "$FaresMahmoud246810", " fares", "mohamed", "alid" , "rte" , "wer" , "qwe"}
        };
    }
    @Test(dataProvider = "data3" , priority = 3)
    public void test_If_We_Add_Six_Task_Once_TheSixth_Task_ADD_in_page(String username, String Pass, String ToDoName , String x , String u , String a , String m , String w) {
        h = new HomePage(driver);
        h.Navigate_to_Login_Page();
        l = new LoginPage(driver);
        l.Entre_Email(username);
        l.Entre_Password(Pass);
        l.Click_Login();
        t = new ToDoClass(driver);
        t.ADD_New_ToDo();
        t.Entre_TodoName(ToDoName);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(x);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(u);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(a);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(m);
        t.ClickOnCreateTodo();
        t.ADD_New_ToDo();
        t.Entre_TodoName(w);
        t.ClickOnCreateTodo();


    }



    }

