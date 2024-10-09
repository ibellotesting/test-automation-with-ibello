package ibello.pages.components;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TableComponent extends PageObject {
    
    private Map<String, Integer> columnIndexes;
    
    @Find(by = By.CSS_SELECTOR, using = "table")
    private WebElement table;
    
    public void expect_that_table_is_not_empty() {
        WebElements rows = getBodyRows();
        expectations().expect(rows).toHave().sizeGreaterThan(0);
    }
    
    public WebElement get_first_row() {
        return get_row_with_index_$(0);
    }
    
    public int get_last_row_index() {
        return getBodyRows().size() - 1;
    }
    
    protected Integer getColumnIndex(String columnName) {
        if (columnIndexes == null) {
            collect_column_indexes();
        }
        Integer result = columnIndexes.get(columnName);
        if (result == null) {
            String columnNames = columnIndexes.keySet().stream()
                    .sorted()
                    .collect(Collectors.joining(", "));
            throw new TestException("Nem létező oszlop: " + columnName + ". Lehetséges oszlopnevek: " + columnNames);
        }
        return result;
    }
    
    protected void assume_$_th_$_column_have_$_value(int rowIndex, String columnName, String value) {
        WebElement row = get_row_with_index_$(rowIndex);
        assume__$_column_has_$_text_in_row(row, columnName, value);
    }
    
    @Name("assume ${1} column has ${2} text in row")
    protected void assume__$_column_has_$_text_in_row(WebElement row, String columnName, String text) {
        Integer columnIndex = getColumnIndex(columnName);
        WebElements cells = row.find().using(By.CSS_SELECTOR, "td").all();
        WebElement cell = cells.get(columnIndex);
        expectations().assume(cell).toHave().text(text);
    }
    
    protected WebElement table() {
        return table;
    }
    
    private WebElements getHeaders() {
        return table().find().using(By.CSS_SELECTOR, "thead th").all();
    }
    
    private WebElements getBodyRows() {
        return table().find().using("tbody tr").all();
    }
    
    private void collect_column_indexes() {
        columnIndexes = new HashMap<>();
        WebElements webElements = getHeaders();
        expectations().assume(webElements).toHave().sizeGreaterThan(0);
        int index = 0;
        for (WebElement elem : webElements) {
            String text = get(elem).text();
            columnIndexes.put(text, index);
            index++;
        }
    }
    
    private WebElement get_row_with_index_$(int index) {
        WebElements bodyRows = getBodyRows();
        expectations().expect(bodyRows).toHave().sizeGreaterThan(index);
        return bodyRows.get(index);
    }
    
}
