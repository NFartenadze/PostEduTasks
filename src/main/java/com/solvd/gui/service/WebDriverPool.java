package com.solvd.gui.service;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WebDriverPool {
    private static final Map<Long, WebDriver> threadDriver = new HashMap<>();

    public static WebDriver get() {
        return threadDriver.get(Thread.currentThread().getId());
    }

    public static void add(WebDriver driver) {
        threadDriver.put(Thread.currentThread().getId(), driver);
    }

    public static Set<Map.Entry<Long, WebDriver>> entrySet() {
        return threadDriver.entrySet();
    }
}
