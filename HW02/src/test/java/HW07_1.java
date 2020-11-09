import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;


public class HW07_1 extends TestBase {

    @Override
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void clickFirstProduct(String Locator) {
        WebElement firstProduct = driver.findElement(By.className(Locator));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        firstProduct.click();
    }

    public void size(String NameLocator) {
        WebElement size = driver.findElement(By.name(NameLocator));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        size.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement small = driver.findElement(By.cssSelector("[value ='Small']"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        small.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public void addToCart(String name) {
        driver.findElementByName(name).click();

    }

    public void removeProduct(String name) {
        driver.findElement(By.name(name)).click();
    }


    @BeforeAll
    public static void Login() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void AddProductCart() {

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        for (int i = 1; i < 4; i++) {
            clickFirstProduct("name");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            boolean isElPres = isElementPresent(By.cssSelector(".options"));
            if (isElPres) {
                size("options[Size]");
                addToCart("add_cart_product");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebElement qua = driver.findElement(By.cssSelector("#cart-wrapper .quantity"));
                wait.until(ExpectedConditions.attributeToBe(qua, "textContent", String.valueOf(i)));
                driver.get("http://localhost/litecart");
            } else {
                addToCart("add_cart_product");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebElement qua = driver.findElement(By.cssSelector("#cart-wrapper .quantity"));
                wait.until(ExpectedConditions.attributeToBe(qua, "textContent", String.valueOf(i)));
                driver.get("http://localhost/litecart");
            }

        }

        driver.get("http://localhost/litecart/en/checkout");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> rowProduct = driver.findElements(By.cssSelector("#order_confirmation-wrapper tr td.item"));
        for (int i = 0; i < rowProduct.size(); i++) {
            removeProduct("remove_cart_item");
            wait.until(stalenessOf(rowProduct.get(i)));
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement freeCart = driver.findElement(By.cssSelector("#checkout-cart-wrapper em"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.attributeToBe(freeCart, "textContent", "There are no items in your cart."));

    }

}
