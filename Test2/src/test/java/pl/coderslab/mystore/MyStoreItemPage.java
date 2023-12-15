package pl.coderslab.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyStoreItemPage {

    private final WebDriver driver;

    @FindBy(id = "group_1")
    WebElement selectMenuSize;

    @FindBy(id = "quantity_wanted")
    WebElement quantityInput;

    @FindBy(xpath = "//button[@class=\"btn btn-primary add-to-cart\"]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//i[@class=\"material-icons shopping-cart\"]")
    private WebElement cart;


    public MyStoreItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSize(String size) {
        Select selectSize = new Select(selectMenuSize);
        selectSize.selectByVisibleText(size);
    }

    public void chooseQuantity(int numberOfItem)  {
        quantityInput.click();
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));

        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(String.valueOf(numberOfItem));
    }

    public void addtoCart() {
        addToCartBtn.click();
    }

    public void goToProceed() {

        driver.navigate().refresh();
        cart.click();

    }
}
