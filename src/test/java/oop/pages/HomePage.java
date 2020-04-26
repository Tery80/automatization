package oop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private BaseFunction baseFunction;
    private final Logger LOGGER = LogManager.getLogger(HomePage.class);
    private final By WEB_ARTICLE = By.xpath(".//article");
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By HOME_PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");

    public HomePage(BaseFunction baseFunction){
        this.baseFunction = baseFunction;
    }

    // get Articles
    public List<WebElement> getAllArticles(){

        return baseFunction.getElementList(WEB_ARTICLE);
    }
    // get Title
    public String getArticleTitle(Integer articleNumber){

        String articleTitle = getAllArticles().get(articleNumber-1).findElement(HOME_PAGE_ARTICLE).getText();

        return articleTitle;
    }
    // get COmments
    // go to next page

}
