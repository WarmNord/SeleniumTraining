import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HW06_1 extends TestBase {

    public String email = System.currentTimeMillis() / 1000L + "@mail.ru";
    public String firstName = "FirstName";
    public String lastName = "LastName";
    public String address1 = "address1";
    public String postcode = "12345";
    public String city = "City";
    public String phone = "12345";
    public String password = "password";

    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }


    @Test
    public void createNewUser() {
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("New customers click here")));

        driver.findElementByLinkText("New customers click here").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='create_account']")));

        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[name='address1']")).sendKeys(address1);
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys(postcode);
        driver.findElement(By.cssSelector("[name='city']")).sendKeys(city);

        driver.findElement(By.className("select2-selection__arrow")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-search__field")));
        driver.findElement(By.className("select2-search__field")).sendKeys("United States");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select2-dropdown.select2-dropdown--below li")));
        driver.findElement(By.cssSelector(".select2-dropdown.select2-dropdown--below li")).click();

        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys(phone);
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='confirmed_password']")).sendKeys(password);

        driver.findElement(By.cssSelector("[name='create_account']")).click();
        Assertions.assertTrue(driver.findElement(By.className("notice")).getText().contains("Your customer account has been created."));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        logout();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name = 'login']")));
        driver.findElement(By.cssSelector("[name = 'email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[name = 'password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name = 'login']")).click();

        logout();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name = 'login']")));

    }

}

