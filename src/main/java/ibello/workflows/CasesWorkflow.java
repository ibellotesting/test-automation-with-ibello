package ibello.workflows;

import hu.ibello.core.Name;
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
        loginSteps.open_demo_application();
        String username = getConfigurationValue("demo.app.username").toString();
        String password = getConfigurationValue("demo.app.password").toString();
        loginSteps.enter_$_username(username);
        loginSteps.enter_$_password(password);
        loginSteps.attempt_to_login();
        loginSteps.cases_page_is_loaded();
        newCaseSteps.attempt_to_create_new_case();
    }
    
    public void a_felhasználó_kitöltötte_az_összes_adatot() {
        Case data = testData().fromJson(Case.class).withId("today").load();
        newCaseSteps.fill_form_with_$_data(data);
    }
    
    public void a_felhasználó_a_holnapi_napot_adja_meg_érvényességi_időnek() {
        // A tesztadat alapján így tölti ki
    }
    
    public void a_felhasználó_elmenti_az_új_ügyet() {
        // TODO auto-generated method
    }
    
    public void az_új_ügy_felvétele_sikeres() {
        // TODO auto-generated method
    }
    
    public void az_új_ügy_megjelenik_az_ügyek_táblázatban() {
        // TODO auto-generated method
    }

}
