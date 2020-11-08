import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
*
* [x] Задание 12. Сделайте сценарий добавления товара
Сделайте сценарий для добавления нового товара (продукта) в учебном приложении litecart (в админке).

Для добавления товара нужно открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product", заполнить поля с информацией о товаре и сохранить.

Достаточно заполнить только информацию на вкладках General, Information и Prices. Скидки (Campains) на вкладке Prices можно не добавлять.

Переключение между вкладками происходит не мгновенно, поэтому после переключения можно сделать небольшую паузу (о том, как делать более правильные ожидания, будет рассказано в следующих занятиях).

Картинку с изображением товара нужно уложить в репозиторий вместе с кодом. При этом указывать в коде полный абсолютный путь к файлу плохо, на другой машине работать не будет. Надо средствами языка программирования преобразовать относительный путь в абсолютный.

После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.

Можно оформить сценарий либо как тест, либо как отдельный исполняемый файл.
*
*
*
* */

public class HW06_2 extends TestBase {


    @BeforeAll
    public static void Login() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void addProduct() {

        driver.get("http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
        //List<WebElement> add = driver.findElements(By.cssSelector("a.button"));
        //wait.until(ExpectedConditions.attributeToBeNotEmpty(add.get(1), "href"));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //add.get(1).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_images[]")));


        WebElement rb1 = driver.findElement(By.cssSelector("[name=\"status\"]"));
        rb1.click();

        driver.findElement(By.cssSelector("[name='name[en]']")).sendKeys("Test Product");

        driver.findElement(By.cssSelector("[name='code']")).sendKeys("12345");

        List<WebElement> gender = driver.findElements(By.name("product_groups[]"));
        gender.get(2).click();

        WebElement quantity = driver.findElement(By.name("quantity"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        quantity.sendKeys("10");

        WebElement picture = driver.findElement(By.name("new_images[]"));
        File pic = new File("src\\test\\resources\\pic.JPG");
        picture.sendKeys(pic.getAbsolutePath());
        System.out.println(picture.getCssValue("value"));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(picture, "value"));

        WebElement dateFrom = driver.findElementByName("date_valid_from");
        dateFrom.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dateFrom.sendKeys("01112020");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dateFrom, "value"));

        WebElement dateTo = driver.findElementByName("date_valid_to");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dateTo.click();
        dateTo.sendKeys("31122020");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dateTo, "value"));


        WebElement info = driver.findElement(By.linkText("Information"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        info.click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


        driver.findElement(By.name("keywords")).sendKeys("test");
        driver.findElement(By.name("short_description[en]")).sendKeys("test test");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("A lot of word oabout product");
        driver.findElement(By.name("head_title[en]")).sendKeys("Test");
        driver.findElement(By.name("meta_description[en]")).sendKeys("Test");

        WebElement price = driver.findElement(By.linkText("Prices"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        price.click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        WebElement purchase_price = driver.findElementByName("purchase_price");
        purchase_price.click();
        purchase_price.sendKeys("10");

        WebElement pprice = driver.findElementByName("purchase_price_currency_code");
        pprice.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement usd = driver.findElementByCssSelector("[value = 'USD']");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        usd.click();

        WebElement price2 = driver.findElement(By.cssSelector(".input-wrapper [name=\"prices[USD]\"]"));
        price2.click();
        price2.sendKeys("100");

/*        WebElement tax = driver.findElementByName("gross_prices[USD]");
        tax.click();
        tax.sendKeys("20");*/

        WebElement save = driver.findElement(By.name("save"));
        save.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=0");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement testProduct = driver.findElementByLinkText("Test Product");
        Assertions.assertTrue(isElementPresent(By.linkText("Test Product")));

    }


}
