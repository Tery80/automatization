package Oop.pages;

import org.openqa.selenium.By;

public class ArticlePage {
    private BaseFunction baseFunction;
    private final By TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");

    public ArticlePage(BaseFunction baseFunction) {
        this.baseFunction = baseFunction;
    }

    public String getTitle(){
        return baseFunction.getElement(TITLE).getText();
    }
}
