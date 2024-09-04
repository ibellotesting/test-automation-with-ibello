package ibello.pages;

import hu.ibello.actions.Key;
import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

import java.time.LocalDate;

@Name("Cases page")
public class NewCasePage extends PageObject {

    @Find(by = By.TEXT, using = "Új ügy")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
    private WebElement title;

    @Find(by = By.CLASS_NAME, using = "panel-body")
    private WebElement panel;
    
    @Find(by = By.ID, using = "name")
    private WebElement nameField;
    
    @Find(by = By.ID, using = "person")
    private WebElement personField;
    
    @Find(by = By.ID, using = "zipCode")
    private WebElement zipCodeField;
    
    @Find(by = By.ID, using = "city")
    private WebElement cityField;
    
    @Find(by = By.ID, using = "street")
    private WebElement streetField;
    
    @Find(by = By.ID, using = "number")
    private WebElement numberField;
    
    @Find(by = By.ID, using = "validity")
    private WebElement validityField;
    
    @Find(by = By.BUTTON_TEXT, using = "Mentés")
    private WebElement saveButton;

    public void page_must_be_loaded() {
        expectations().expect(title).toBe().displayed();
        expectations().expect(panel).toBe().displayed();
    }
    
    public void set_name_to_$(String name) {
        doWith(nameField).setValue(name);
    }
    
    public void set_person_to_$(String person) {
        doWith(personField).setValue(person);
    }
    
    public void set_zip_code_to_$(int zipCode) {
        doWith(zipCodeField).setValue(String.valueOf(zipCode));
    }
    
    public void set_city_to_$(String city) {
        doWith(cityField).setValue(city);
    }
    
    public void set_street_to_$(String street) {
        doWith(streetField).setValue(street);
    }
    
    public void set_number_to_$(int number) {
        doWith(numberField).setValue(String.valueOf(number));
    }
    
    public void set_validity_date_to_$(LocalDate date) {
        int year = date.getYear();
        int month = date.getMonth().getValue();
        int day = date.getDayOfMonth();
        doWith(validityField).sendKeys(String.valueOf(year));
        doWith(validityField).sendKeys(Key.TAB);
        doWith(validityField).sendKeys(String.valueOf(month));
        doWith(validityField).sendKeys(String.valueOf(day));
    }
    
    public void click_on_save_button() {
        doWith(saveButton).click();
    }

}
