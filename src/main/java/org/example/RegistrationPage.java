package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    public final static By BUTTON_FIELD_NAME = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    public final static By BUTTON_FIELD_EMAIL = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    public final static By BUTTON_FIELD_PASSWORD = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");
    public final static By BUTTON_REGISTER_FINAL = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    public final static By BUTTON_LOGIN_IN_REGISTRATION = By.xpath("//*[text()='Войти']");
    public final static By EXPECTED_TEXT_REGISTRATION_FALIED_PASSWORD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");
    private final static String DOMEN = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
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
