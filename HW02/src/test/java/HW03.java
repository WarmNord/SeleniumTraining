import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW03 {
    private static ChromeDriver driver;

    @BeforeAll
    @Deprecated
    public static void start() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Login")
    public void hw02Test() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @AfterAll
    public static void stop() {
        driver.quit();
        driver = null;
    }
}
