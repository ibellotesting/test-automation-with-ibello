package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.pages.CasesPage;
import ibello.pages.LoginPage;

@Name("Bejelentkezés lépések")
public class LoginSteps extends StepLibrary {
    
    private static final String LOGIN_ERROR_MSG = "A felhasználói név és/vagy jelszó nem megfelelő.";
    private LoginPage loginPage;
    private CasesPage casesPage;

    public void open_demo_application() {
        loginPage.open_demo_page();
        loginPage.page_must_be_loaded();
    }
    
    public void enter_$_username(String username) {
        loginPage.set_username_to_$(username);
    }
    
    public void enter_$_password(String password) {
        loginPage.set_password_to_$(password);
    }

    public void attempt_to_login() {
        loginPage.click_on_login_button();
    }
    
    public void cases_page_is_loaded() {
        casesPage.page_must_be_loaded();
    }
    
    public void login_page_is_loaded() {
        loginPage.page_must_be_loaded();
    }
    
    public void login_error_is_displayed() {
        loginPage.error_message_should_be_displayed();
        loginPage.$_error_message_should_be_displayed(LOGIN_ERROR_MSG);
    }
    
    public void login_to_demo_app() {
        open_demo_application();
        enter_$_username(getConfigurationValue("demo.app.username").toString());
        enter_$_password(getConfigurationValue("demo.app.password").toString());
        loginPage.click_on_login_button();
        casesPage.page_must_be_loaded();
    }

}
