package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreMainPage {

    @FindBy(xpath = "//span[contains(text(), 'Sign in')]")
    private WebElement signInBtn;

    public MyStoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

}
