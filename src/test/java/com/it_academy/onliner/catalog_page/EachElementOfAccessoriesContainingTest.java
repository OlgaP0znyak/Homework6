package com.it_academy.onliner.catalog_page;

import com.it_academy.onliner.OnlinerNavigation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page_object.CatalogPage;
import page_object.HomePage;
import webDriver.WebDriverDiscovery;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EachElementOfAccessoriesContainingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    List<String> titlesOfElementsOfAccessories = new ArrayList<>();

    @BeforeAll
    public static void navigateToOnliner() {

        WebDriverDiscovery.setDriver();
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testAccessoriesContainElements() {
        homePage.clickOnHomePageLink("�������");
        catalogPage.clickOnCatalogPageLink("����������");
        catalogPage.clickOnItemOfComputersAndNets("�������������");
        titlesOfElementsOfAccessories = catalogPage.getTitlesOfElementsOfAccessories();
        List<String> quantities = catalogPage.getQuantityOfElementsOfAccessories();
        List<String> prices = catalogPage.getPricesOfElementsOfAccessories();

        assertThat(titlesOfElementsOfAccessories)
                .as("� ������ ������������� �� ��� �������� �������� ��������")
                .doesNotContain("")
                .doesNotContainNull();
        assertThat(quantities)
                .as("� ������ ������������� �� ��� �������� �������� ����������")
                .doesNotContain("")
                .doesNotContainNull();
        assertThat(prices)
                .as("� ������ ������������� �� ��� �������� �������� ����")
                .doesNotContain("")
                .doesNotContainNull();
    }

    @AfterAll
    public static void closeBrowser() {
        WebDriverDiscovery.quitDriver();
    }
}

