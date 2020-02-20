import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class DelfiFirstTest {
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By PAGE_ARTICLE = By.xpath(".//h1[contains(@class,'d-inline')]");
    private final By PAGE_ARTICLE_COMMENT = By.xpath("//div[contains(@class,'article-title')]/a");
    private final By PAGE_COMMENTS_TITLE = By.xpath("//h1[@class='article-title']");
    private final By HOME_PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'text-red-ribbon')]");
    private final By PAGE_COMMENTS_COUNT = By.xpath(".//span[@class='type-cnt']");

    @Test
    public void delfiFirstTest() {
        System.setProperty("webdriver.chrome.driver", "d:/temp/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rus.delfi.lv/");
        List<WebElement> firstArticleTitleList = driver.findElements(HOME_PAGE_ARTICLE);
        String secondArticleTitleText = firstArticleTitleList.get(1).getText();
        List<WebElement> homePageCommentCountList = driver.findElements(HOME_PAGE_ARTICLE_COMMENT_COUNT);
        String homePageCommentCountSecondArticleStr = homePageCommentCountList.get(1).getText();
        Integer homePageCommentCountSecondArticle = convertCommentsToInt(homePageCommentCountSecondArticleStr);
        firstArticleTitleList.get(1).click();

        WebElement articleTitle = driver.findElement(PAGE_ARTICLE);
        String articleTitleText = articleTitle.getText();
        WebElement articleCommentElement = driver.findElement(PAGE_ARTICLE_COMMENT_COUNT);
        String articleCommentCountStr = articleCommentElement.getText();
        Integer articleCommentCount = convertCommentsToInt(articleCommentCountStr);
        WebElement articlePageComments = driver.findElement(PAGE_ARTICLE_COMMENT);
        articlePageComments.click();

        WebElement commentsPageTitle = driver.findElement(PAGE_COMMENTS_TITLE);
        String commentsTitleText = commentsPageTitle.getText();
        List<WebElement> commentPageCommentCountList = driver.findElements(PAGE_COMMENTS_COUNT);
        Integer commentPageCommentCount = 0 ;
        String commentPageCommentCountStr;
        for (int i=0;i<2;i++){
            commentPageCommentCountStr = commentPageCommentCountList.get(i).getText();
            commentPageCommentCount = commentPageCommentCount + convertCommentsToInt(commentPageCommentCountStr);
        }

        assertEquals(secondArticleTitleText.trim(), articleTitleText.trim(), "titles first page and article page are not equals");
        assertEquals(secondArticleTitleText.trim(), commentsTitleText.trim(), "titles first page and comment page are not equals");
        assertEquals(articleTitleText.trim(), commentsTitleText.trim(), "titles article page and comment page are not equals");

        assertEquals(homePageCommentCountSecondArticle, articleCommentCount, "comments at first page and article page are different");
        assertEquals(homePageCommentCountSecondArticle, commentPageCommentCount, "comments at first page and comment page are different");
        assertEquals(commentPageCommentCount, articleCommentCount, "comments at comments page and article page are different");
        driver.quit();
    }
        private static Integer convertCommentsToInt(String commentCountString){
            String commentCountStr = commentCountString.replaceAll("[()]","") ;
            return Integer.parseInt(commentCountStr);
        }

}
