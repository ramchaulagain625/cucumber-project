package Pages;

import Utils.commonMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import static Pages.LoginPage.*;

public class AddEmployeePage extends commonMethod {
    @FindBy(id="firstName")
    public WebElement firstName;
    @FindBy(id="middleName")
    public WebElement middleName;
    @FindBy(id="lastName")
    public WebElement lastName;
    @FindBy(id="employeeId")
    public WebElement employeeId;
    @FindBy(id="btnSave")
    public WebElement saveBtn;
    @FindBy(id = "photofile")
    public WebElement photograph;
    @FindBy(id = "chkLogin")
    public WebElement createLoginCheckBox;
    @FindBy(id = "user_name")
    public WebElement usernamecreate;
    @FindBy(id = "user_password")
    public WebElement userpassword;
    @FindBy(id = "re_password")
    public WebElement repassword;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }
    public static void login(String username,String password){
       sendText(userNameBox,username);
       sendText(passwordBox,password);
       click(loginBtn);

    }

}
