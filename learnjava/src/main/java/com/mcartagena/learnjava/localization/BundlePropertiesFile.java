package com.mcartagena.learnjava.localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class BundlePropertiesFile {
    public static void main(String[] args) {
        var us = new Locale("en", "US");
        var france = new Locale("fr", "FR");

        printWelcomeMessage(us); // Hello, The zoo is open

        printWelcomeMessage(france); // Bonjour, Le zoo est ouvert

        ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
        rb.keySet().stream()
                .map(k -> k + " : " + rb.getString(k))
                .forEach(System.out::println);

        Locale.setDefault(us);
        ResourceBundle rb1 = ResourceBundle.getBundle("Zoo");
        System.out.println(MessageFormat.format(rb1.getString("helloByName"), "Sayen", "Leo"));
    }

    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello") + ", " + rb.getString("open"));
    }
}
