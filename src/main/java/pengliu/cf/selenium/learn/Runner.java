package pengliu.cf.selenium.learn;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Created by peng on 10/16/16.
 */
public class Runner
{
    public static void main(String[] args)
    {
//        System.setProperty("webdriver.chrome.driver",
//                "/Users/peng/IdeaProjects/chromedriver");
        System.setProperty("webdriver.chrome.driver",
                "D:\\codes\\LPISelenium\\src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        ElementLocatorFactory factory = new FileBasedElementLocatorFactory(driver);
        BaiduPage page = new BaiduPage();
        PageFactory.initElements(factory, page);
        page.search("pengliu.cf");
    }
}
