import org.example.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.MainPage.*;
import static org.example.ForgotPasswordPage.*;
import static org.example.LoginPage.*;
import static org.example.RegistrationPage.*;


@RunWith(Parameterized.class)
public class TestLoginToAccount {
    WebDriver driver;
    MainPage lokator;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        lokator = new MainPage(driver);
        lokator.goInServis();
    }

    private final By button;

    public TestLoginToAccount(By button) {
        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[][] getParameter() {
        return new Object[][] {
                {BUTTON_LOG_IN_ACCOUNT},
                {BUTTON_PERSONAL_ACCOUNT},
        };
    };

    @Test
    public void loginToAcc() {
            lokator.clickToItem(button);
            lokator.sendTextToField(FIELD_LOGIN_EMAIL, "cool.kar42137@yandex.ru");
            lokator.sendTextToField(FIELD_LOGIN_PASSWORD, "123456");
            lokator.clickToItem(BUTTON_LOGIN_ENTRANCE);
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CREATED_ORDER));
            Assert.assertTrue(driver.findElement(BUTTON_CREATED_ORDER).isDisplayed());
    }

    @Test
    public void loginToAccInRestration() {
        lokator.clickToItem(BUTTON_LOG_IN_ACCOUNT);
        lokator.clickToItem(BUTTON_REGISTER);
        lokator.clickToItem(BUTTON_LOGIN_IN_REGISTRATION);
        lokator.sendTextToField(FIELD_LOGIN_EMAIL,"cool.kar42137@yandex.ru");
        lokator.sendTextToField(FIELD_LOGIN_PASSWORD,"123456");
        lokator.clickToItem(BUTTON_LOGIN_ENTRANCE);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CREATED_ORDER));
        Assert.assertTrue(driver.findElement(BUTTON_CREATED_ORDER).isDisplayed());
    }

    @Test
    public void loginToAccInFoggotPassword(){
        lokator.clickToItem(BUTTON_LOG_IN_ACCOUNT);
        lokator.clickToItem(BUTTON_FOGGOT_PASSWORD);
        lokator.clickToItem(BUTTON_LOGIN_IN_FOGGOT_PASSWORD);
        lokator.sendTextToField(FIELD_LOGIN_EMAIL,"cool.kar42137@yandex.ru");
        lokator.sendTextToField(FIELD_LOGIN_PASSWORD,"123456");
        lokator.clickToItem(BUTTON_LOGIN_ENTRANCE);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CREATED_ORDER));
    }

    @After
    public void quit() {
        driver.quit();
    }
}
