package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final static String DOMEN = "https://stellarburgers.nomoreparties.site/";
    public final static By BUTTON_LOG_IN_ACCOUNT = By.xpath("/html/body/div/div/main/section[2]/div/button");
    public final static By BUTTON_PERSONAL_ACCOUNT = By.xpath("/html/body/div/div/header/nav/a/p");
    public final static By BUTTON_LOGO = By.xpath("//*[@class = 'AppHeader_header__logo__2D0X2']");
    public final static By BUTTON_DESIGNER = By.xpath("/html/body/div/div/header/nav/ul/li[1]/a/p");
    public final static By BUTTON_BUNS = By.xpath("//span[text() = 'Булки']");
    public final static By BUTTON_SAUCES = By.xpath("//span[text() = 'Соусы']");
    public final static By BUTTON_FILLINGS = By.xpath("//span[text() = 'Начинки']");
    public final static By BUTTON_CREATED_ORDER = By.xpath("//button[contains(text(),'Оформить заказ')]");
    public final static By SELECT_INGRIDIENTS = By.cssSelector(".tab_tab_type_current__2BEPc");
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
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
    public String textSelectIngredient() {
        return driver.findElement(SELECT_INGRIDIENTS).getText();
    }
}
