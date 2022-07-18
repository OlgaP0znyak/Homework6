package com.it_academy.onliner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page_object.CatalogPage;
import page_object.HomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogItemsExistingTest {
    private HomePage homePage = new HomePage();
    private CatalogPage catalogPage = new CatalogPage();
    private List<String> expectedNamesOfLinkItem = Arrays.asList(
            "Электроника", "Компьютеры и сети","Бытовая техника","Стройка и ремонт","Дом и сад",
            "Авто и мото","Красота и спорт","Детям и мамам","Работа и офис","Еда");
    private List<String> actualNamesOfLinkItem = new ArrayList<>();
    private boolean resultOfComparingNamesOfLinkItem;
    @BeforeAll
    public static void navigateToOnliner(){
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testIsExistNamesOfLinkItemOnCatalogPage(){
        homePage.clickOnHomePageLink("Каталог");
        actualNamesOfLinkItem = catalogPage.getNamesOfLinkItem();
        homePage.closeBrowser();
        resultOfComparingNamesOfLinkItem = actualNamesOfLinkItem.equals(expectedNamesOfLinkItem);
        assertTrue(resultOfComparingNamesOfLinkItem,
                "Названия пунктов меню на странице каталога не соответствуют ожидаемым");
    }


}
