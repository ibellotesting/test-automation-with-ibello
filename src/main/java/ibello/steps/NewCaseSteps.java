package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.pages.CasesPage;
import ibello.pages.NewCasePage;

import java.time.LocalDate;

@Name("Új ügy felvétele lépések")
public class NewCaseSteps extends StepLibrary {
    
    private CasesPage casesPage;
    private NewCasePage newCasePage;
    
    public void attempt_to_create_new_case() {
        casesPage.click_on_new_case_button();
        newCasePage.page_must_be_loaded();
    }
    
    public void fill_form_with_$_data(Case newCase) {
        if (newCase != null) {
            String name = newCase.getName();
            if (name != null) {
                newCasePage.set_name_to_$(name);
            }
            String person = newCase.getPerson();
            if (person != null) {
                newCasePage.set_person_to_$(person);
            }
            LocalDate validity = newCase.getValidity();
            if (validity != null) {
                newCasePage.set_validity_date_to_$(validity);
            }
            Integer zipCode = newCase.getZipCode();
            if (zipCode != null) {
                newCasePage.set_zip_code_to_$(zipCode);
            }
            String city = newCase.getCity();
            if (city != null) {
                newCasePage.set_city_to_$(city);
            }
            String street = newCase.getStreet();
            if (street != null) {
                newCasePage.set_street_to_$(street);
            }
            Integer number = newCase.getNumber();
            if (number != null) {
                newCasePage.set_number_to_$(number);
            }
        } else {
            throw new TestException("Az átadott Case típusú objektum null");
        }
    }
    
    public void attempt_to_save_new_case() {
        newCasePage.click_on_save_button();
    }
    
    public void cases_page_is_loaded() {
        casesPage.page_must_be_loaded();
    }
    
    public void fill_form_with_valid_data() {
        newCasePage.set_name_to_$("Teszt ügy");
        newCasePage.set_validity_date_to_$(LocalDate.now());
        newCasePage.set_person_to_$("Pum Pál");
    }
    
    public void check_new_case_with_$_data(Case expCase) {
        if (expCase != null) {
            String name = expCase.getName();
            if (name != null) {
                casesPage.assume_that_name_in_last_row_is_$(name);
            }
            String person = expCase.getPerson();
            if (person != null) {
                casesPage.assume_that_person_in_last_row_is_$(person);
            }
            LocalDate validity = expCase.getValidity();
            if (validity != null) {
                casesPage.assume_that_validity_date_in_last_row_is_$(validity);
            }
        } else {
            throw new TestException("Az átadott Case típusú objektum null");
        }
    }
    
}
