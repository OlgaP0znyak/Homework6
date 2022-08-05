package page_object;

import org.openqa.selenium.By;

public class HomePage extends AbstractPage {
    private static final String NAVIGATION_LINK_PATTERN =
            "//*[contains(@class, 'b-main-navigation__text') and contains(text(), '%s')]";

    public void clickOnHomePageLink(String link) {
        waitForElementVisible(By.xpath(String.format(NAVIGATION_LINK_PATTERN, link))).click();
    }
}
