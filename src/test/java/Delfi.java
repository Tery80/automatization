import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.math3.analysis.FunctionUtils.add;

public class Delfi {
    private final By WEB_ARTICLE = By.xpath(".//article");
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By PAGE_ARTICLE = By.xpath(".//h1[contains(@class,'d-inline')]");
    private final By PAGE_ARTICLE_COMMENT = By.xpath(".//div[contains(@class,'article-title')]/a");
    private final By PAGE_COMMENTS_TITLE = By.xpath(".//h1[@class='article-title']");
    private final By HOME_PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'text-red-ribbon')]");
    private final By PAGE_COMMENTS_COUNT = By.xpath(".//span[@class='type-cnt']");
    private final Integer ARTICLES_AMOUNT = 5;

    @Test
    public void delfiFirstTest() {
        System.setProperty("webdriver.chrome.driver", "d:/temp/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rus.delfi.lv/");
        List<WebElement> webArticles = driver.findElements(WEB_ARTICLE);
        List<String> webArticleNames = new ArrayList<>();
        List<Integer> commentCounts = new ArrayList<>() ;
        List<WebElement> commentExistingCheck = new ArrayList<>() ;
        String articleName = null;
        Integer commentCount = 0;
        for (int i = 0; i<(ARTICLES_AMOUNT-1); i++ ){
            articleName = webArticles.get(i).findElement(HOME_PAGE_ARTICLE).getText();
            webArticleNames.add(i,articleName);
            commentExistingCheck = webArticles.get(i).findElements(PAGE_ARTICLE_COMMENT);
            if (!commentExistingCheck.isEmpty()){
                commentCount=convertCommentsToInt(commentExistingCheck.get(0));
            }else {
                commentCount=0;
            }
            commentCounts.add(i, commentCount);
            System.out.println(articleName +" " + commentCount);
        }


//        String secondArticleTitleText = firstArticleTitleList.get(1).getText();
//        List<WebElement> homePageCommentCountList = driver.findElements(HOME_PAGE_ARTICLE_COMMENT_COUNT);
//        String homePageCommentCountSecondArticleStr = homePageCommentCountList.get(1).getText();
//        Integer homePageCommentCountSecondArticle = convertCommentsToInt(homePageCommentCountSecondArticleStr);
//        firstArticleTitleList.get(1).click();
    }
    private static Integer convertCommentsToInt(WebElement comment) {
        String commentCountStr = comment.getText().replaceAll("[()]", "");
        return Integer.parseInt(commentCountStr);
    }
}