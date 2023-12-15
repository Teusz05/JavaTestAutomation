package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreShoppingCart {

    @FindBy(xpath = "//button[@type=\"submit\" and @class=\"btn btn-primary continue float-xs-right\" and @name=\"confirm-addresses\" and @value=\"1\"]")
    private WebElement addressContinueBtn;

//    @FindBy(id = "delivery_option_8")
//    private WebElement shippingMethodRadio;

    @FindBy(xpath = "//button[@type=\"submit\" and @class=\"continue btn btn-primary float-xs-right\" and @name=\"confirmDeliveryOption\" and @value=\"1\"]")
    private WebElement shippingMethodContinueBtn;


    @FindBy(id = "payment-option-1")
    private WebElement paymentOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeToTermsOfService;

    @FindBy(xpath = "//button[@type=\"submit\" and @class=\"btn btn-primary center-block\" and contains(text(), \"Place order\")]")
    private WebElement placeOrder;

    public MyStoreShoppingCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void completeData() {
        addressContinueBtn.click();
//        shippingMethodRadio.click();
        shippingMethodContinueBtn.click();
        paymentOption.click();
        agreeToTermsOfService.click();
        placeOrder.click();

    }

}
