import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HoverTest extends BaseSetUp {
    /* Сделать цепочку из действий: наведение на профиль, проверка имени, клик по ссылке, проверка что нет 404 ошибки. Повторить для каждого из профилей. Использовать класс Actions  */

    @Test
    public void verifyHoverActions() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        List<WebElement> profiles = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < profiles.size(); i++) {
            Actions action = new Actions(driver);
            action.moveToElement(profiles.get(i)).moveToElement(driver.findElement(By.xpath("//a[@href='/users/" + (i + 1) + "']"))).click().perform();
            softAssert.assertFalse(driver.getPageSource().contains("404"));
            driver.navigate().back();
        }
        softAssert.assertAll();
    }
}



