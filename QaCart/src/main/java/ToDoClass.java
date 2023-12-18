import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoClass extends PageBase{
    public ToDoClass(WebDriver driver) {
        super(driver);
    }
    private By Create_New_ToDo = By.cssSelector("svg[data-testid=\"add\"]");
     private WebElement element ;
     private By Fill_Todo_name = By.cssSelector("input[data-testid=\"new-todo\"]");
     private WebElement e ;
     public void ADD_New_ToDo(){
         element = driver.findElement(Create_New_ToDo);
         Clicking(element);

     }
     public void Entre_TodoName(String ToDoName){
         e= driver.findElement(Fill_Todo_name);
         Fill_Feilds(e , ToDoName);
     }
     public void ClickOnCreateTodo(){
         WebElement e = driver.findElement(By.cssSelector("button[data-testid=\"submit-newTask\"]"));
         Clicking(e);
     }

    private By x = By.cssSelector("button[data-testid=\"delete\"]");
    private  WebElement e2 ;

    public void DeletingElE(){
        e2= driver.findElement(x);
        Clicking(e2);
    }
}
