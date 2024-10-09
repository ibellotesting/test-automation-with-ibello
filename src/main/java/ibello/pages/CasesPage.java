package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;
import ibello.tools.DateTool;

import java.time.LocalDate;

@Name("Cases page")
public class CasesPage extends PageObject {

    @Find(by = By.TEXT, using = "Ügyek")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
    private WebElement title;

    @Find(by = By.CLASS_NAME, using = "panel-body")
    private WebElement panel;
    
    @Find(by = By.CLASS_NAME, using = "btn-success")
    private WebElement newCaseButton;
    
    @Find(by = By.CSS_SELECTOR, using = "tbody tr")
    private WebElements tableRows;
    
    @Find(by = By.CSS_SELECTOR, using = "table")
    private WebElement table;
    
    public void page_must_be_loaded() {
        expectations().expect(title).toBe().displayed();
        expectations().expect(panel).toBe().displayed();
    }
    
    public void click_on_new_case_button() {
        doWith(newCaseButton).click();
    }
    
    public void assume_that_name_in_last_row_is_$(String expName) {
        expectations().assume(get_cell_from_last_row(2)).toHave().text(expName);
    }
    
    public void assume_that_person_in_last_row_is_$(String expPerson) {
        expectations().assume(get_cell_from_last_row(3)).toHave().text(expPerson);
    }
    
    public void assume_that_validity_date_in_last_row_is_$(LocalDate expValidityDate) {
        String expDateText = DateTool.localDateToString(expValidityDate);
        expectations().assume(get_cell_from_last_row(4)).toHave().text(expDateText);
    }
    
    private WebElement get_cell_from_last_row(int index) {
        WebElement lastRow = get_last_row();
        WebElements cells = lastRow.find().using(By.CSS_SELECTOR, "td").all();
        return cells.get(index);
    }
    
    private WebElement get_last_row() {
        return tableRows.get(tableRows.size() - 1);
    }

}
