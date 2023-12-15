package pl.coderslab.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreSearchItem {


    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement searchInput;

    public MyStoreSearchItem(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchingItem() {
        searchInput.sendKeys("Hummingbird Printed Sweater");
        searchInput.submit();

    }

}
