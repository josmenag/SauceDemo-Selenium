package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private By usernameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginButton = By.cssSelector(".btn_action");

    @FindBy (id = "user-name")
    private WebElement userName;

    @FindBy (id = "password")
    private WebElement password;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        driver.findElement(loginButton).click();
    }

}
