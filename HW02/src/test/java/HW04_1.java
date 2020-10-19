import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class HW04_1 extends TestBase {

    //*[text()=' Template'] поиск заголовков на странице
    // //*[@class = 'name'][contains(text(), 'Appearence')] Поиск кнопок слева
    // //*[@class = 'name'][contains(text(), 'Template')] Поиск подменю

    @BeforeAll
    public static void Login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }


    @Test
    @DisplayName("Appearence")
    public void Appearence() {
        driver.findElement(By.linkText("Appearence")).click();
        assertTrue(isElementPresent(By.id("doc-template")));

        driver.findElement(By.id("doc-template")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Template']")));

        driver.findElement(By.xpath("//*[@class = 'name'][contains(text(), 'Logotype')]")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Logotype']")));
    }


    @Test
    @DisplayName("Catalog")
    public void Catalog() {
        driver.findElement(By.xpath("//*[@class = 'name'][contains(text(), 'Catalog')]")).click();
        assertTrue(isElementPresent(By.id("doc-catalog")));

        driver.findElement(By.id("doc-catalog")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Catalog']")));

        driver.findElement(By.id("doc-product_groups")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Product Groups']")));

        driver.findElement(By.id("doc-option_groups")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Option Groups']")));

        driver.findElement(By.id("doc-manufacturers")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Manufacturers']")));

        driver.findElement(By.id("doc-suppliers")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Suppliers']")));

        driver.findElement(By.id("doc-delivery_statuses")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Delivery Statuses']")));

        driver.findElement(By.id("doc-sold_out_statuses")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Sold Out Statuses']")));

        driver.findElement(By.id("doc-quantity_units")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Quantity Units']")));

        WebElement lel = driver.findElement(By.id("doc-csv"));
        lel.click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' CSV Import/Export']")));
    }


    @Test
    @DisplayName("Countries")
    public void Countries() {
        driver.findElement(By.xpath("//*[@class = 'name'][contains(text(), 'Countries')]")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Countries']")));
    }

    @Test
    @DisplayName("Currencies")
    public void Currencies() {
        driver.findElement(By.xpath("//*[@class = 'name'][contains(text(), 'Currencies')]")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Currencies']")));
    }

    @Test
    @DisplayName("Customers")
    public void Customers() {
        driver.findElement(By.xpath("//*[@class = 'name'][contains(text(), 'Customers')]")).click();
        assertTrue(isElementPresent(By.id("doc-customers")));
        driver.findElement(By.id("doc-customers")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Customers']")));

        driver.findElement(By.id("doc-csv")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' CSV Import/Export']")));

        driver.findElement(By.id("doc-newsletter")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Newsletter']")));
    }

    @Test
    @DisplayName("Geo Zones")
    public void Geo_Zones() {
        driver.findElement(By.xpath("//*[@class = 'name'][contains(text(), 'Geo Zones')]")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Geo Zones']")));
    }

    @Test
    @DisplayName("Languages")
    public void Languages() {
        driver.findElement(By.linkText("Languages")).click();
        assertTrue(isElementPresent(By.id("doc-languages")));
        driver.findElement(By.id("doc-languages")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Languages']")));

        driver.findElement(By.id("doc-storage_encoding")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Storage Encoding']")));

    }

    @Test
    @DisplayName("Modules")
    public void Modules() {
        driver.findElement(By.linkText("Modules")).click();

        assertTrue(isElementPresent(By.id("doc-jobs")));
        driver.findElement(By.id("doc-jobs")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Job Modules']")));

        driver.findElement(By.id("doc-customer")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Customer Modules']")));

        driver.findElement(By.id("doc-shipping")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Shipping Modules']")));

        driver.findElement(By.id("doc-payment")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Payment Modules']")));

        driver.findElement(By.id("doc-order_total")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Order Total Modules']")));

        driver.findElement(By.id("doc-order_success")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Order Success Modules']")));

        driver.findElement(By.id("doc-order_action")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Order Action Modules']")));

    }


    @Test
    @DisplayName("Orders")
    public void Orders() {

        driver.findElement(By.linkText("Orders")).click();

        assertTrue(isElementPresent(By.id("doc-orders")));
        driver.findElement(By.id("doc-orders")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Orders']")));

        driver.findElement(By.id("doc-order_statuses")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Order Statuses']")));
    }

    @Test
    @DisplayName("Pages")
    public void Pages() {
        driver.findElement(By.linkText("Pages")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Pages']")));
    }

    @Test
    @DisplayName("Reports")
    public void Reports() {

        driver.findElement(By.linkText("Reports")).click();

        assertTrue(isElementPresent(By.id("doc-monthly_sales")));
        driver.findElement(By.id("doc-monthly_sales")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Monthly Sales']")));

        driver.findElement(By.id("doc-most_sold_products")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Most Sold Products']")));

        driver.findElement(By.id("doc-most_shopping_customers")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Most Shopping Customers']")));
    }

    @Test
    @DisplayName("Settings")
    public void Settings() {

        driver.findElement(By.linkText("Settings")).click();

        assertTrue(isElementPresent(By.id("doc-store_info")));
        driver.findElement(By.id("doc-store_info")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

        driver.findElement(By.id("doc-defaults")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

        driver.findElement(By.id("doc-general")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

        driver.findElement(By.id("doc-listings")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

        driver.findElement(By.id("doc-images")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

        driver.findElement(By.id("doc-checkout")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

        driver.findElement(By.id("doc-advanced")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

        driver.findElement(By.id("doc-security")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Settings']")));

    }

    @Test
    @DisplayName("Slides")
    public void Slides() {
        driver.findElement(By.linkText("Slides")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Slides']")));
    }

    @Test
    @DisplayName("Tax")
    public void Tax() {

        driver.findElement(By.linkText("Tax")).click();

        assertTrue(isElementPresent(By.id("doc-tax_classes")));
        driver.findElement(By.id("doc-tax_classes")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Tax Classes']")));

        driver.findElement(By.id("doc-tax_rates")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Tax Rates']")));
    }

    @Test
    @DisplayName("Translations")
    public void Translations() {

        driver.findElement(By.linkText("Translations")).click();

        assertTrue(isElementPresent(By.id("doc-search")));
        driver.findElement(By.id("doc-search")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Search Translations']")));

        driver.findElement(By.id("doc-scan")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Scan Files For Translations']")));

        driver.findElement(By.id("doc-csv")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' CSV Import/Export']")));

    }

    @Test
    @DisplayName("Users")
    public void Users() {
        driver.findElement(By.linkText("Users")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' Users']")));
    }

    @Test
    @DisplayName("vQmods")
    public void vQmods() {

        driver.findElement(By.linkText("vQmods")).click();

        assertTrue(isElementPresent(By.id("doc-vqmods")));
        driver.findElement(By.id("doc-vqmods")).click();
        assertTrue(isElementPresent(By.xpath("//*[text()=' vQmods']")));

    }


}
