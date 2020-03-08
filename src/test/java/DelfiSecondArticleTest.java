import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DelfiSecondArticleTest {
    private final By WEB_ARTICLE = By.xpath(".//article");
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By HOME_PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");

    private final By PAGE_ARTICLE = By.xpath("//div[contains(@class,'article-title')]");
    private final By PAGE_ARTICLE_TITLE = By.xpath(".//h1");
    private final By PAGE_ARTICLE_COMMENT = By.xpath(".//a");

    private final By PAGE_COMMENTS_TITLE = By.xpath(".//h1[@class='article-title']");

    private final By PAGE_COMMENTS_COUNT = By.xpath(".//span[@class='type-cnt']");
    private final Integer ARTICLES_NUMBER = 1;
    private final Logger LOGGER = LogManager.getLogger(Delfi.class);

    @Test
    public void delfiFirstTest() {
        System.setProperty("webdriver.chrome.driver", "d:/temp/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LOGGER.info("Opens Delfi Page");
        driver.get("https://rus.delfi.lv/");

        LOGGER.info("Placed all Articles+Comments in the List");
        List<WebElement> webArticles = driver.findElements(WEB_ARTICLE);
        Integer homePageCommentCountSecondArticle = 0;

        String secondArticleTitleText = webArticles.get(ARTICLES_NUMBER - 1).findElement(HOME_PAGE_ARTICLE).getText();
        List<WebElement> commentExistingCheck = webArticles.get(ARTICLES_NUMBER - 1).findElements(HOME_PAGE_ARTICLE_COMMENT_COUNT);
        if (!commentExistingCheck.isEmpty()) {
            String commentCountHomePage = commentExistingCheck.get(0).getText();
            homePageCommentCountSecondArticle = convertCommentsToInt(commentCountHomePage);
        }
        LOGGER.info("Opens Delfi  Article Page");
        webArticles.get(ARTICLES_NUMBER - 1).click();

        List<WebElement> pageArticles = driver.findElements(PAGE_ARTICLE);
        String articleTitleText = pageArticles.get(0).findElement(PAGE_ARTICLE_TITLE).getText();
        List<WebElement> commentExistingCheckPage = pageArticles.get(0).findElements(PAGE_ARTICLE_COMMENT);
        Integer articleCommentCount = 0;
        if (!commentExistingCheckPage.isEmpty()) {
            String commentCountArticlePage = commentExistingCheckPage.get(0).getText();
            articleCommentCount = convertCommentsToInt(commentCountArticlePage);
        } else {
            LOGGER.info("Comments are missing."); 
            LOGGER.info("Check article names at main and article page");
            assertEquals(secondArticleTitleText.trim(), articleTitleText.trim(), "titles first page and article page are not equals");
            System.out.println("Articles are the same, but there are no comment at all");
            driver.quit();
            System.exit(0);
        }
        LOGGER.info("Opens Delfi Comment Page");
        commentExistingCheckPage.get(0).click();

        WebElement commentsPageTitle = driver.findElement(PAGE_COMMENTS_TITLE);
        String commentsTitleText = commentsPageTitle.getText();
        List<WebElement> commentPageCommentCountList = driver.findElements(PAGE_COMMENTS_COUNT);
        Integer commentPageCommentCount = 0;
        String commentPageCommentCountStr;
        for (int i = 0; i < 2; i++) {
            commentPageCommentCountStr = commentPageCommentCountList.get(i).getText();
            commentPageCommentCount = commentPageCommentCount + convertCommentsToInt(commentPageCommentCountStr);
        }

        LOGGER.info("Start to compare Article names");
        assertEquals(secondArticleTitleText.trim(), articleTitleText.trim(), "titles first page and article page are not equals");
        assertEquals(secondArticleTitleText.trim(), commentsTitleText.trim(), "titles first page and comment page are not equals");
        assertEquals(articleTitleText.trim(), commentsTitleText.trim(), "titles article page and comment page are not equals");
        LOGGER.info("Start to compare comment counts");
        assertEquals(homePageCommentCountSecondArticle, articleCommentCount, "comments at first page and article page are different");
        assertEquals(homePageCommentCountSecondArticle, commentPageCommentCount, "comments at first page and comment page are different");
        assertEquals(commentPageCommentCount, articleCommentCount, "comments at comments page and article page are different");
        driver.quit();
    }

    private static Integer convertCommentsToInt(String commentCountString) {
        String commentCountStr = commentCountString.replaceAll("[()]", "");
        return Integer.parseInt(commentCountStr);
    }
}