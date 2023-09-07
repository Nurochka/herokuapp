import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseSetUp {

    @Test
    public void verifyDynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'gone!')]")));
        int checkboxNumber = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        Assert.assertEquals(checkboxNumber, 0);
        WebElement inputField = driver.findElement(By.xpath("//input"));
        Boolean inputIsEnabled = inputField.isEnabled();
        Assert.assertFalse(inputIsEnabled);
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'enabled!')]")));
        inputIsEnabled = inputField.isEnabled();
        Assert.assertTrue(inputIsEnabled);
    }

}
