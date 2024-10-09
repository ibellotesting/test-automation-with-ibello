package ibello.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import ibello.pages.components.TableComponent;

public class CasesTable extends TableComponent {
    
    @Find(by = By.CSS_SELECTOR, using = "app-valami-xy table")
    private WebElement table;
    
    public void assume_that_new_case_has_$_name(String name) {
        int lastRowIndex = get_last_row_index();
        assume_$_th_$_column_have_$_value(lastRowIndex, "Megnevezés", name);
    }
    
    @Override
    protected WebElement table() {
        return table;
    }
}
