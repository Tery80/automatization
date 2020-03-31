package Oop.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PageObject {
    private  BaseFunction baseFunction = new BaseFunction();

    @Test
    public void titleCheck(){
        baseFunction.openHomePage();
        HomePageLesson homePage= new HomePageLesson(baseFunction);
        String homePageTitle = homePage.getTitleById(2);
        homePage.goToArticleById(2);

        ArticlePage articlePage = new ArticlePage(baseFunction);
        String articlePageTitle = articlePage.getTitle();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "first check");

        // assertion - после каждого вытаскивания статьи. комментов.
    }
}
