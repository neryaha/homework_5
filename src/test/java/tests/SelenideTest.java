package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "neryaha/homework_5";
    private final static String ISSUE_NAME = "TestIssue1";

    @Test
    @DisplayName("Селенидовский логгер")
    public void testIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }

}