import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class AddRemoveElements extends BaseSetUp{
   /* добавить 2 элемента, удалить элемент, проверить количество элементов  */

    @Test
    public void verifyNumberOfElementsAfterDeleting() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int numberOfDeleteElements = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(numberOfDeleteElements, 1);
    }
}
