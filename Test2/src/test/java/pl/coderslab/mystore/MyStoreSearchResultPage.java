package pl.coderslab.mystore;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreSearchResultPage {


    @FindBy(className ="discount-percentage")
    private WebElement discount;

    @FindBy(className = "thumbnail-top")
    private WebElement itemElement;

    public MyStoreSearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkDiscount() {

        String discountValue = discount.getAttribute("textContent");
        Assertions.assertEquals("-20%", discountValue);

    }

    public void clickOnItem() {
        itemElement.click();
    }

}
