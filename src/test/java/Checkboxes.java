import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes extends BaseSetUp{
   /* проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked. Проверить, что второй чекбокс checked, сделать unheck, проверить, что он unchecked
    */

    @Test
    public void verifyFirstCheckboxIsUncheckedByDefault() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = (driver.findElements(By.cssSelector("[type=checkbox]"))).get(0);
        Assert.assertFalse(checkbox1.isSelected());
    }

    @Test
    public void verifyFirstCheckboxCanBeChecked() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = (driver.findElements(By.cssSelector("[type=checkbox]"))).get(0);
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
    }

    @Test
    public void verifySecondCheckboxIsChecked() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 = (driver.findElements(By.cssSelector("[type=checkbox]"))).get(1);
        Assert.assertTrue(checkbox2.isSelected());
    }

    @Test
    public void verifySecondCheckboxCanBeUnchecked() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 = (driver.findElements(By.cssSelector("[type=checkbox]"))).get(1);
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
    }

}
