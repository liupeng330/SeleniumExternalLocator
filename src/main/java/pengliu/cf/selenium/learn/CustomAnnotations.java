package pengliu.cf.selenium.learn;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;
import java.lang.reflect.Field;

public class CustomAnnotations extends Annotations
{
    public CustomAnnotations(Field field)
    {
        super(field);
    }

    @Override
    public By buildBy()
    {
        SearchWith search = this.getField().getAnnotation(SearchWith.class);
        Preconditions.checkArgument(search != null, "Failed to locate the annotation @SearchWith");
        String elementName = search.elementName();
        String pageName = search.pageName();
        Preconditions.checkArgument(StringUtils.isNotEmpty(elementName), "Element elementName is not found.");
        Preconditions.checkArgument(StringUtils.isNotEmpty(pageName), "Page elementName is missing.");

        return BasePage.BY_FACTORY.createBy(pageName, elementName);
    }
}
