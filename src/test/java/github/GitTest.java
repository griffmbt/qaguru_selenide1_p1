package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitTest {
    @Test
    void shouldFindText() {
        open("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $$("ul.list-style-none.m-0.p-0 li").findBy(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
