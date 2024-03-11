import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddedItemToCart {

    private WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String userName = "standard_user";
    String passWord = "secret_sauce";
    By userNameInput = By.id("user-name");
    By passWordInput = By.id("password");
    By logInButton = By.id("login-button");

    String xPath = "//div[@class=\"inventory_item_name \" and text()=\"%s\"] /parent::a/parent::div/following-sibling::div/button[@class=\"btn btn_primary btn_small btn_inventory \"]";
    String xPathWithName = String.format(xPath,"Sauce Labs Backpack");
    By xPathOfAddToCartButton = By.xpath(xPathWithName);
    By cartPage = By.cssSelector("a span");
    By checkItem = By.xpath("//div[@class=\"inventory_item_name\"]");
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

        driver.findElement(xPathOfAddToCartButton).click();
        driver.findElement(cartPage).click();
        elementName = driver.findElement(checkItem).getText();
        Assert.assertEquals(elementName,"Sauce Labs Backpack");
        driver.close();
    }
}