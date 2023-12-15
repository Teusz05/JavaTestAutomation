package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class MyStore {

    private static WebDriver driver;

    String url = "https://mystore-testlab.coderslab.pl/";

    WebElement signInBtn;
    WebElement emailInput;
    WebElement passwordInput;
    WebElement loginBtn;
    WebElement addressPage;
    WebElement createNewAddressBtn;
    WebElement aliasField;
    WebElement addressField;
    WebElement cityField;
    WebElement postalCodeField;
    WebElement countryField;
    WebElement phoneField;
    WebElement saveNewAddress;
    WebElement updateAddress;
    WebElement deleteAddress;

    private String aliasValue;
    private String addressValue;
    private String cityValue;
    private String postalCodeValue;
    private String phoneValue;
    private String countryValue;


    @Given("The user opens a browser and navigates to the MyStore page")
    public void openMyStoreMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }


    @When("The user navigates to the login page")
    public void goToSignInPage() {
        signInBtn = driver.findElement(By.xpath("//span[contains(text(), 'Sign in')]"));
        signInBtn.click();
    }


    @And("The user enters valid login credentials")
    public void logIntoApp() {
        emailInput = driver.findElement(By.id("field-email"));
        emailInput.sendKeys("vjwnwitvfklelextbx@bbitj.com");
        passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys("haslo123");
        loginBtn = driver.findElement(By.id("submit-login"));
        loginBtn.click();
    }


    @And("The user goes to the 'Addresses' page after logging in")
    public void goToAddressPage() {
        addressPage = driver.findElement(By.xpath("//a[contains(text(), 'Addresses')]"));
        addressPage.click();
    }


    @And("The user clicks the '+ Create new address' button")
    public void createNewAddress() {
        createNewAddressBtn = driver.findElement(By.xpath("//span[contains(text(), \"Create new address\")]"));
        createNewAddressBtn.click();
    }


    @And("The user fills out the New Address form with the following details:")
    public void fillNewAddressFields(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        aliasValue = data.get(1).get("alias");
        addressValue = data.get(1).get("address");
        cityValue = data.get(0).get("city");
        postalCodeValue = data.get(0).get("zip/postal code");
        countryValue = data.get(1).get("country");
        phoneValue = data.get(0).get("phone");

        aliasField = driver.findElement(By.id("field-alias"));
        addressField = driver.findElement(By.id("field-address1"));
        cityField = driver.findElement(By.id("field-city"));
        postalCodeField = driver.findElement(By.id("field-postcode"));
        countryField = driver.findElement(By.id("field-id_country"));
        phoneField = driver.findElement(By.id("field-phone"));

        aliasField.sendKeys(aliasValue);
        addressField.sendKeys(addressValue);
        cityField.sendKeys(cityValue);
        postalCodeField.sendKeys(postalCodeValue);
        countryField.sendKeys(countryValue);
        phoneField.sendKeys(phoneValue);
    }


    @And("The user confirms the addition of the address")
    public void saveAddress() {
        saveNewAddress = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        saveNewAddress.click();
    }


    @Then("The user checks if the data in the added address is correct")
    public void verifyAddedAddressData() {

        updateAddress = driver.findElement(By.xpath("(//a[span[text()=\"Update\"]])[2]"));
        updateAddress.click();

        aliasField = driver.findElement(By.id("field-alias"));
        addressField = driver.findElement(By.id("field-address1"));
        cityField = driver.findElement(By.id("field-city"));
        postalCodeField = driver.findElement(By.id("field-postcode"));
        countryField = driver.findElement(By.id("field-id_country"));
        phoneField = driver.findElement(By.id("field-phone"));

        Assert.assertEquals(aliasValue, aliasField.getAttribute("value"));
        Assert.assertEquals(addressValue, addressField.getAttribute("value"));
        Assert.assertEquals(cityValue, cityField.getAttribute("value"));
        Assert.assertEquals(postalCodeValue, postalCodeField.getAttribute("value"));

        Select countrySelect = new Select(countryField);

        Assert.assertEquals(countryValue, countrySelect.getFirstSelectedOption().getText());
        Assert.assertEquals(phoneValue, phoneField.getAttribute("value"));

        saveAddress();
    }


    @And("The user deletes the above address")
    public void deletePrevAddress() {
        deleteAddress = driver.findElement(By.xpath("(//a[span[text()=\"Delete\"]])[2]"));
        deleteAddress.click();
    }


    @Then("The user checks if the address has been deleted")
    public void verifyDeletedAddress() {

        WebElement deleteAlert = driver.findElement(By.xpath("//article[@class='alert alert-success']/ul/li[text()='Address successfully deleted!']"));
        Assert.assertTrue(deleteAlert.isDisplayed());
    }


    @And("The browser is closed")
    public void tearDown() {
        driver.quit();
    }

}