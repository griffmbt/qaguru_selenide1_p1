package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverTest {
    @Test
    void shouldTitleFromPageProduct() {
        open("https://github.com/");

        //верстка страницы изменилась, поэтому заменил "Pricing" на "Product".
        $("header").$(byText("Product")).hover();

        // нашел в выпадающем списаке "Packages"
        $(byText("Packages")).click();

        // и в открывшейся странице нашел заголовок.
        $("h1").shouldHave(text("Your packages,\n" + "at home with their code"));
    }
}
