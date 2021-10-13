package com.mcartagena.learnjava.localization;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleCategory {
    public static void main(String[] args) {
        var spain = new Locale("es", "ES");
        var money = 1.23;

        // Print with default locale
        Locale.setDefault(new Locale("en", "US"));
        printCurrency(spain, money); // $1.23, Spain

        // Print with default locale and selected locale display
        Locale.setDefault(Locale.Category.DISPLAY, spain);
        printCurrency(spain, money); // $1.23, español

        // Print with default locale and select locale format
        Locale.setDefault(Locale.Category.FORMAT, spain);
        printCurrency(spain, money); // 1,23 €, español

        Locale.setDefault(new Locale("en", "US"));
        printCurrency(spain, money); // $1.23, Spanish

    }
    public static void printCurrency(Locale locale, double money){
        System.out.println(NumberFormat.getCurrencyInstance().format(money) + ", " + locale.getDisplayLanguage());
    }
}
