package steps;

import Utils.DbUtils;
import Utils.GlobalVariable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DbSteps {
    @Then("query the HRMS database")
    public void query_the_hrms_database() {
        String query = "select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where employee_id=" + GlobalVariable.empId;
        List<Map<String, String>> tableDataAsList = DbUtils.getTableDataAsList(query);
        GlobalVariable.dbFirstName=tableDataAsList.get(0).get("emp_firstname");
        GlobalVariable.dbMiddleName=tableDataAsList.get(0).get("emp_middle_name");
        GlobalVariable.dbLastName=tableDataAsList.get(0).get("emp_lastname");


    }
}