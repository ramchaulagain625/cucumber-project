package steps;

import Pages.DashBoardPage;
import Pages.EmployeeListPage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.commonMethod;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class EmployeeSearchSteps extends commonMethod {

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage= new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox,ConfigReader.getPropertyValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.pimOption);
        click(dash.employeeListOption);
    }
    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage emp= new EmployeeListPage();
        sendText(emp.employeeName,"Rammani");
        click(emp.searchButton);
    }


    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage emp= new EmployeeListPage();
        sendText(emp.idEmployee,"15518");
        click(emp.searchButton);

    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage emp= new EmployeeListPage();
        click(emp.searchButton);
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Employee name is displayed");

    }
    @Then("user select the employee from employee table")
    public void user_select_the_employee_from_employee_table() throws InterruptedException {
        DashBoardPage dashBoardPage= new DashBoardPage();
        click(dashBoardPage.employeeListOption);
        Thread.sleep(5000);
        EmployeeListPage employeeListPage= new EmployeeListPage();
        sendText(employeeListPage.employeeName,"Rammani chaulagain");
        click(employeeListPage.searchButton);
        Thread.sleep(5000);
        click(employeeListPage.employeeList);
       // Thread.sleep(8000);
    }

    @Then("user click to the edit button")
    public void user_click_to_the_edit_button() {
        EmployeeListPage employeeListPage= new EmployeeListPage();
        click(employeeListPage.saveAndEditButton);

    }
    @Then("user is able to edit the employee and save the employee")
    public void user_is_able_to_edit_the_employee_and_save_the_employee() {
        EmployeeListPage employeeListPage= new EmployeeListPage();
        employeeListPage.firstName.clear();
        sendText(employeeListPage.firstName,"Ram12345");
        employeeListPage.middleName.clear();
        sendText(employeeListPage.middleName,"Test123456");
        employeeListPage.lastName.clear();
        sendText(employeeListPage.lastName,"Chaulagain12356");
        click(employeeListPage.saveAndEditButton);
        String actual=employeeListPage.actualText.getText();
        String expected="Ram12345 Test123456 Chaulagain12356";
        Assert.assertEquals("expected vs actual test",actual,expected);

    }

}
