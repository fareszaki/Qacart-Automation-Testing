import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    protected WebDriver driver ;
    public PageBase(WebDriver driver) {
        this.driver =driver ;
    }
   public void Clicking(WebElement element){
        element.click();
   }
   public void Fill_Feilds(WebElement e , String text){
        e.sendKeys(text);
   }







}
