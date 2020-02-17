package tests.login;

import tests.base.BaseTests;
import org.testng.annotations.Test;
import pages.InventoryPage;

import static org.testng.Assert.assertEquals;


public class LoginTests extends BaseTests{
    private String standartUsername = "standard_user";
    private String lockedOutUsername = "locked_out_user";
    private String problemUsername = "problem_user";
    private String performanceGLitchUsername = "performance_glitch_user";
    private String password = "secret_sauce";


    @Test
    public void testSuccessfulLogin(){
        this.loginPage.login(standartUsername,password);
        InventoryPage inventoryPage = this.loginPage.clickLoginButton();

        //CORREGIR: puedo pedir el URL al objeto LoginPage que ya esta creado para no crear un nuevo objeto
        assertEquals(inventoryPage.getURL(),"https://www.saucedemo.com/inventory.html", "Couldn't Tests.login!");
    }

}
