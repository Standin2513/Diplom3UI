import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

@Epic("Navigate burger constructor")
public class BurgerConstructorTest {
    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = open(HomePage.URL, HomePage.class);
    }

    @Test
    @DisplayName("Navigate to last bun ingredient")
    public void navigateToBunIngredient() {
        boolean isDisplayed = homePage.findBunIngredient();
        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Navigate to last sauce ingredient")
    public void navigateToSauceIngredient() {
        boolean isDisplayed = homePage.findSauceIngredient();
        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Navigate to last filling ingredient")
    public void navigateToFillingIngredient() {
        boolean isDisplayed = homePage.findFillingIngredient();
        assertTrue(isDisplayed);
    }
}
