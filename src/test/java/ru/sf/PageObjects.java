package ru.sf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {

    private static final String URL = "https://skillfactory.ru/";
    private final WebDriver webdriver;

    public PageObjects (WebDriver webdriver){
        this.webdriver = webdriver;
    }

    public void goUrl (String Url){
        webdriver.get(URL);
    }


    }






