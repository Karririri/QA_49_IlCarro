package pages;

import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    @Setter
    static WebDriver driver;

    public static void setDriver(WebDriver wd){
        driver = wd;
    }


    public static void pause(int time){
        try {
            Thread.sleep(time * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean elementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
