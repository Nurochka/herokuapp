import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DropdownTest extends BaseSetUp{
   /*  Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
    */

    @Test
    public void verifyValuesInDropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(options.get(0).getText(), "Please select an option");
        softAssert.assertEquals(options.get(1).getText(), "Option 1");
        softAssert.assertEquals(options.get(2).getText(), "Option 2");

        select.selectByVisibleText("Option 1");
        softAssert.assertTrue(options.get(1).isSelected());

        select.selectByValue("2");
        softAssert.assertTrue(options.get(2).isSelected());

        softAssert.assertAll();
    }
}
