package pengliu.cf.selenium.learn;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by peng on 10/16/16.
 */
public class Runner
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver",
                "/Users/peng/IdeaProjects/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.jp/");
        GooglePage page = PageFactory.initElements(driver, GooglePage.class);
        page.search("cl");
    }
}
