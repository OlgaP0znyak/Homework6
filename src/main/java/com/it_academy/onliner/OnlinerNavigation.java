package com.it_academy.onliner;

import page_object.HomePage;

public class OnlinerNavigation {
    public static void navigateToOnlinerHomePage() {
        new HomePage().navigate("https://www.onliner.by");
    }
}
