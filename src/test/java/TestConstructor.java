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
import static org.junit.Assert.assertEquals;

public class TestConstructor {
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
        lokator.sendTextToField(FIELD_LOGIN_EMAIL, "cool.kar42138@yandex.ru");
        lokator.sendTextToField(FIELD_LOGIN_PASSWORD, "123456");
        lokator.clickToItem(BUTTON_LOGIN_ENTRANCE);
    }

    @Test
    public void constructorTabBuns() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAUCES));
        lokator.clickToItem(BUTTON_SAUCES);
        lokator.clickToItem(BUTTON_BUNS);
        String actual = lokator.textSelectIngredient();
        assertEquals("Булки", actual);
    }

    @Test
    public void constructorTabSauces() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAUCES));
        lokator.clickToItem(BUTTON_SAUCES);
        String actual = lokator.textSelectIngredient();
        assertEquals("Соусы", actual);
    }

    @Test
    public void constructorTabFILLINGS() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(BUTTON_FILLINGS));
        lokator.clickToItem(BUTTON_FILLINGS);
        String actual = lokator.textSelectIngredient();
        assertEquals("Начинки", actual);
    }

    @After
    public void quit() {
        driver.quit();
    }
}
