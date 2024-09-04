package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Cases page")
public class CasesPage extends PageObject {

    @Find(by = By.TEXT, using = "Ügyek")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
    private WebElement title;

    @Find(by = By.CLASS_NAME, using = "panel-body")
    private WebElement panel;
    
    @Find(by = By.CLASS_NAME, using = "btn-success")
    private WebElement newCaseButton;

    public void page_must_be_loaded() {
        expectations().expect(title).toBe().displayed();
        expectations().expect(panel).toBe().displayed();
    }
    
    public void click_on_new_case_button() {
        doWith(newCaseButton).click();
    }

}
