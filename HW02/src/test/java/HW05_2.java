import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;


public class HW05_2 extends TestBase {


    @BeforeAll
    public static void Login() {
        driver.get("http://localhost/litecart");

    }

    @Test
    public void product() {

        // текст названия товара
        WebElement mName = driver.findElement(By.cssSelector("#box-campaigns .name"));
        String mainPageProductName = mName.getText();

        //цены (обычная и акционная)
        WebElement mPriceRegular = driver.findElement(By.cssSelector("#box-campaigns .regular-price"));
        String mainPagePriceRegular = mPriceRegular.getText();
        String pRFonZ = mPriceRegular.getCssValue("font-size");

        WebElement mPriceSale = driver.findElement(By.cssSelector("#box-campaigns .campaign-price"));
        String mainPagePriceSale = mPriceSale.getText();
        String pSFonZ = mPriceSale.getCssValue("font-size");

        //обычная цена зачёркнутая и серая
        String price = mPriceRegular.getTagName();
        Assertions.assertEquals(price, "s");

        String color_grey = mPriceRegular.getCssValue("color");
        Color cGrey = Color.fromString(color_grey);
        Assertions.assertTrue(cGrey.getColor().getBlue() == cGrey.getColor().getRed() && cGrey.getColor().getRed() == cGrey.getColor().getBlue());


        //акционная жирная и красная
        String priceRed = mPriceSale.getTagName();
        Assertions.assertEquals(priceRed, "strong");

        //акционная цена крупнее, чем обычная
        int priceU = Integer.parseInt(mainPagePriceRegular.substring(1));
        int priceS = Integer.parseInt(mainPagePriceSale.substring(1));
        Assertions.assertTrue(priceU > priceS);

        int pRSF = Integer.parseInt(pRFonZ.substring(0,2));
        int pSSF = Integer.parseInt(pSFonZ.substring(0,2));

        Assertions.assertTrue(pRSF < pSSF);

        driver.get("http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");

        // текст названия товара
        WebElement nameP = driver.findElement(By.cssSelector("h1.title"));
        String namePro = nameP.getText();

        Assertions.assertEquals(namePro, mainPageProductName);

        //цены (обычная и акционная)
        WebElement priceRegular = driver.findElement(By.className("regular-price"));
        String pRegular = priceRegular.getText();
        String priceSecond = priceRegular.getTagName();
        String pRFZ = priceRegular.getCssValue("font-size");

        WebElement priceSale = driver.findElement(By.className("campaign-price"));
        String pSale = priceSale.getText();
        String priceRedSecond = priceSale.getTagName();
        String pSFZ = priceSale.getCssValue("font-size");

        Assertions.assertEquals(pRegular, mainPagePriceRegular);
        Assertions.assertEquals(pSale, mainPagePriceSale);

        //обычная цена зачёркнутая и серая
        Assertions.assertEquals(priceSecond, "s");
        String color_greyS = priceRegular.getCssValue("color");
        Color cGreyS = Color.fromString(color_greyS);
        Assertions.assertTrue(cGreyS.getColor().getBlue() == cGreyS.getColor().getRed() && cGreyS.getColor().getRed() == cGreyS.getColor().getBlue());


        //акционная жирная и красная
        Assertions.assertEquals(priceRedSecond, "strong");
        String color_red_s = priceSale.getCssValue("color");
        Color cRedS = Color.fromString(color_red_s);
        Assertions.assertTrue(cRedS.getColor().getBlue() == 0 && cRedS.getColor().getGreen() == 0);

        //акционная цена крупнее, чем обычная
        int priceUSecond = Integer.parseInt(pRegular.substring(1));
        int priceSSecond = Integer.parseInt(pSale.substring(1));
        Assertions.assertTrue(priceUSecond > priceSSecond);

        int pRS = Integer.parseInt(pRFZ.substring(0,2));
        int pSS = Integer.parseInt(pSFZ.substring(0,2));
        Assertions.assertTrue(pRS < pSS);


    }
}
