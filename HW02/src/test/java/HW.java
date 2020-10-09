import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HW {
    private static ChromeDriver driver;

    @BeforeAll
    @Deprecated
    public static void start() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Open github")
    public void hw02Test() {
        driver.get("https://github.com/WarmNord");
        driver.findElement(By.cssSelector(".p-nickname.vcard-username.d-block"));
    }

    @AfterAll
    public static void stop() {
        driver.quit();
        driver = null;
    }

}
