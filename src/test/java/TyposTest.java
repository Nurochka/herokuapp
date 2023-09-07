import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TyposTest extends BaseSetUp {
    /* Проверить соответствие параграфа орфографии  */

    @Test
    public void verifyTypoInParagrath() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> paragrath = driver.findElements(By.tagName("p"));
        String stringToCheck = paragrath.get(1).getText();
        Assert.assertTrue(stringToCheck.contains("won't"));
    }
}
