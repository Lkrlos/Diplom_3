import org.example.MainPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.example.MainPage.*;
import static org.example.LoginPage.*;
import static org.example.RegistrationPage.*;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TestRegistration {
    WebDriver driver;
    MainPage lokator;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        lokator = new MainPage(driver);
        lokator.goInServis();
    }

    private final String name;
    private final String email;
    private final String password;
    private final String expectedText;
    private final By equalsLokator;

    public TestRegistration(String name, String email, String password,String expectedText, By equalsLokator) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.expectedText = expectedText;
        this.equalsLokator = equalsLokator;
    }

    @Parameterized.Parameters
    public static Object[][] getParameter() {
        return new Object[][] {
                {"Карлос","cool.karlos@yandex.ru","123456","Зарегистрироваться", BUTTON_REGISTER},
                {"Карлос","cool.karlos@yandex.ru","12345","Некорректный пароль", EXPECTED_TEXT_REGISTRATION_FALIED_PASSWORD},
        };
    }
    @Test
    public void registrationExpected() {
        lokator.clickToItem(BUTTON_LOG_IN_ACCOUNT);
        lokator.clickToItem(BUTTON_REGISTER);
        lokator.sendTextToField(BUTTON_FIELD_NAME, name);
        lokator.sendTextToField(BUTTON_FIELD_EMAIL, email);
        lokator.sendTextToField(BUTTON_FIELD_PASSWORD, password);
        lokator.clickToItem(BUTTON_REGISTER_FINAL);
        assertEquals(expectedText, driver.findElement(equalsLokator).getText());
    }

    @After
    public void quit() {
        driver.quit();
    }
}
