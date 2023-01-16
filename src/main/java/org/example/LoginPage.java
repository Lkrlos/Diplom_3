package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public final static By BUTTON_REGISTER = By.xpath("//*[text() = 'Зарегистрироваться']");
    public final static By BUTTON_FOGGOT_PASSWORD = By.xpath("/html/body/div/div/main/div/div/p[2]/a");
    public final static By FIELD_LOGIN_EMAIL = By.xpath("//input[@type='text' and @name='name']");
    public final static By FIELD_LOGIN_PASSWORD = By.xpath("//input[@type='password' and @name='Пароль']");
    public final static By BUTTON_LOGIN_ENTRANCE = By.xpath("//*[text() = 'Войти']");
    public final static By EXPECTED_TEXT_FOR_EXIT_ACCOUNT = By.xpath("/html/body/div/div/main/div/h2");
    private final static String DOMEN = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
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
