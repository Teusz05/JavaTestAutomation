package pl.coderslab.mystore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class MyStoreTest {

    int quantity = 6;
    String size = "M";

    private static WebDriver driver;

    
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }

    @Test
    public void testSignIn() {

        MyStoreMainPage mainPage = new MyStoreMainPage(driver);
        mainPage.clickSignInBtn();

        MyStoreLoginPage loginPage = new MyStoreLoginPage(driver);
        loginPage.loginIntoApp();

        MyStoreSearchItem accountPage = new MyStoreSearchItem(driver);
        accountPage.searchingItem();

        MyStoreSearchResultPage searchResultPage = new MyStoreSearchResultPage(driver);
        searchResultPage.checkDiscount();
        searchResultPage.clickOnItem();

        MyStoreItemPage itemPage = new MyStoreItemPage(driver);
        itemPage.chooseSize(size);
        itemPage.chooseQuantity(quantity);
        itemPage.addtoCart();
        itemPage.goToProceed();

        MyStoreProceedToCheckout proceedToCheckout = new MyStoreProceedToCheckout(driver);
        proceedToCheckout.clickProceedToCheckout();

        MyStoreShoppingCart shoppingCart = new MyStoreShoppingCart(driver);
        shoppingCart.completeData();

        MyStoreOrderConfirmedPage orderConfirmedPage = new MyStoreOrderConfirmedPage(driver);
        orderConfirmedPage.takeScreenshot();

    }
}
