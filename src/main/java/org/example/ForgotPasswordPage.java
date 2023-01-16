package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    public final static By BUTTON_LOGIN_IN_FOGGOT_PASSWORD = By.xpath("//*[text()='Войти']");
    private final static String DOMEN = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
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
