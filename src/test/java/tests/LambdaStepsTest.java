package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private final String BASE_URL = "https://github.com";

    private final static String REPOSITORY = "neryaha/homework_5";
    private final static String ISSUE_NAME = "TestIssue1";

    @Test
    //TODO: пример ссылки на динамические логи
    public void searchForIssue() {
        step("Открываем главную страницу", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Ищем репозиторий", (step) -> {
            step.parameter("repository", REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в таб Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем что Issue с заданным текстом существует", () -> {
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }
}