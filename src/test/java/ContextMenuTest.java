import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseSetUp{

    @Test
    public void verifyAlertPopUpTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement boxToClick = driver.findElement(By.id("hot-spot"));
        actions.contextClick(boxToClick).perform();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, "You selected a context menu");
        driver.switchTo().alert().accept();
    }

}
