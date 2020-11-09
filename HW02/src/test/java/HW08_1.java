import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW08_1 extends TestBase {

    private ExpectedCondition<String> waitForNewWindow(Set<String> oldWindows) {
        return driver -> {
            Set<String> windows = driver.getWindowHandles();
            windows.removeAll(oldWindows);
            if (windows.size() > 0)
                return windows.iterator().next();
            else
                return null;
        };
    }

    @BeforeAll
    public static void Login() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void CheckLink() {
        WebElement addCountry = driver.findElement(By.className("button"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addCountry.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByTagName("h1")));

        List<WebElement> outLink = driver.findElements(By.cssSelector("form tbody tr td [target='_blank']"));

        for (int i = 0; i < outLink.size(); i++) {
            String current = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            outLink.get(i).click();
            String newWindow = wait.until(waitForNewWindow(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(current);
        }

    }
}