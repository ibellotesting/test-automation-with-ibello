package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.pages.LoginPage;

@Name("Login steps")
public class LoginSteps extends StepLibrary{
    
    private LoginPage loginPage;
    
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
    
    }
    
    @Name("login with ${0} user")
    public void login_with_$_user(String username, String password) {
        open_demo_application();
        enter_$_username(username);
        enter_$_password(password);
        attempt_to_login();
        cases_page_is_loaded();
    }
    
}
