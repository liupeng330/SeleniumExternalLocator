package pengliu.cf.selenium.learn;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class ByFactory
{
    private String locatorFilePath;

    public ByFactory(String locatorFilePath)
    {
        this.locatorFilePath = locatorFilePath;
    }

    public By createBy(String pageName, String elementName)
    {
        Preconditions.checkArgument(StringUtils.isNotEmpty(pageName), "Page elementName is missing.");
        Preconditions.checkArgument(StringUtils.isNotEmpty(elementName), "Element elementName is missing.");

        File file = new File(this.locatorFilePath);
        Preconditions.checkArgument(file.exists(), "Unable to locate " + this.locatorFilePath);
        try
        {
            JsonArray array = new JsonParser().parse(new FileReader(file)).getAsJsonArray();
            Iterator<JsonElement> iterator = array.iterator();
            JsonObject foundObject = null;
            while (iterator.hasNext())
            {
                JsonObject object = iterator.next().getAsJsonObject();
                if (pageName.equalsIgnoreCase(object.get("pageName").getAsString()) &&
                        elementName.equalsIgnoreCase(object.get("elementName").getAsString()))
                {
                    foundObject = object;
                    break;
                }
            }
            Preconditions.checkState(foundObject != null, "No entry found for the page [" + pageName + "] in the "
                    + "locators file [" + this.locatorFilePath + "]");
            String locateUsing = foundObject.get("locateUsing").getAsString();
            String locator = foundObject.get("locator").getAsString();
            Preconditions.checkArgument(StringUtils.isNotEmpty(locator), "Locator cannot be null (or) empty.");

            if (("xpath".equalsIgnoreCase(locateUsing)))
            {
                return new By.ByXPath(locator);
            }
            if (("id".equalsIgnoreCase(locateUsing)))
            {
                return new By.ById(locator);
            }
            if (("elementName".equalsIgnoreCase(locateUsing)))
            {
                return new By.ByName(locator);
            }
            if (("className".equalsIgnoreCase(locateUsing)))
            {
                return new By.ByClassName(locator);
            }
            if (("css".equalsIgnoreCase(locateUsing)))
            {
                return new By.ByCssSelector(locator);
            }
            if (("tagName".equalsIgnoreCase(locateUsing)))
            {
                return new By.ByTagName(locator);
            }
            if (("linkText".equalsIgnoreCase(locateUsing)))
            {
                return new By.ByLinkText(locator);
            }
            if (("partialLinkText".equalsIgnoreCase(locateUsing)))
            {
                return new By.ByPartialLinkText(locator);
            }
            throw new UnsupportedOperationException("Currently " + locateUsing + " is NOT supported.");
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
