package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.pages.CasesPage;
import ibello.pages.NewCasePage;

@Name("Új ügy felvétele lépések")
public class NewCaseSteps extends StepLibrary {
    
    private CasesPage casesPage;
    private NewCasePage newCasePage;
    
    public void attempt_to_create_new_case() {
        casesPage.page_must_be_loaded();
        casesPage.click_on_new_case_button();
        newCasePage.page_must_be_loaded();
    }
    
    public void fill_form_with_$_data(Case data) {
        if (data != null) {
            String name = data.getName();
            if (name != null) {
                newCasePage.set_name_to_$(name);
            }
        }
    }
    
    public void attempt_to_save_new_case() {
        newCasePage.click_on_save_button();
    }

    public void new_case_registration_is_successful() {
    
    }
    
    public void new_case_contains_the_given_information(Case data) {
    
    }
    
}
