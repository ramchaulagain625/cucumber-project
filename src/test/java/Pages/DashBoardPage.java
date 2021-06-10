package Pages;

import Utils.commonMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DashBoardPage extends commonMethod {
    @FindBy(id="welcome")
   public  WebElement welcome;
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;
    //profile-pic
    @FindBy(xpath="//div[@class='menu']/ul/li")
    public List< WebElement> dashboardtabs;



    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }

}
