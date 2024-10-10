package ibello.spec;

import hu.ibello.core.Specification;
import hu.ibello.core.Test;
import ibello.steps.LoginSteps;

@Specification
public class LoginSpec {
    
    private LoginSteps loginSteps;
    
    @Test
    public void login() {
        loginSteps.open_demo_application();
        loginSteps.login_with_$_user("teszt.elek", "User1234");
    }
    
}
