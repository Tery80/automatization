package Oop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageLesson {

    private BaseFunction baseFunction;
    private final Logger LOGGER = LogManager.getLogger(HomePage.class);
    private final By WEB_ARTICLE = By.xpath(".//article");
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By HOME_PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");

    public HomePageLesson(BaseFunction baseFunction){
        this.baseFunction = baseFunction;
    }
    public String getTitleById(Integer id){
        List<WebElement> titles = baseFunction.getElementList(HOME_PAGE_ARTICLE);
        return titles.get(id-1).getText();
    }

    public void goToArticleById(Integer id){
        List<WebElement> titles = baseFunction.getElementList(HOME_PAGE_ARTICLE);
        baseFunction.click(titles.get(id-1));
    }
}
