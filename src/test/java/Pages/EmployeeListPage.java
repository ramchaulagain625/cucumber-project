package Pages;

import Utils.commonMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class EmployeeListPage extends commonMethod {
    @FindBy(id="empsearch_id")
    public WebElement idEmployee;
    @FindBy(id="searchBtn")
    public WebElement searchButton;
    @FindBy(id="empsearch_employee_name_empName")
    public WebElement employeeName;
    @FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")
    public WebElement employeeList;
    @FindBy(id="btnSave")
    public WebElement saveAndEditButton;
    @FindBy(id="personal_txtEmpFirstName")
    public WebElement firstName;
    @FindBy(id="personal_txtEmpMiddleName")
    public WebElement middleName;
    @FindBy(id="personal_txtEmpLastName")
    public WebElement lastName;
    @FindBy(id="profile-pic")
    public WebElement actualText;


   public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }
}
