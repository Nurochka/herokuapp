import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TyposTest extends BaseSetUp{
   /* Проверить соответствие параграфа орфографии  */

    @Test
    public void verifyValuesCanBeSelectedByArrowUp() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_UP);
        String displayedValue = input.getAttribute("value");
        Assert.assertEquals(displayedValue, "1");
    }

    @Test
    public void verifyValuesCanBeSelectedByArrowDown() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        String displayedValue = input.getAttribute("value");
        Assert.assertEquals(displayedValue, "-3");
    }

    @Test
    public void verifyLettersCannotBeEnteredFromKeyboard() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.CONTROL);
        input.sendKeys("V");
        String displayedValue = input.getAttribute("value");
        Assert.assertEquals(displayedValue, "");
    }

    @Test
    public void verifyTypoInParagrath() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> paragrath = driver.findElements(By.tagName("p"));
        String stringToCheck = paragrath.get(1).getText();
        Assert.assertTrue(stringToCheck.contains("won't"));
    }
}
