import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HW04_2 extends TestBase {
    @BeforeAll
    public static void Login() {
        driver.get("http://localhost/litecart");
    }

    @Test
    public void Labels(){
        List<WebElement> ducks = driver.findElementsByClassName(".product.column.shadow.hover-light");
        areElementsPresent(driver,By.className("product"));

        for (WebElement label: ducks) {
            List<WebElement> label_count = label.findElements(By.className("sticker"));
            Assertions.assertEquals(label_count.size(), 1);
            label.findElement(By.className("sticker"));
        }

    }
}
