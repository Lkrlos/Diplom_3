import org.example.MainPage;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.MainPage.*;
import static org.example.ForgotPasswordPage.*;
import static org.example.LoginPage.*;


public class TestTransferOnAccouncToConstructor {
    WebDriver driver;
    MainPage lokator;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        lokator = new MainPage(driver);
        lokator.goInServis();

        lokator.clickToItem(BUTTON_LOG_IN_ACCOUNT);
        lokator.clickToItem(BUTTON_FOGGOT_PASSWORD);
        lokator.clickToItem(BUTTON_LOGIN_IN_FOGGOT_PASSWORD);
        lokator.sendTextToField(FIELD_LOGIN_EMAIL, "cool.kar42138@yandex.ru");
        lokator.sendTextToField(FIELD_LOGIN_PASSWORD, "123456");
        lokator.clickToItem(BUTTON_LOGIN_ENTRANCE);
        lokator.clickToItem(BUTTON_PERSONAL_ACCOUNT);
    }

    @Test
    public void transferToButtonConstructor() {
        lokator.clickToItem(BUTTON_DESIGNER);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAUCES));
    }

    @Test
    public void transferToButtonLogo() {
        lokator.clickToItem(BUTTON_LOGO);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAUCES));
    }

    @After
    public void quit() {
        driver.quit();
    }
}