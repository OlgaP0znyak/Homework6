package com.it_academy.onliner.catalog_page;

import com.it_academy.onliner.OnlinerNavigation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page_object.CatalogPage;
import page_object.HomePage;
import webDriver.WebDriverDiscovery;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainMenuItemsExistingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    private final List<String> expectedNamesOfLinkItem = Arrays.asList(
            "�����������", "���������� � ����", "������� �������", "������� � ������", "��� � ���",
            "���� � ����", "������� � �����", "����� � �����", "������ � ����", "���");

    @BeforeAll
    public static void navigateToOnliner() {
        WebDriverDiscovery.setDriver();
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testIsExistNamesOfLinkItemOnCatalogPage() {
        homePage.clickOnHomePageLink("�������");
        List<String> actualNamesOfLinkItem = catalogPage.getNamesOfLinkItem();

        assertThat(actualNamesOfLinkItem)
                .as("�������� ������� ���� �� �������� �������� �� ������������� ���������")
                .containsAll(expectedNamesOfLinkItem);
    }

    @AfterAll
    public static void closeBrowser() {
        WebDriverDiscovery.quitDriver();
    }
}
