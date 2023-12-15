package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreLoginPage {

    @FindBy(id = "field-email")
    private WebElement emailInput;
    @FindBy(id = "field-password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private WebElement loginBtn;


    public MyStoreLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginIntoApp() {
        emailInput.sendKeys("vjwnwitvfklelextbx@bbitj.com");
        passwordInput.sendKeys("haslo123");
        loginBtn.click();
    }

}
