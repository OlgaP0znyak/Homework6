package com.it_academy.onliner.catalog_page;

import com.it_academy.onliner.OnlinerNavigation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page_object.CatalogPage;
import page_object.HomePage;
import webDriver.WebDriverDiscovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListItemsOfComputersAndNetsExistingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    List<String> actualNamesOfListItemsOfComputersAndNets = new ArrayList<>();
    private final List<String> expectedNamesOfListItemsOfComputersAndNets = Arrays.asList(
            "��������, ����������, ��������", "�������������", "�������� ������", "������� ������������");

    @BeforeAll
    public static void navigateToOnliner() {
        WebDriverDiscovery.setDriver();
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testIsExistNamesOfLinkItemOnCatalogPage() {
        homePage.clickOnHomePageLink("�������");
        catalogPage.clickOnCatalogPageLink("����������");
        actualNamesOfListItemsOfComputersAndNets = catalogPage.getNamesOfSubmenuItemsOfComputersAndNets();

        assertThat(actualNamesOfListItemsOfComputersAndNets)
                .as("������ ������� \"���������� � ����\" �� �������� ��������� �������� ������� ����")
                .containsAll(expectedNamesOfListItemsOfComputersAndNets);

    }

    @AfterAll
    public static void closeBrowser() {
        WebDriverDiscovery.quitDriver();
    }
}
