package tests;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private final static String REPOSITORY = "neryaha/homework_5";
    private final static String ISSUE_NAME = "TestIssue1";

    private WebSteps steps = new WebSteps();

    @Test
    public void testSearch() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }

}
