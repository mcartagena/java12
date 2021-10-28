package com.mcartagena.learnjava.localization;

import java.util.Properties;

public class ZooOptions {
    public static void main(String[] args) {
        var props = new Properties();
        props.setProperty("name", "Our zoo");
        props.setProperty("open", "10am");

        System.out.println(props.getProperty("camel"));
        System.out.println(props.getProperty("camel", "Bob"));

        System.out.println(props.get("open"));
        // props.get("open","11am"); DOES NOT COMPILE



    }
}
