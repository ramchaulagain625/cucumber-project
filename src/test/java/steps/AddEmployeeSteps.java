

package steps;

import Pages.AddEmployeePage;
import Pages.DashBoardPage;
import Utils.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.AddEmployeePage;
import Pages.DashBoardPage;
import Utils.commonMethod;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends commonMethod {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
    }

    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, "Nelson1234");
        sendText(add.middleName, "MS");
        sendText(add.lastName, "MS1234");
    }

    @When("user enters first name {string} middle name {string} and last name {string}")
    public void user_enters_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, firstName);
        sendText(add.middleName, middleName);
        sendText(add.lastName, lastName);
        GlobalVariable.firstName=firstName;
        GlobalVariable.middleName=middleName;
        GlobalVariable.lastName=lastName;

    }

    @When("user enters {string} {string} and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, FirstName);
        sendText(add.middleName, MiddleName);
        sendText(add.lastName, LastName);
    }

    @When("user clicks on save button option")
    public void user_clicks_on_save_button_option() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added successfully");
    }

    @When("add multiple employee and verify they are added successfully")
    public void add_multiple_employee_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
       List<Map<String,String>> employeeNames= employees.asMaps();
       for(Map<String,String>employeename:employeeNames){
           String firstNameValue=employeename.get("FirstName");
           String middleNameValue=employeename.get("MiddleName");
           String lastNameValue=employeename.get("LastName");
           System.out.println(firstNameValue+" "+middleNameValue+" "+lastNameValue);
           AddEmployeePage add = new AddEmployeePage();
           sendText(add.firstName,firstNameValue);
           sendText(add.middleName,middleNameValue);
           sendText(add.lastName,lastNameValue);
           click(add.saveBtn);
           //Assertion take it as Hw
           Thread.sleep(4000);
           DashBoardPage dash = new DashBoardPage();
           click(dash.addEmployeeButton);
           Thread.sleep(4000);

       }
    }

    @When("user adds multiple employees from excel file from {string} sheet and verify they are added")
    public void user_adds_multiple_employees_from_excel_file_from_sheet_and_verify_they_are_added(String string) throws InterruptedException {
       List<Map<String ,String>> newEmployee= ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,string);
       DashBoardPage dashBoardPage =  new DashBoardPage();
       AddEmployeePage addEmployeePage= new AddEmployeePage();
        Iterator<Map<String,String>> itr= newEmployee.iterator(); while (itr.hasNext()){
            Map<String,String> mapNewEmp = itr.next();
            sendText( addEmployeePage.firstName, mapNewEmp.get( "Firstname" ) );
            sendText( addEmployeePage.middleName, mapNewEmp.get( "Middlename" ) );
            sendText( addEmployeePage.lastName, mapNewEmp.get( "Lastname" ) );
            click( addEmployeePage.saveBtn );
            Thread.sleep( 2000 );
            //Assert
}

}





    @When("capture the employeeId")
    public void capture_the_employee_id() {
       AddEmployeePage add= new AddEmployeePage();
       GlobalVariable.empId=add.employeeId.getAttribute("value");

    }

    @Then("verify the data from frontend and backend")
    public void verify_the_data_from_frontend_and_backend() {
        System.out.println("Backend testing");
        System.out.println("Dbfirstname "+GlobalVariable.dbFirstName);
        System.out.println("Dbmiddlename "+GlobalVariable.dbMiddleName);
        System.out.println("Dblastname "+GlobalVariable.dbLastName);
        System.out.println("frontEnd testing");
        System.out.println("FirstName "+GlobalVariable.firstName);
        System.out.println("MiddleName "+GlobalVariable.middleName);
        System.out.println("LastName "+GlobalVariable.lastName);

        Assert.assertEquals("First Name doesNot match",GlobalVariable.firstName,GlobalVariable.dbFirstName);
        Assert.assertEquals("middle Name doesNot match",GlobalVariable.middleName,GlobalVariable.dbMiddleName);
        Assert.assertEquals("Last Name doesNot match",GlobalVariable.lastName,GlobalVariable.dbLastName);



    }




}

