package Pages;

import Utils.commonMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends commonMethod {
    @FindBy(id = "txtUsername")
    public static WebElement userNameBox;
    @FindBy(id = "txtPassword")
    public static WebElement passwordBox;
    @FindBy(id = "btnLogin")
    public static WebElement loginBtn;
    @FindBy(id="spanMessage")
    public static WebElement errorMessage;
    @FindBy(id="divLogo")
    WebElement logoDisplay;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        sendText(userNameBox, username);
        sendText(passwordBox, password);
        click(loginBtn);
    }
}