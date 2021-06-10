package steps;

import Pages.AddEmployeePage;
import Pages.DashBoardPage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.commonMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps extends commonMethod {
    @When("user is logged in with valid admin username and password")
    public void user_is_logged_in_with_valid_admin_username_and_password() {
        LoginPage login = new LoginPage();
        sendText(login.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage login = new LoginPage();
        click(login.loginBtn);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashBoardPage dash = new DashBoardPage();
        //Assert.assertTrue(dash.welcome.isDisplayed());
        String expected = "Welcome Admin";
        String actual=dash.welcome.getText();
        Assert.assertEquals("value do not match",expected,actual);
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
       LoginPage loginPage= new LoginPage();
       sendText(loginPage.userNameBox,"johnny1234560000");
       sendText(loginPage.passwordBox,"Syntax1253!!!!");
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {

    }

    @When("user enter valid username and invalid password")
    public void user_enter_valid_username_and_invalid_password() {
        LoginPage loginPage= new LoginPage();
        sendText(loginPage.userNameBox,"Admin");
        sendText(loginPage.passwordBox,"Password");
    }

    @Then("user see invalid credentials text on login page")
    public void user_see_invalid_credentials_text_on_login_page() {
        LoginPage loginPage= new LoginPage();
        Assert.assertEquals("Invalid credentials",loginPage.errorMessage.getText());

    }
    @When("user enter {string} and {string}")
    public void user_enter_and(String username, String password) {
        LoginPage page= new LoginPage();
        sendText(page.userNameBox,username);
        sendText(page.passwordBox,password);

    }




    @When("{string} is successfully logged in")
    public void is_successfully_logged_in(String string) {
      DashBoardPage dashBoardPage= new DashBoardPage();
     String str= dashBoardPage.welcome.getText();
        System.out.println(str);
    }

    @When("user enter valid username and invalid password and verify the error")
    public void user_enter_valid_username_and_invalid_password_and_verify_the_error(DataTable errordata) throws InterruptedException {
        List<Map<String,String>> employeeNames= errordata.asMaps();
        for(Map<String,String>employeename:employeeNames){
            String userNameValue=employeename.get("username");
            String passwordNameValue=employeename.get("password");
            String errormessageValue=employeename.get("errormessage");
            System.out.println(userNameValue+" "+passwordNameValue+" "+errormessageValue);

            LoginPage loginPage= new LoginPage();
            sendText(loginPage.userNameBox,userNameValue);
            sendText(loginPage.passwordBox,passwordNameValue);
            click(loginPage.loginBtn);
            String actual = loginPage.errorMessage.getText();
            Assert.assertEquals("values do not match",errormessageValue,actual);


        }
    }

}
