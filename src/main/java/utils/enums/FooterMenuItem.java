package utils.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.BasePage.driver;

public enum FooterMenuItem {
    ICON_FACEBOOK("a[href='https://www.facebook.com/']"),
    ICON_TELEGRAM("a[href='https://telegram.org/']"),
    ICON_VK("a[href='https://vk.com/']"),
    ICON_INSTAGRAM("a[href='https://www.instagram.com/']"),
    ICON_SLACK("a[href='https://slack.com/']");
    private  String locator;

     FooterMenuItem(String locator){
        this.locator = locator;
    }

    public String getLocator(){
        return locator;
    }

    public boolean clickFooterItem(FooterMenuItem item, String title){
        driver.findElement(By.cssSelector(item.getLocator())).click();
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains(title));
    }
}
