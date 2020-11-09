import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW10_1 extends TestBase {

    @BeforeAll
    public static void Login() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void Log() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> products = driver.findElements(By.xpath(".//tr/td[3]/a"));
        products.remove(0);
        List<String> productNames = getNameElem(products);

        for (String product : productNames) {
            driver.findElement(By.linkText(product)).click();
            List<LogEntry> log = driver.manage().logs().get("browser").getAll();
            driver.manage().logs().get("browser").forEach(logs -> System.out.println(logs));
            Assertions.assertTrue(log.isEmpty());
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        }
    }
}
