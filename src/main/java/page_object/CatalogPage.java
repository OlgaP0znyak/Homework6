package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends AbstractPage {
    private static final String LIST_MAIN_LINKS_PATTERN =
            "//*[@class='catalog-navigation-classifier__item ']/span/span[contains(@class, 'title')]";
    private static final String SUBMENU_OF_COMPUTERS_AND_NETS =
            "//div[contains(@class, 'list__category') and @data-id='2']/div/div/div/div[contains(@class, 'aside-title')]";
    private static final String LIST_SUBMENU_ITEMS_OF_COMPUTERS_AND_NETS =
            "//div[contains(@class, 'list__category') and @data-id='2']/div/div/div/div[contains(@class, 'aside-title') " +
                    "and contains(text(), '%s')]";
    private static final String LIST_TITLES_OF_ELEMENTS_OF_ACCESSORIES =
            "//div[contains(@class, 'list__category') and @data-id='2']/div/div/div/div[contains(@class, 'aside-title') " +
                    "and contains(text(), '�������������')]/following-sibling::*/div/a/span" +
                    "/span[contains(@class, 'title')]";
    private static final String LIST_QUANTITY_AND_PRICE_OF_ELEMENTS_OF_ACCESSORIES =
            "//div[contains(@class, 'list__category') and @data-id='2']/div/div/div/div[contains(@class, 'aside-title')" +
                    "and contains(text(), '�������������')]/following-sibling::*/div/a/span" +
                    "/span[contains(@class, 'description')]";
    private static final String LINK_PATTERN =
            "//*[contains(@class, '__item-title-wrapper') and contains(text(), '%s')]";

    public List<String> getNamesOfLinkItem() {
        List<String> namesOfLinkItem;
        namesOfLinkItem = getListOfTextOfElements(LIST_MAIN_LINKS_PATTERN);
        namesOfLinkItem.remove(0);
        return namesOfLinkItem;
    }

    public void clickOnCatalogPageLink(String link) {
        waitForElementVisible(By.xpath(String.format(LINK_PATTERN, link))).click();
    }

    public List<String> getNamesOfSubmenuItemsOfComputersAndNets() {
        List<String> namesOfListItemsOfComputersAndNets;
        namesOfListItemsOfComputersAndNets = getListOfTextOfElements(SUBMENU_OF_COMPUTERS_AND_NETS);
        return namesOfListItemsOfComputersAndNets;
    }

    public void moveOnItemOfComputersAndNets(String link) {
        WebElement itemOfComputersAndNets;
        itemOfComputersAndNets =
                waitForElementVisible(By.xpath(String.format(LIST_SUBMENU_ITEMS_OF_COMPUTERS_AND_NETS, link)))
                        .findElement(By.xpath(String.format(LIST_SUBMENU_ITEMS_OF_COMPUTERS_AND_NETS, link)));
        moveToElement(itemOfComputersAndNets);

    }

    public List<String> getListOfTextOfElements(String locator) {
        List<WebElement> webElements;
        List<String> textOfWebElements = new ArrayList<>();
        webElements = waitForElementVisible(By.xpath(locator))
                .findElements(By.xpath(locator));

        for (WebElement webElement : webElements) {
            textOfWebElements.add(webElement.getText());
        }
        return textOfWebElements;
    }

    public List<String> getTitlesOfElementsOfAccessories() {
        List<String> titlesOfElementsOfAccessories;
        titlesOfElementsOfAccessories = getListOfTextOfElements(LIST_TITLES_OF_ELEMENTS_OF_ACCESSORIES);
        return titlesOfElementsOfAccessories;
    }

    public List<String[]> getQuantityOfElementsOfAccessories() {
        List<String[]> quantityAndPrice = new ArrayList<>();
        List<WebElement> webElements;
        List<String> textOfWebElements = new ArrayList<>();
        webElements = waitForElementVisible(By.xpath(LIST_QUANTITY_AND_PRICE_OF_ELEMENTS_OF_ACCESSORIES))
                .findElements(By.xpath(LIST_QUANTITY_AND_PRICE_OF_ELEMENTS_OF_ACCESSORIES));

        for (WebElement webElement : webElements) {
            textOfWebElements.add(webElement.getAttribute("innerHTML"));
        }
        for (String textOfWebElement : textOfWebElements) {
            quantityAndPrice.add(textOfWebElement.split("<br>"));
        }
        return quantityAndPrice;
    }
}
