package pengliu.cf.selenium.learn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage
{
    @FindBy(name = "aaaaqbbb")
    private WebElement textboxSearch;

    @FindBy(name = ConstantList.locator1)
    private WebElement buttonSearch;

    public void search(String text)
    {
        this.textboxSearch.sendKeys(text);
        this.buttonSearch.click();
    }
}
