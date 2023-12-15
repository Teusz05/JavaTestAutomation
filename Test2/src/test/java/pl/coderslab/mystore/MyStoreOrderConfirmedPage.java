package pl.coderslab.mystore;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyStoreOrderConfirmedPage {

    private final WebDriver driver;

    public MyStoreOrderConfirmedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void takeScreenshot() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String timestamp = dateFormat.format(new Date());
            String filename = "screen_" + timestamp + ".png";

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshotFile, new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }



}
