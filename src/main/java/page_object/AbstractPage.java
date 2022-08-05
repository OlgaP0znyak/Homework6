package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.WebDriverDiscovery;

import java.time.Duration;

public abstract class AbstractPage {

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(WebDriverDiscovery.getDriver(), Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void navigate(String url) {
        WebDriverDiscovery.getDriver().get(url);
    }
}
