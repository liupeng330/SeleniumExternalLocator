package pengliu.cf.selenium.learn;

import org.openqa.selenium.WebElement;

public class BaiduPage extends  BasePage
{
    private static final String PAGE = "BaiduPage";

    @SearchWith(pageName = BaiduPage.PAGE, elementName ="textBoxSearch")
    private WebElement textBoxSearch;

    @SearchWith(pageName = BaiduPage.PAGE, elementName ="buttonSearch")
    private WebElement buttonSearch;

    public BaiduPage search(String text)
    {
        this.textBoxSearch.sendKeys(text);
        this.buttonSearch.click();
        return this;
    }
}
