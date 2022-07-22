package com.it_academy.onliner.catalog_page;

import com.it_academy.onliner.OnlinerNavigation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page_object.CatalogPage;
import page_object.HomePage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class EachElementOfAccessoriesContainingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    List<String> titlesOfElementsOfAccessories = new ArrayList<>();
    boolean isElementWithoutTitle;
    boolean isElementWithoutQuantityAndPrice;

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testAccessoriesContainElements() {
        homePage.clickOnHomePageLink("Каталог");
        catalogPage.clickOnCatalogPageLink("Компьютеры");
        catalogPage.moveOnItemOfComputersAndNets("Комплектующие");
        titlesOfElementsOfAccessories = catalogPage.getTitlesOfElementsOfAccessories();
        isElementWithoutTitle = titlesOfElementsOfAccessories.contains("");

        List<String[]> quantitiesAndPrices = catalogPage.getQuantityOfElementsOfAccessories();
        homePage.closeBrowser();

        for (String[] quantityAndPrice : quantitiesAndPrices) {
            for (String quantityOrPrice : quantityAndPrice) {
                if (quantityOrPrice.equals("")) {
                    isElementWithoutQuantityAndPrice = true;
                    break;
                }
            }
        }
        assertFalse(isElementWithoutTitle, "В списке комплектующих не все элементы содержат название");
        assertFalse(isElementWithoutQuantityAndPrice,
                "В списке комплектующих не все элементы содержат количество и цену");
    }
}
