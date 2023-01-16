import org.example.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.MainPage.*;
import static org.example.ForgotPasswordPage.*;
import static org.example.PersonalAccountPage.*;
import static org.example.LoginPage.*;

import static org.junit.Assert.assertEquals;

public class TestTransferToAccount {
    WebDriver driver;
    MainPage lokator;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        lokator = new MainPage(driver);
        lokator.goInServis();

        lokator.clickToItem(BUTTON_LOG_IN_ACCOUNT);
        lokator.clickToItem(BUTTON_FOGGOT_PASSWORD);
        lokator.clickToItem(BUTTON_LOGIN_IN_FOGGOT_PASSWORD);
        lokator.sendTextToField(FIELD_LOGIN_EMAIL,"cool.kar42137@yandex.ru");
        lokator.sendTextToField(FIELD_LOGIN_PASSWORD,"123456");
    }

    @Test
    public void transferToAccount(){
        lokator.clickToItem(BUTTON_LOGIN_ENTRANCE);
        lokator.clickToItem(BUTTON_PERSONAL_ACCOUNT);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_EXIT_PERSONAL_ACCOUNT));
        assertEquals("Выход", driver.findElement(BUTTON_EXIT_PERSONAL_ACCOUNT).getText());
    }
    @After
    public void quit() {
        driver.quit();
    }
}
