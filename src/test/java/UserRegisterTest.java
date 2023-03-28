import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import entity.User;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;
import utils.GenerateUser;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Epic("Register user")
public class UserRegisterTest {
    private User user;
    private HomePage homePage;

    @Before
    public void setUp() {
        user = GenerateUser.getRandomUser();
        homePage = open(HomePage.URL, HomePage.class);
    }

    @After
    public void clearState() {
        user = null;
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Register user by valid credentials")
    public void registerUserByValidCredentials() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword())
                .clickRegisterButton(Condition.hidden);
        assertFalse(isDisplayed);
    }

    @Test
    @DisplayName("Register user by invalid password")
    public void registerUserByInvalidPassword() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), "888")
                .clickRegisterButton(Condition.visible);
        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Register user is displayed password error")
    public void registerUserIsDisplayedPasswordError() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), "888")
                .isDisplayedPasswordError();
        assertTrue(isDisplayed);
    }
}