package ibello.pages;

import hu.ibello.actions.Key;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;

import java.time.LocalDate;

public class AbstractPageObject extends PageObject {
    
    protected void set_date_field(WebElement dateField, LocalDate date) {
        int year = date.getYear();
        int month = date.getMonth().getValue();
        int day = date.getDayOfMonth();
        doWith(dateField).sendKeys(String.valueOf(year));
        doWith(dateField).sendKeys(Key.TAB);
        doWith(dateField).sendKeys(String.valueOf(month));
        doWith(dateField).sendKeys(String.valueOf(day));
    }
    
}
