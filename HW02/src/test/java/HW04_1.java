import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;


public class HW04_1 extends TestBase {

    @BeforeAll
    public static void Login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }


    @Test
    @DisplayName("Left menu admin")
    public void Left_Menu() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
        List<WebElement> main_menu = driver.findElements(By.className("name"));
        List<String> mm_names = getNameElem(main_menu);
        areElementsPresent(driver, By.className("name"));

        for (String i : mm_names) {
            driver.findElement(By.xpath("//span[text()='" + i + "']")).click();
            isElementPresent(By.tagName("h1"));

            List<WebElement> sub_menu = driver.findElements(By.cssSelector("[id^='doc-']"));
            List<String> sm_names = getNameElem(sub_menu);

            for (String n : sm_names) {
                driver.findElement(By.xpath("//span[text()='" + n + "']")).click();
                isElementPresent(By.tagName("h1"));
            }

        }

    }

}



