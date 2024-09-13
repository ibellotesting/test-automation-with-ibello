package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.steps.LoginSteps;
import ibello.steps.NewCaseSteps;

@Name("Cases")
public class CasesWorkflow extends StepLibrary {
    
    private LoginSteps loginSteps;
    private NewCaseSteps newCaseSteps;
    
    private Case data;
    
    public void a_felhasználó_az_új_ügy_rögzítési_felületen_van() {
        String username = getConfigurationValue("demo.app.username").toString();
        String password = getConfigurationValue("demo.app.password").toString();
        loginSteps.login_with_$_user(username, password);
        newCaseSteps.attempt_to_create_new_case();
    }
    
    public void a_felhasználó_kitöltötte_az_összes_adatot() {
        data = testData().fromJson(Case.class).withId("tomorrow").load();
        newCaseSteps.fill_form_with_$_data(data);
    }
    
    public void a_felhasználó_a_holnapi_napot_adja_meg_érvényességi_időnek() {
        // A tesztadat alapján így tölti ki
        output().recordCustomAction("A tesztadat alapján így tölti ki");
    }
    
    public void a_felhasználó_elmenti_az_új_ügyet() {
        newCaseSteps.attempt_to_save_new_case();
    }
    
    public void a_felhasználó_visszatér_az_ügyek_oldalra() {
        newCaseSteps.cases_page_is_loaded();
    }
    
    public void az_új_ügy_megjelenik_az_ügyek_táblázatban() {
        if (data == null) {
            throw new TestException("Nincs elmentett ügy adat");
        }
        newCaseSteps.check_new_case_with_$_data(data);
    }

}
