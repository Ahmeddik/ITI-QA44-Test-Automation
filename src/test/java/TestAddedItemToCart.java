import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAddedItemToCart {

    private WebDriver driver;
    private WebDriverWait wait;
    String url = "https://www.saucedemo.com/";
    String userName = "standard_user";
    String passWord = "secret_sauce";
    By userNameInput = By.id("user-name");
    By passWordInput = By.id("password");
    By logInButton = By.id("login-button");

    String itemtName = "Sauce Labs Backpack";
    String xPath = "//div[@class=\"inventory_item_name \" and text()=\"%s\"] /parent::a/parent::div/following-sibling::div/button[@class=\"btn btn_primary btn_small btn_inventory \"]";
    String xPathWithName = String.format(xPath,itemtName);
    By xPathOfAddToCartButton = By.xpath(xPathWithName);
    By cartPage = By.cssSelector("a span");
    By checkItem = By.xpath("//div[@class=\"inventory_item_name\"]");
    By checkItemByID = By.id("item_4_title_link");
    String elementName;
    /*
    By inventoryItemName = By.cssSelector("div .inventory_item");

    @Test
    public void testStatusAppears(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(userNameInput).sendKeys(userName);
        driver.findElement(passWordInput).sendKeys(passWord);
        driver.findElement(logInButton).click();
        int size = driver.findElements(inventoryItemName).size();
        Assert.assertEquals(size,6);
        driver.close();
    }
    */
    @Test
    public void addElementToCart(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(userNameInput).sendKeys(userName);
        driver.findElement(passWordInput).sendKeys(passWord);
        driver.findElement(logInButton).click();
        /*
        driver.findElement(xPathOfAddToCartButton).click();
        xPathWithName = String.format(xPath,"Sauce Labs Bike Light");
        xPathOfAddToCartButton = By.xpath(xPathWithName);
        */
        driver.findElement(xPathOfAddToCartButton).click();
        driver.findElement(cartPage).click();
        elementName = driver.findElement(checkItem).getText();
        //Assert.assertEquals(elementName,itemtName);
        WebElement itemID = driver.findElement(checkItemByID);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkItem));
        Assert.assertTrue(itemID.isDisplayed());
        driver.close();
    }
}