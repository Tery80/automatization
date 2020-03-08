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

public class TvNetJavaTest {
    private final By WEB_ARTICLE = By.tagName("article");
    private final By HOME_PAGE_ARTICLE = By.xpath(".//span[contains(@class, 'list-article__headline')]");
    private final By HOME_PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");

    private final By PAGE_ARTICLE = By.xpath("//div[@class='article-content']");
    private final By PAGE_ARTICLE_TITLE = By.xpath(".//h1[@class='article-headline']");
    private final By PAGE_ARTICLE_COMMENT = By.xpath(".//span[contains(@class,'article-share__item--count')]");
    private final Logger LOGGER = LogManager.getLogger(TvNetJavaTest.class);

    @Test
    public void tvNetTest(){
        System.setProperty("webdriver.chrome.driver", "d:/temp/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LOGGER.info("Opens TVNet Page");
        driver.get("https://rus.tvnet.lv/");

        List<WebElement> webArticles = driver.findElements(WEB_ARTICLE);
        Integer homePageCommentCountSecondArticle = 0;
        String secondArticleTitleText = webArticles.get(1).findElement(HOME_PAGE_ARTICLE).getText();
        List<WebElement> commentExistingCheck = webArticles.get(1).findElements(HOME_PAGE_ARTICLE_COMMENT_COUNT);
        if (!commentExistingCheck.isEmpty()) {
            String commentCountHomePage = commentExistingCheck.get(0).getText();
            homePageCommentCountSecondArticle = convertCommentsToInt(commentCountHomePage);
        }

        LOGGER.info("Opens TVnet  Article Page");
        webArticles.get(1).click();

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
        }

        assertEquals(secondArticleTitleText,articleTitleText,"названия статей не совпадают");
        assertEquals(homePageCommentCountSecondArticle,articleCommentCount,"количество коментариев не совпадает ");


    }


    private static Integer convertCommentsToInt(String commentCountString) {
        String commentCountStr = commentCountString.replaceAll("[()]", "");
        return Integer.parseInt(commentCountStr);
    }
}
