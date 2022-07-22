package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.WebDriverDiscovery;

import java.time.Duration;

public abstract class AbstractPage {
    private final WebDriver driver;

    public AbstractPage() {
        WebDriverDiscovery webDriverDiscovery = new WebDriverDiscovery();
        this.driver = webDriverDiscovery.getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void moveToElement(WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
    }
}
