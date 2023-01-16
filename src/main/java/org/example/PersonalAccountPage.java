package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private final static String DOMEN = "https://stellarburgers.nomoreparties.site/";
    public final static By BUTTON_EXIT_PERSONAL_ACCOUNT = By.xpath("//button[text()='Выход']");
    private final WebDriver driver;
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToItem(By item) {
        driver.findElement(item).click();
    }
    public void goInServis() {
        driver.get(DOMEN);
    }
    public void sendTextToField(By field, String text) {
        driver.findElement(field).sendKeys(text);
    }
}
