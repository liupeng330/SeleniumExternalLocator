package pengliu.cf.selenium.learn;

/**
 * Created by PLiu on 2016/10/17.
 */
public class BasePage
{
    private static final String UI_LOCATOR_FILE_PATH = "src/main/resources/locators.json";
    public static final ByFactory BY_FACTORY = new ByFactory(UI_LOCATOR_FILE_PATH);
}
