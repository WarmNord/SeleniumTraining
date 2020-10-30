import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HW05_1 extends TestBase {

    @BeforeAll
    public static void Login() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void countries() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("row")));
        WebElement tableCountry = driver.findElement(By.className("dataTable"));
        List<WebElement> rowsTableCountry = tableCountry.findElements(By.className("row"));

        List<WebElement> countries = tableCountry.findElements(By.cssSelector(".row :nth-child(5)"));
        List<String> nameCountries = getNameElem(countries);
        List<String> nameCountriesNotSort = getNameElem(countries);
        Collections.sort(nameCountries);
        Assertions.assertEquals(nameCountries, nameCountriesNotSort);

        List<WebElement> tZ = tableCountry.findElements(By.cssSelector(".row :nth-child(6)"));
        List<String> tZName = getNameElem(tZ);


        for (int i = 0; i < rowsTableCountry.size(); i++) {

            int timeZone = Integer.parseInt(tZName.get(i));


            if (timeZone > 0) {

                WebElement tableCountryF = driver.findElement(By.className("dataTable"));
                List<WebElement> rowsTableCountryF = tableCountryF.findElements(By.className("row"));
                WebElement countryLink = rowsTableCountryF.get(i).findElement(By.cssSelector(":nth-child(5) a"));
                countryLink.click();


                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

                List<WebElement> zCountry = driver.findElements(By.cssSelector("[name$='[name]']"));
                int zCs = zCountry.size() - 1;
                zCountry.remove(zCs);

                List<WebElement> zCountryNotSort = driver.findElements(By.cssSelector("[name$='[name]']"));
                zCountryNotSort.remove(zCs);

                List<String> namesNotSort = new ArrayList<>();
                for (WebElement e : zCountryNotSort) {
                    namesNotSort.add(e.getText());
                }

                List<String> names = new ArrayList<>();
                for (WebElement e : zCountry) {
                    names.add(e.getText());
                }

                Collections.sort(names);

                Assertions.assertEquals(names, namesNotSort);


                driver.navigate().back();


            }

        }

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        WebElement geCountry = driver.findElement(By.className("dataTable"));
        List<WebElement> geoCountry = geCountry.findElements(By.className("row"));

        for (int i = 0; i < geoCountry.size(); i++) {

            WebElement gCountry = driver.findElement(By.className("dataTable"));
            List<WebElement> rCountry = gCountry.findElements(By.className("row"));
            WebElement countryLink = rCountry.get(i).findElement(By.cssSelector(":nth-child(3) a"));
            countryLink.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

            List<WebElement> geoZ = driver.findElements(By.cssSelector("[id=table-zones] tr td:nth-child(3) [selected=selected]"));


            List<WebElement> geoZnotSort = driver.findElements(By.cssSelector("[id=table-zones] tr td:nth-child(3) [selected=selected]"));


            List<String> zNotSort = new ArrayList<>();
            for (WebElement e : geoZnotSort) {
                zNotSort.add(e.getText());
            }

            List<String> zSort = new ArrayList<>();
            for (WebElement e : geoZ) {
                zSort.add(e.getText());
            }

            Collections.sort(zSort);
            Assertions.assertEquals(zNotSort, zSort);



            driver.navigate().back();

        }
    }
}
